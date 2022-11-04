package battleaimod;

import battleaimod.battleai.StateNode;
import battleaimod.battleai.TurnNode;

import com.megacrit.cardcrawl.cards.red.*;
import com.megacrit.cardcrawl.cards.green.*;
import com.megacrit.cardcrawl.cards.blue.*;
import com.megacrit.cardcrawl.cards.purple.*;
import com.megacrit.cardcrawl.cards.status.*;
import com.megacrit.cardcrawl.cards.curses.*;
import com.megacrit.cardcrawl.cards.tempCards.*;
import com.megacrit.cardcrawl.cards.colorless.*;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.exordium.*;

import com.megacrit.cardcrawl.powers.*;
import com.megacrit.cardcrawl.powers.watcher.*;

import com.megacrit.cardcrawl.relics.*;

import com.megacrit.cardcrawl.helpers.PotionHelper;
import com.megacrit.cardcrawl.potions.*;

import com.megacrit.cardcrawl.orbs.*;

import savestate.orbs.*;
import savestate.CardState;
import savestate.PotionState;
import savestate.SaveState;
import savestate.StateFactories;
import savestate.relics.RelicState;
import savestate.powers.PowerState;
import savestate.monsters.MonsterState;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

public class ValueFunctions {

    public static final HashMap<String, Integer> POWER_VALUES = new HashMap<String, Integer>() {{
        put(StrengthPower.POWER_ID, 3);
        put(DexterityPower.POWER_ID, 3);
		put(IntangiblePlayerPower.POWER_ID, 15);
		put(ArtifactPower.POWER_ID, 5);
		put(MantraPower.POWER_ID, 1);
		put(DrawCardNextTurnPower.POWER_ID, 2);
		put(EnergizedBluePower.POWER_ID, 2);
		put(EnergizedPower.POWER_ID, 2);
		put(PlatedArmorPower.POWER_ID, 3);
		put(RitualPower.POWER_ID, 2);
		put(ThornsPower.POWER_ID, 3);
		put(VigorPower.POWER_ID, 1);
		
		put(FrailPower.POWER_ID, -5);
		put(WeakPower.POWER_ID, -5);
		put(VulnerablePower.POWER_ID, -5);
		put(HexPower.POWER_ID, -10);
		put(WraithFormPower.POWER_ID, -10);
		put(DrawReductionPower.POWER_ID, -10);
		put(LoseDexterityPower.POWER_ID, -2);
		put(LoseStrengthPower.POWER_ID, -2);
		put(ConstrictedPower.POWER_ID, -10);
		put(EntanglePower.POWER_ID, -10);
		put(NoDrawPower.POWER_ID, -10);
		put(EnergyDownPower.POWER_ID, -10);
		put(BiasPower.POWER_ID, -5);
		put(NoBlockPower.POWER_ID, -10);
		
		put(MagnetismPower.POWER_ID, 2);
		put(MayhemPower.POWER_ID, 3);
		put(PanachePower.POWER_ID, 3);
		put(SadisticPower.POWER_ID, 3);
		//put(TheBombPower.POWER_ID, 3);
		
        put(DarkEmbracePower.POWER_ID, 4);
        put(FeelNoPainPower.POWER_ID, 5);
        put(DemonFormPower.POWER_ID, 6);
        put(FireBreathingPower.POWER_ID, 2);
        put(CombustPower.POWER_ID, 2);
        put(EvolvePower.POWER_ID, 16);
		put(MetallicizePower.POWER_ID, 3);
		put(RupturePower.POWER_ID, 3);
		put(BarricadePower.POWER_ID, 10);
		put(BerserkPower.POWER_ID, 10);
		put(CorruptionPower.POWER_ID, 20);
		put(JuggernautPower.POWER_ID, 3);
		put(BrutalityPower.POWER_ID, 3);
		put(DoubleTapPower.POWER_ID, 2);
		put(FlameBarrierPower.POWER_ID, 1);
		put(NextTurnBlockPower.POWER_ID, 1);
		put(RagePower.POWER_ID, 3);

        put(AccuracyPower.POWER_ID, 3);
		put(BlurPower.POWER_ID, 3);
		put(NoxiousFumesPower.POWER_ID, 10);
		put(InfiniteBladesPower.POWER_ID, 1);
		put(ThousandCutsPower.POWER_ID, 3);
		put(AfterImagePower.POWER_ID, 10);
		put(ToolsOfTheTradePower.POWER_ID, 3);
		put(BurstPower.POWER_ID, 10);
		put(EnvenomPower.POWER_ID, 5);
		put(NightmarePower.POWER_ID, 1);
		put(PhantasmalPower.POWER_ID, 3);
		
        put(FocusPower.POWER_ID, 3);
        put(EchoPower.POWER_ID, 40);
		put(EquilibriumPower.POWER_ID, 2);
		put(HeatsinkPower.POWER_ID, 3);
		put(LoopPower.POWER_ID, 3);
		put(HelloPower.POWER_ID, 1);
		put(StaticDischargePower.POWER_ID, 3);
		put(StormPower.POWER_ID, 3);
		put(BufferPower.POWER_ID, 20);
		put(CreativeAIPower.POWER_ID, 20);
		put(ElectroPower.POWER_ID, 30);
		put(DrawPower.POWER_ID, 3);
		put(AmplifyPower.POWER_ID, 2);
		put(RepairPower.POWER_ID, 1);
		
		put(DevaPower.POWER_ID, 20);
		put(EstablishmentPower.POWER_ID, 3);
		put(MasterRealityPower.POWER_ID, 3);
		put(StudyPower.POWER_ID, 3);
		put(RushdownPower.POWER_ID, 3);
		put(NirvanaPower.POWER_ID, 3);
		put(MentalFortressPower.POWER_ID, 3);
		put(LikeWaterPower.POWER_ID, 3);
		put(ForesightPower.POWER_ID, 3);
		put(CollectPower.POWER_ID, 3);
		put(BattleHymnPower.POWER_ID, 1);
		put(FreeAttackPower.POWER_ID, 2);
		put(OmegaPower.POWER_ID, 3);
		put(WaveOfTheHandPower.POWER_ID, 3);
		put(WrathNextTurnPower.POWER_ID, 3);
    }};

