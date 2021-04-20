package battleaimod.savestate.monsters;

import basemod.ReflectionHacks;
import battleaimod.savestate.Monster;
import battleaimod.savestate.MonsterState;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.city.Mugger;

public class MuggerState extends MonsterState {

    private final int slashCount;
    private final int stolenGold;

    public MuggerState(AbstractMonster monster) {
        super(monster);

        slashCount = ReflectionHacks
                .getPrivate(monster, Mugger.class, "slashCount");
        stolenGold = ReflectionHacks
                .getPrivate(monster, Mugger.class, "stolenGold");

        monsterTypeNumber = Monster.MUGGER.ordinal();
    }

    public MuggerState(String jsonString) {
        super(jsonString);

        // TODO don't parse twice
        JsonObject parsed = new JsonParser().parse(jsonString).getAsJsonObject();

        this.slashCount = parsed.get("slash_count").getAsInt();
        this.stolenGold = parsed.get("stolen_gold").getAsInt();

        monsterTypeNumber = Monster.MUGGER.ordinal();
    }

    @Override
    public AbstractMonster loadMonster() {
        Mugger monster = new Mugger(offsetX, offsetY);
        populateSharedFields(monster);

        ReflectionHacks
                .setPrivate(monster, Mugger.class, "slashCount", slashCount);
        ReflectionHacks
                .setPrivate(monster, Mugger.class, "stolenGold", stolenGold);
        return monster;
    }

    @Override
    public String encode() {
        JsonObject monsterStateJson = new JsonParser().parse(super.encode()).getAsJsonObject();

        monsterStateJson.addProperty("slash_count", slashCount);
        monsterStateJson.addProperty("stolen_gold", stolenGold);

        return monsterStateJson.toString();
    }
}
