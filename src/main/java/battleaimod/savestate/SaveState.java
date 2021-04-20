package battleaimod.savestate;

import battleaimod.BattleAiMod;
import battleaimod.GameStateListener;
import battleaimod.battleai.BattleAiController;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

public class SaveState {
    int floorNum;
    boolean previousScreenUp;
    boolean myTurn = false;
    public int turn;
    public String encounterName;

    AbstractRoom.RoomPhase previousPhase = null;
    AbstractDungeon.CurrentScreen screen;
    AbstractDungeon.CurrentScreen previousScreen = null;

    ListState listState;
    public PlayerState playerState;
    RngState rngState;

    public MapRoomNodeState curMapNodeState;

    public SaveState() {
        this.curMapNodeState = new MapRoomNodeState(AbstractDungeon.currMapNode);
        playerState = new PlayerState(AbstractDungeon.player);
        screen = AbstractDungeon.screen;
        rngState = new RngState();
        listState = new ListState();
        floorNum = AbstractDungeon.floorNum;

        this.turn = GameActionManager.turn;
        previousScreen = GameStateListener.previousScreen;
        previousScreenUp = GameStateListener.previousScreenUp;
        previousPhase = GameStateListener.previousPhase;
        myTurn = GameStateListener.myTurn;
        encounterName = BattleAiController.currentEncounter;
    }

    public SaveState(String jsonString) {
        JsonObject parsed = new JsonParser().parse(jsonString).getAsJsonObject();

        this.floorNum = parsed.get("floor_num").getAsInt();
        this.previousScreenUp = parsed.get("previous_screen_up").getAsBoolean();
        this.myTurn = parsed.get("my_turn").getAsBoolean();
        this.turn = parsed.get("turn").getAsInt();

        this.previousPhase = AbstractRoom.RoomPhase
                .valueOf(parsed.get("previous_phase_name").getAsString());

        this.screen = AbstractDungeon.CurrentScreen
                .valueOf(parsed.get("screen_name").getAsString());
        this.previousScreen = AbstractDungeon.CurrentScreen
                .valueOf(parsed.get("previous_screen_name").getAsString());
        this.encounterName = parsed.get("encounter_name").isJsonNull() ? null : parsed
                .get("encounter_name").getAsString();

        this.listState = new ListState(parsed.get("list_state").getAsString());
        this.playerState = new PlayerState(parsed.get("player_state").getAsString());
        this.rngState = new RngState(parsed.get("rng_state").getAsString());

        this.curMapNodeState = new MapRoomNodeState(parsed.get("cur_map_node_state").getAsString());
    }

    public void loadState() {
        long loadStartTime = System.currentTimeMillis();

        GameActionManager.turn = this.turn;

//        long point1 = System.currentTimeMillis();

        AbstractDungeon.player = playerState.loadPlayer();

        if (BattleAiMod.battleAiController != null) {
            BattleAiMod.battleAiController.playerLoadTime += (System
                    .currentTimeMillis() - loadStartTime);
        }

        long point2 = System.currentTimeMillis();
        curMapNodeState.loadMapRoomNode(AbstractDungeon.currMapNode);


        if (BattleAiMod.battleAiController != null) {
            BattleAiMod.battleAiController.roomLoadTime += (System
                    .currentTimeMillis() - point2);
        }

        AbstractDungeon.screen = screen;

        AbstractDungeon.isScreenUp = false;
        listState.loadLists();

        AbstractDungeon.dungeonMapScreen.close();

        AbstractDungeon.screen = AbstractDungeon.CurrentScreen.NONE;

        AbstractDungeon.floorNum = floorNum;

        BattleAiMod.readyForUpdate = true;

        CombatRewardScreenState.loadCombatRewardScreen();

        rngState.loadRng();

        GameStateListener.previousScreen = previousScreen;
        GameStateListener.previousScreenUp = previousScreenUp;
        GameStateListener.previousPhase = previousPhase;
        GameStateListener.myTurn = myTurn;
        GameStateListener.externalChange = true;

        if (BattleAiMod.battleAiController != null) {
            BattleAiMod.battleAiController.loadstateTime += (System
                    .currentTimeMillis() - loadStartTime);

        }

//        System.err
//                .printf("load time: %d\tpart 1:%d\tpart2:%d\n", System
//                        .currentTimeMillis() - point1, point2 - point1, System
//                        .currentTimeMillis() - point2);
    }

    public int getPlayerHealth() {
        return playerState.getCurrentHealth();
    }

    public String getPlayerHand() {
        return playerState.getHandString();
    }

    public int getNumSlimes() {
        return playerState.getNumSlimes();
    }

    public int getNumBurns() {
        return playerState.getNumBurns();
    }

    public String encode() {
        JsonObject saveStateJson = new JsonObject();

        saveStateJson.addProperty("floor_num", floorNum);
        saveStateJson.addProperty("previous_screen_up", previousScreenUp);
        saveStateJson.addProperty("my_turn", myTurn);
        saveStateJson.addProperty("turn", turn);

        saveStateJson.addProperty("previous_phase_name", previousPhase.name());
        saveStateJson.addProperty("screen_name", screen.name());
        saveStateJson.addProperty("previous_screen_name", previousScreen.name());

        saveStateJson.addProperty("list_state", listState.encode());
        saveStateJson.addProperty("player_state", playerState.encode());
        saveStateJson.addProperty("rng_state", rngState.encode());

        saveStateJson.addProperty("cur_map_node_state", curMapNodeState.encode());
        saveStateJson.addProperty("encounter_name", encounterName);

        return saveStateJson.toString();
    }
}