    public static final HashMap<String, Integer> POTION_VALUES = new HashMap<String, Integer>() {{
        put(Ambrosia.POTION_ID, 100);
        put(AncientPotion.POTION_ID, 20);
        put(AttackPotion.POTION_ID, 15);
        put(BlessingOfTheForge.POTION_ID, 20);
        put(BlockPotion.POTION_ID, 60);
        put(BloodPotion.POTION_ID, 120);
        put(BottledMiracle.POTION_ID, 60);
        put(ColorlessPotion.POTION_ID, 15);
        put(CultistPotion.POTION_ID, 30);
        put(CunningPotion.POTION_ID, 40);
        put(DexterityPotion.POTION_ID, 12);
        put(DistilledChaosPotion.POTION_ID, 40);
        put(DuplicationPotion.POTION_ID, 50);
        put(Elixir.POTION_ID, 20);
        put(EnergyPotion.POTION_ID, 60);
        put(EntropicBrew.POTION_ID, 240);
        put(EssenceOfDarkness.POTION_ID, 60);
        put(EssenceOfSteel.POTION_ID, 60);
        put(ExplosivePotion.POTION_ID, 40);
        put(FairyPotion.POTION_ID, 100);
        put(FearPotion.POTION_ID, 20);
        put(FirePotion.POTION_ID, 40);
        put(FocusPotion.POTION_ID, 60);

        // Just play fruit juice
        put(FruitJuice.POTION_ID, 30);
        put(GamblersBrew.POTION_ID, 500);
        put(GhostInAJar.POTION_ID, 80);
        put(HeartOfIron.POTION_ID, 48);
        put(LiquidBronze.POTION_ID, 20);
        put(LiquidMemories.POTION_ID, 30);
        put(PoisonPotion.POTION_ID, 20);
        put(PotionOfCapacity.POTION_ID, 30);
        put(SmokeBomb.POTION_ID, 0);
        put(PowerPotion.POTION_ID, 50);
        put(RegenPotion.POTION_ID, 64);
        put(SneckoOil.POTION_ID, 75);
        put(SpeedPotion.POTION_ID, 75);
        put(StancePotion.POTION_ID, 0);
        put(SteroidPotion.POTION_ID, 21);
        put(StrengthPotion.POTION_ID, 40);
        put(SwiftPotion.POTION_ID, 40);
        put(WeakenPotion.POTION_ID, 50);
    }};

    /**
     * Adds up monster health and accounts for powers that alter the effective health of the enemy
     * such as barricade and unawakened.
     */
    public static int getTotalMonsterHealth(SaveState saveState) {
        return saveState.curMapNodeState.monsterData.stream()
                                                    .map(monster -> {
                                                        if (monster.powers.stream()
                                                                          .anyMatch(power -> power.powerId
                                                                                  .equals("Barricade"))) {
                                                            return monster.currentHealth + monster.currentBlock;
                                                        } else if (monster.powers.stream()
                                                                                 .anyMatch(power -> power.powerId
                                                                                         .equals("Unawakened"))) {
                                                            return monster.currentHealth + monster.maxHealth;
                                                        }
                                                        return monster.currentHealth;
                                                    })
                                                    .reduce(Integer::sum)
                                                    .get();
    }

    public static int caclculateTurnScore(TurnNode turnNode) {
		
        int playerDamage = getPlayerDamage(turnNode);
		
        int monsterDamage = ValueFunctions.getTotalMonsterHealth(turnNode.controller.startingState) -
		                    ValueFunctions.getTotalMonsterHealth(turnNode.startingState.saveState);

        int powerScore = turnNode.startingState.saveState.playerState.powers.stream()
                                                                            .map(powerState -> POWER_VALUES
                                                                                    .getOrDefault(powerState.powerId, 0) * powerState.amount)
                                                                            .reduce(Integer::sum)
                                                                            .orElse(0);
		
		int count = 0;
		int poison_count = 0;
		for (MonsterState mon : turnNode.startingState.saveState.curMapNodeState.monsterData) {
			if (!mon.isDying && !mon.isEscaping) {
				// halfDead?
				Optional<PowerState> powerPoison = mon.powers.stream().filter(powerState -> powerState.powerId.equals("Poison")).findAny();
				if (powerPoison.isPresent()) {
					poison_count += powerPoison.get().amount;
				}
				count++;
				
			}
		}
		int poisonScore = poison_count;
		
		// preview passive damage using:
		// poison
		// lightning orbs
		// bomb
		// omega
		// combust
		// calendar
		//  (check for intangible)
		
		// add score for enemy debuffs
		
        int totalRitualDaggerDamage = 0;
        int numFeeds = 0;
        int numLessonLearned = 0;
		
        int numMiracles = 0;
        int expungerDamage = 0;
        int numCatalysts = 0;
        int totalGeneticAlgorithmBlock = 0;

        for (CardState card : turnNode.startingState.saveState.playerState.hand) {
            switch (StateFactories.cardIds[card.cardIdIndex]) {
                case RitualDagger.ID:
                    totalRitualDaggerDamage += card.baseDamage;
                    break;
                case GeneticAlgorithm.ID:
                    totalGeneticAlgorithmBlock += card.baseBlock;
                    break;
                case Miracle.ID:
                    numMiracles++;
                    break;
                case Feed.ID:
                    numFeeds++;
                    break;
                case Expunger.ID:
                    expungerDamage += card.baseMagicNumber;
                    break;
                case LessonLearned.ID:
                    numLessonLearned++;
                    break;
                case Catalyst.ID:
                    numCatalysts++;
                    break;
                default:
                    break;
            }
        }

        for (CardState card : turnNode.startingState.saveState.playerState.drawPile) {
            switch (StateFactories.cardIds[card.cardIdIndex]) {
                case RitualDagger.ID:
                    totalRitualDaggerDamage += card.baseDamage;
                    break;
                case GeneticAlgorithm.ID:
                    totalGeneticAlgorithmBlock += card.baseBlock;
                    break;
                case Feed.ID:
                    numFeeds++;
                    break;
                case Expunger.ID:
                    expungerDamage += card.baseMagicNumber;
                    break;
                case LessonLearned.ID:
                    numLessonLearned++;
                    break;
                case Catalyst.ID:
                    numCatalysts++;
                    break;
                default:
                    break;
            }
        }

        for (CardState card : turnNode.startingState.saveState.playerState.discardPile) {
            switch (StateFactories.cardIds[card.cardIdIndex]) {
                case RitualDagger.ID:
                    totalRitualDaggerDamage += card.baseDamage;
                    break;
                case GeneticAlgorithm.ID:
                    totalGeneticAlgorithmBlock += card.baseBlock;
                    break;
                case Feed.ID:
                    numFeeds++;
                    break;
                case Expunger.ID:
                    expungerDamage += card.baseMagicNumber;
                    break;
                case LessonLearned.ID:
                    numLessonLearned++;
                    break;
                case Catalyst.ID:
                    numCatalysts++;
                    break;
                default:
                    break;
            }
        }

        for (CardState card : turnNode.startingState.saveState.playerState.exhaustPile) {
            switch (StateFactories.cardIds[card.cardIdIndex]) {
                case RitualDagger.ID:
                    totalRitualDaggerDamage += card.baseDamage;
                    break;
                case GeneticAlgorithm.ID:
                    totalGeneticAlgorithmBlock += card.baseBlock;
                    break;
                default:
                    break;
            }
        }
		
        int miracleScore = numMiracles * 2;
        int expungerScore = expungerDamage;
        int catalystScore = numCatalysts * 2;
		
        int parasiteScore = turnNode.startingState.saveState.parasiteCount * -100;

        int numOrb = turnNode.startingState.saveState.playerState.maxOrbs;
		int numOrbScore = numOrb == 0 ? -1000 : numOrb * 5;
		
		int focus = 0;
		Optional<PowerState> powerFocus = turnNode.startingState.saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("Focus")).findAny();
		if (powerFocus.isPresent()) {
			focus += powerFocus.get().amount;
		}
		
		int loop = 1;
		Optional<PowerState> powerLoop = turnNode.startingState.saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("Loop")).findAny();
		if (powerLoop.isPresent()) {
			loop += powerLoop.get().amount;
		}
		
		int electro = 0;
		Optional<PowerState> powerElectro = turnNode.startingState.saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("Electro")).findAny();
		if (powerElectro.isPresent()) {
			electro = 1;
		}

		int orbScore = 0;
		int iOrb = 0;
		for (OrbState o : turnNode.startingState.saveState.playerState.orbs) {
			if (o instanceof EmptyOrbSlotState) {
				orbScore -= 5;
			}
			if (o instanceof LightningOrbState) {
				int lightScore = Math.min(0, 3 + focus);
				if (electro == 1) {
					lightScore *= count;
				}
				orbScore += lightScore;
			}
			if (o instanceof FrostOrbState) {
				orbScore += Math.min(0, 2 + focus);
			}
			if (o instanceof DarkOrbState) {
				orbScore += Math.min(0, 5 + focus);
			}
			if (o instanceof PlasmaOrbState) {
				orbScore += 5;
			}
			if (iOrb == 0) {
				orbScore *= loop;
			}
			iOrb++;
		}
		
		// if ice cream = add score for energy?
		
		// if calipers | blur | barricade = add score for armor?
		
		// monster health -1? = 0 ? do not overkill
		
		// if piramid | defectcard = add score for handsize?
		
		// Add negative score for each status or curse (medkit + bluecandle ?)
		
		int playerDamageScore = playerDamage * -1;

        int ritualDaggerScore = totalRitualDaggerDamage * 2;
        int GeneticAlgorithmScore = totalGeneticAlgorithmBlock * 2;
        int feedScore = numFeeds * 4 + turnNode.startingState.saveState.playerState.maxHealth * 8;
        int lessonLearnedScore = numLessonLearned * 10 + turnNode.startingState.saveState.lessonLearnedCount * 20;
		
		int goldScore =  turnNode.startingState.saveState.playerState.gold * 4;

		int potionScore = getPotionScore(turnNode.startingState.saveState);
		int relicScore = getRelicScoreEnd(turnNode.startingState.saveState);

        int additonalHeuristicScore =
                BattleAiMod.additionalValueFunctions.stream()
                        .map(function -> function
                                .apply(turnNode.startingState.saveState)).mapToInt(Integer::intValue).sum();

        return numOrbScore +
		       orbScore +
		       poisonScore +
		       catalystScore +
		       parasiteScore +
		       lessonLearnedScore +
		       feedScore +
		       expungerScore +
		       powerScore +
		       ritualDaggerScore +
			   GeneticAlgorithmScore +
		       miracleScore +
		       goldScore +
		       monsterDamage +
			   playerDamageScore +
               potionScore +
               relicScore +
		       additonalHeuristicScore;
    }

    /**
     * This is used for end of battle score.  Only effects that last between battles such as health,
     * potions, and scaling effects matter here.
     */
    public static int getStateScore(StateNode node) {
		
        int totalRitualDaggerDamage = 0;
        int totalGeneticAlgorithmBlock = 0;
		
        for (CardState card : node.saveState.playerState.hand) {
            switch (StateFactories.cardIds[card.cardIdIndex]) {
                case RitualDagger.ID:
                    totalRitualDaggerDamage += card.baseDamage;
                    break;
                case GeneticAlgorithm.ID:
                    totalGeneticAlgorithmBlock += card.baseBlock;
                    break;
                default:
                    break;
            }
        }

        for (CardState card : node.saveState.playerState.drawPile) {
            switch (StateFactories.cardIds[card.cardIdIndex]) {
                case RitualDagger.ID:
                    totalRitualDaggerDamage += card.baseDamage;
                    break;
                case GeneticAlgorithm.ID:
                    totalGeneticAlgorithmBlock += card.baseBlock;
                    break;
                default:
                    break;
            }
        }

        for (CardState card : node.saveState.playerState.discardPile) {
            switch (StateFactories.cardIds[card.cardIdIndex]) {
                case RitualDagger.ID:
                    totalRitualDaggerDamage += card.baseDamage;
                    break;
                case GeneticAlgorithm.ID:
                    totalGeneticAlgorithmBlock += card.baseBlock;
                    break;
                default:
                    break;
            }
        }

        for (CardState card : node.saveState.playerState.exhaustPile) {
            switch (StateFactories.cardIds[card.cardIdIndex]) {
                case RitualDagger.ID:
                    totalRitualDaggerDamage += card.baseDamage;
                    break;
                case GeneticAlgorithm.ID:
                    totalGeneticAlgorithmBlock += card.baseBlock;
                    break;
                default:
                    break;
            }
        }
		
		int playerDamageScore = StateNode.getPlayerDamage(node) * -1;

        int ritualDaggerScore = totalRitualDaggerDamage;
        int GeneticAlgorithmScore = totalGeneticAlgorithmBlock;
        int lessonLearnedScore = node.saveState.lessonLearnedCount * 10;
        int feedScore = node.saveState.playerState.maxHealth * 4;
		
		int goldScore =  node.saveState.playerState.gold * 2;
		
		int potionScore = getPotionScore(node.saveState);
		int relicScore = getRelicScoreEnd(node.saveState);
		
        int additonalHeuristicScore =
                BattleAiMod.additionalValueFunctions.stream()
                        .map(function -> function
                                .apply(node.saveState)).mapToInt(Integer::intValue).sum();
		
        return feedScore +
               ritualDaggerScore +
			   GeneticAlgorithmScore +
               lessonLearnedScore +
               goldScore +
               playerDamageScore +
               potionScore +
               relicScore +
               additonalHeuristicScore;
    }

    public static int getPlayerDamage(TurnNode turnNode) {
        return StateNode.getPlayerDamage(turnNode.startingState);
    }

    public static int getPotionScore(SaveState saveState) {
        return saveState.playerState.potions.stream().map(potionState -> {
            if (potionState.potionId.equals("Potion Slot") || !POTION_VALUES
                    .containsKey(potionState.potionId)) {
                return 0;
            }
            return POTION_VALUES.get(potionState.potionId);
        }).reduce(Integer::sum).get();
    }

    public static int getRelicScoreEnd(SaveState saveState) {
		int relicScore = 0;
		
        Optional<RelicState> optionalLizardTail = saveState.playerState.relics.stream()
                                                                              .filter(relic -> relic.relicId
                                                                                      .equals(LizardTail.ID) && relic.counter != -2)
                                                                              .findAny();
        relicScore += optionalLizardTail.isPresent() ? 400 : 0;
		
		// pennib
		// nunchaku
		// inkbottle
		// flower
		// Omomori
		// sundial
		// incense
		
		return relicScore;
    }

    public static int getRelicScoreDuring(SaveState saveState) {
        int relicScore = 0;
		
        Optional<RelicState> optionalLizardTail = saveState.playerState.relics.stream()
                                                                              .filter(relic -> relic.relicId
                                                                                      .equals(LizardTail.ID) && relic.counter != -2)
                                                                              .findAny();
        relicScore += optionalLizardTail.isPresent() ? 400 : 0;
		
		// pennib
		// nunchaku
		// inkbottle
		// kunai
		// shuriken
		// Omomori
		// fan
		// letter
		// sundial
		// pocketwatch
		
		return relicScore;
    }
}
