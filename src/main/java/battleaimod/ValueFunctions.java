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

import com.megacrit.cardcrawl.monsters.exordium.*;

import com.megacrit.cardcrawl.powers.*;
import com.megacrit.cardcrawl.powers.watcher.*;

import com.megacrit.cardcrawl.relics.*;
import com.megacrit.cardcrawl.potions.*;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import savestate.orbs.*;
import savestate.CardState;
import savestate.PotionState;
import savestate.SaveState;
import savestate.MapRoomNodeState;
import savestate.StateFactories;
import savestate.relics.RelicState;
import savestate.powers.PowerState;
import savestate.powers.powerstates.common.TheBombPowerState;
import savestate.monsters.MonsterState;
import savestate.monsters.exordium.*;

import java.util.HashMap;
import java.util.Optional;

import com.badlogic.gdx.math.MathUtils;

public class ValueFunctions {
	
	public static int healthMultiplier = 10;
	public static int previewHealingMultiplier = 5;
	
	public static int fightMultiplier = 2;
	
	public static int energyValue = 10;
	public static int blockValue = 1;
	
	// How many health points is each of these worth
	public static int goldValue = 2;
	public static int maxHealthValue = 4;
	public static int lessonLearnedValue = 10;
	public static int ritualDaggerValue = 1; // For each point of damage increased
	public static int GeneticAlgorithmValue = 1; // For each point of block increased
	
	
    public static final HashMap<String, Integer> POWER_VALUES = new HashMap<String, Integer>() {{
        put(StrengthPower.POWER_ID, 10);
        put(DexterityPower.POWER_ID, 10);
        put(IntangiblePlayerPower.POWER_ID, 30);
        put(ArtifactPower.POWER_ID, 20);
        put(MantraPower.POWER_ID, 5);
        put(DrawCardNextTurnPower.POWER_ID, 5);
        put(EnergizedBluePower.POWER_ID, 5);
        put(EnergizedPower.POWER_ID, 5);
        put(PlatedArmorPower.POWER_ID, 10);
        put(RitualPower.POWER_ID, 20);
        put(ThornsPower.POWER_ID, 5);
        put(VigorPower.POWER_ID, 1);
        
        put(FrailPower.POWER_ID, -10);
        put(WeakPower.POWER_ID, -10);
        put(VulnerablePower.POWER_ID, -10);
        put(HexPower.POWER_ID, -30);
        put(WraithFormPower.POWER_ID, -30);
        put(DrawReductionPower.POWER_ID, -10);
        put(LoseDexterityPower.POWER_ID, -5);
        put(LoseStrengthPower.POWER_ID, -5);
        put(ConstrictedPower.POWER_ID, -10);
        put(EntanglePower.POWER_ID, -10);
        put(NoDrawPower.POWER_ID, -10);
        put(EnergyDownPower.POWER_ID, -10);
        put(BiasPower.POWER_ID, -5);
        put(NoBlockPower.POWER_ID, -10);
        
        put(MagnetismPower.POWER_ID, 5);
        put(MayhemPower.POWER_ID, 10);
        put(PanachePower.POWER_ID, 10);
        put(SadisticPower.POWER_ID, 10);
        // Todo: put(TheBombPower.POWER_ID, 3);
        
        put(DarkEmbracePower.POWER_ID, 20);
        put(FeelNoPainPower.POWER_ID, 20);
        put(DemonFormPower.POWER_ID, 30);
        put(FireBreathingPower.POWER_ID, 5);
        put(CombustPower.POWER_ID, 5);
        put(EvolvePower.POWER_ID, 20);
        put(MetallicizePower.POWER_ID, 15);
        put(RupturePower.POWER_ID, 5);
        put(BarricadePower.POWER_ID, 20);
        put(BerserkPower.POWER_ID, 10);
        put(CorruptionPower.POWER_ID, 30);
        put(JuggernautPower.POWER_ID, 20);
        put(BrutalityPower.POWER_ID, 10);
        put(DoubleTapPower.POWER_ID, 3);
        put(FlameBarrierPower.POWER_ID, 3);
        put(NextTurnBlockPower.POWER_ID, 3);
        put(RagePower.POWER_ID, 3);

        put(AccuracyPower.POWER_ID, 10);
        put(BlurPower.POWER_ID, 10);
        put(NoxiousFumesPower.POWER_ID, 30);
        put(InfiniteBladesPower.POWER_ID, 3);
        put(ThousandCutsPower.POWER_ID, 20);
        put(AfterImagePower.POWER_ID, 30);
        put(ToolsOfTheTradePower.POWER_ID, 20);
        put(BurstPower.POWER_ID, 10);
        put(EnvenomPower.POWER_ID, 20);
        put(NightmarePower.POWER_ID, 10);
        put(PhantasmalPower.POWER_ID, 10);
        
        put(FocusPower.POWER_ID, 10);
        put(EchoPower.POWER_ID, 40);
        put(EquilibriumPower.POWER_ID, 3);
        put(HeatsinkPower.POWER_ID, 3);
        put(LoopPower.POWER_ID, 10);
        put(HelloPower.POWER_ID, 1);
        put(StaticDischargePower.POWER_ID, 3);
        put(StormPower.POWER_ID, 3);
        put(BufferPower.POWER_ID, 30);
        put(CreativeAIPower.POWER_ID, 30);
        put(ElectroPower.POWER_ID, 50);
        put(DrawPower.POWER_ID, 3);
        put(AmplifyPower.POWER_ID, 5);
        put(RepairPower.POWER_ID, 5);
        
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
        put(OmegaPower.POWER_ID, 40);
        put(WaveOfTheHandPower.POWER_ID, 3);
        put(WrathNextTurnPower.POWER_ID, 3);
    }};

    public static final HashMap<String, Integer> POTION_VALUES = new HashMap<String, Integer>() {{
        // Just play fruit juice
        put(FruitJuice.POTION_ID, -10);
        
        put(Ambrosia.POTION_ID, 100);
        put(BlessingOfTheForge.POTION_ID, 20);
		
        put(BlockPotion.POTION_ID, 110);
        put(BloodPotion.POTION_ID, 1);
        put(RegenPotion.POTION_ID, 100);
        put(GhostInAJar.POTION_ID, 200);
		
        put(FairyPotion.POTION_ID, 1);
        put(EntropicBrew.POTION_ID, 300); // Todo: Should be based on total/empty potion slots
        put(EssenceOfDarkness.POTION_ID, 60); // Todo: Should be based on max orbs
        put(EnergyPotion.POTION_ID, 60);
        put(DistilledChaosPotion.POTION_ID, 40);
        put(DuplicationPotion.POTION_ID, 100);
		
		// Get cards
        put(PowerPotion.POTION_ID, 50);
        put(AttackPotion.POTION_ID, 20);
		put(SkillPotion.POTION_ID, 20);
        put(ColorlessPotion.POTION_ID, 20);
        put(BottledMiracle.POTION_ID, 60);
        put(CunningPotion.POTION_ID, 40);
		
		// Damage
        put(ExplosivePotion.POTION_ID, 30);
        put(FirePotion.POTION_ID, 30);
		
		// Permanent buff
        put(AncientPotion.POTION_ID, 20);
        put(StrengthPotion.POTION_ID, 30);
        put(DexterityPotion.POTION_ID, 30);
        put(PotionOfCapacity.POTION_ID, 30);
        put(HeartOfIron.POTION_ID, 50);
        put(LiquidBronze.POTION_ID, 20);
        put(EssenceOfSteel.POTION_ID, 60);
        put(FocusPotion.POTION_ID, 60);
        
		// Draw
        put(SneckoOil.POTION_ID, 75);
        put(SwiftPotion.POTION_ID, 40);
        
		// Temp buff
        put(SpeedPotion.POTION_ID, 75);
        put(SteroidPotion.POTION_ID, 21);
        
		// Monster debuff
        put(PoisonPotion.POTION_ID, 20);
        put(FearPotion.POTION_ID, 20);
        put(WeakenPotion.POTION_ID, 50);
        
		// Currently removed
        //put(LiquidMemories.POTION_ID, -1000);
        //put(StancePotion.POTION_ID, -1000);
        //put(SmokeBomb.POTION_ID, -1000);
        //put(Elixir.POTION_ID, -1000);
        //put(GamblersBrew.POTION_ID, -1000);
        //put(CultistPotion.POTION_ID, -1000);
    }};

    public static final HashMap<String, Integer> POTION_BARK_VALUES = new HashMap<String, Integer>() {{
        put(BlockPotion.POTION_ID, 210);
        //put(BloodPotion.POTION_ID, 290);
        put(RegenPotion.POTION_ID, 200);
        put(GhostInAJar.POTION_ID, 370);
		
        //put(FairyPotion.POTION_ID, 400);
        put(EssenceOfDarkness.POTION_ID, 120); // Todo: Should be based on max orbs
        put(EnergyPotion.POTION_ID, 120);
        put(DistilledChaosPotion.POTION_ID, 80);
        put(DuplicationPotion.POTION_ID, 200);
		
		// Get cards
        put(PowerPotion.POTION_ID, 100);
        put(AttackPotion.POTION_ID, 40);
		put(SkillPotion.POTION_ID, 40);
        put(ColorlessPotion.POTION_ID, 40);
        put(BottledMiracle.POTION_ID, 120);
        put(CunningPotion.POTION_ID, 80);
		
		// Damage
        put(ExplosivePotion.POTION_ID, 60);
        put(FirePotion.POTION_ID, 60);
		
		// Permanent buff
        put(AncientPotion.POTION_ID, 40);
        put(StrengthPotion.POTION_ID, 60);
        put(DexterityPotion.POTION_ID, 60);
        put(PotionOfCapacity.POTION_ID, 60);
        put(HeartOfIron.POTION_ID, 100);
        put(LiquidBronze.POTION_ID, 40);
        put(EssenceOfSteel.POTION_ID, 120);
        put(FocusPotion.POTION_ID, 120);
        
		// Draw
        put(SneckoOil.POTION_ID, 150);
        put(SwiftPotion.POTION_ID, 80);
        
		// Temp buff
        put(SpeedPotion.POTION_ID, 150);
        put(SteroidPotion.POTION_ID, 42);
        
		// Monster debuff
        put(PoisonPotion.POTION_ID, 40);
        put(FearPotion.POTION_ID, 40);
        put(WeakenPotion.POTION_ID, 100);
    }};

    public static int caclculateTurnScore(TurnNode turnNode) {
		
		SaveState saveState = turnNode.startingState.saveState;
		
		int totalMultiplier = healthMultiplier * fightMultiplier;
        
        int playerHealth = saveState.playerState.getCurrentHealth();
		int playerMaxHealth = saveState.playerState.maxHealth;
		int playerMissingHealth = playerMaxHealth - playerHealth;
		
		int areaDamageTotal = 0;
		int areaDamageInstances = 0;
		
		int monsterTotalCount = 0;
        int monsterAliveCount = 0;
		for (MonsterState monster : saveState.curMapNodeState.monsterData) {
            if (!monster.halfDead && !monster.isDying && !monster.isEscaping) {
                monsterTotalCount++;
                monsterAliveCount++;
            } else if (monster.halfDead) {
				monsterTotalCount++;
			}
        }
		
		int hasEctoplasm = 0;
		Optional<RelicState> relicEctoplasm = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Ectoplasm.ID)).findAny();
        if (relicEctoplasm.isPresent()) {
            hasEctoplasm = 1;
        }
		
		int hasMarkOfTheBloom = 0;
		Optional<RelicState> relicMarkOfTheBloom = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(MarkOfTheBloom.ID)).findAny();
        if (relicMarkOfTheBloom.isPresent()) {
            hasMarkOfTheBloom = 1;
        }
		
		int fightHasRewards = 0;
		if (saveState.curMapNodeState.rewardAllowed) {
			fightHasRewards = 1;
		}
		int isBoss = 0;
		int isLastBoss = 0;
		if (saveState.curMapNodeState.roomType == MapRoomNodeState.RoomType.BOSS) {
			isBoss = 1;
			if (saveState.ascensionLevel < 20 || AbstractDungeon.bossList.size() != 2) {
				isLastBoss = 1;
			} else {
				fightHasRewards = 0;
			}
		}
		
		int previewHealing = 0;
		
		// Can't heal with MarkOfTheBloom
		// Don't count healing when facing heart
		if (hasMarkOfTheBloom == 0 && saveState.floorNum != 55) {
			int hasMagicFlower = 0;
			Optional<RelicState> relicMagicFlower = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(MagicFlower.ID)).findAny();
			if (relicMagicFlower.isPresent()) {
				hasMagicFlower = 1;
			}
			
			if (hasMagicFlower == 1) {
				Optional<RelicState> relicFaceOfCleric = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(FaceOfCleric.ID)).findAny();
				if (relicFaceOfCleric.isPresent()) {
					previewHealing += 1;
				}
			}

			Optional<RelicState> relicBurningBlood = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(BurningBlood.ID)).findAny();
			if (relicBurningBlood.isPresent()) {
				if (hasMagicFlower == 1) {
					previewHealing += 9;
				} else {
					previewHealing += 6;
				}
			}

			Optional<RelicState> relicBlackBlood = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(BlackBlood.ID)).findAny();
			if (relicBlackBlood.isPresent()) {
				if (hasMagicFlower == 1) {
					previewHealing += 18;
				} else {
					previewHealing += 12;
				}
			}
			
			Optional<RelicState> relicMeatOnTheBone = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(MeatOnTheBone.ID)).findAny();
			if (relicMeatOnTheBone.isPresent() && playerHealth <= playerMaxHealth / 2.0F) {
				if (hasMagicFlower == 1) {
					previewHealing += 18;
				} else {
					previewHealing += 12;
				}
			}
			
			Optional<PowerState> powerRepair = saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("Repair")).findAny();
			if (powerRepair.isPresent()) {
				if (hasMagicFlower == 1) {
					previewHealing += MathUtils.round(powerRepair.get().amount * 1.5F);
				} else {
					previewHealing += powerRepair.get().amount;
				}
			}
			
			Optional<RelicState> relicBloodVial = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(BloodVial.ID)).findAny();
			if (relicBloodVial.isPresent()) {
				if (hasMagicFlower == 1) {
					previewHealing += 3;
				} else {
					previewHealing += 2;
				}
			}
			
			if (fightHasRewards == 1) {
				Optional<RelicState> relicBloodyIdol = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(BloodyIdol.ID)).findAny();
				if (relicBloodyIdol.isPresent() && hasEctoplasm == 0) {
					previewHealing += 5;
					Optional<RelicState> relicMawBank = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(MawBank.ID)).findAny();
					if (relicMawBank.isPresent() && relicMawBank.get().counter != -2) {
						previewHealing += 5;
					}
				}
			}
			
			int stillMissingHealth = 0;
			if (previewHealing >= playerMissingHealth) {
				previewHealing = playerMissingHealth;
			} else {
				stillMissingHealth = (playerMissingHealth - previewHealing);
			}
			
			// Post-boss heal
			if (stillMissingHealth > 0 && isLastBoss == 1) {
				if (saveState.ascensionLevel >= 5) {
					previewHealing += MathUtils.round(stillMissingHealth * 0.75F);
				} else {
					previewHealing += playerMaxHealth;
				}
				
				if (previewHealing >= playerMissingHealth) {
					previewHealing = playerMissingHealth;
				}
			}
		}
		
		// Idea: Preview possible healing? bandages, bites, reaper, bird faced urn
		
		
        // Idea: Maybe change the score value of each hp point based on max hp?
        int playerCurrentHealthScore = playerHealth * healthMultiplier;
		
		int previewHealingScore = previewHealing * previewHealingMultiplier;
		
        int playerMaxHealthScore = playerMaxHealth * maxHealthValue * totalMultiplier;
		
		int powerScore = 0;
		for (int iPower = 0; iPower < saveState.playerState.powers.size(); iPower++) {
            PowerState power = saveState.playerState.powers.get(iPower);
			
			if (POWER_VALUES.containsKey(power.powerId)) {
                powerScore += POWER_VALUES.get(power.powerId) * power.amount;
				
            } else if (power.powerId.equals(TheBombPower.POWER_ID)) {
				TheBombPowerState bombpower = (TheBombPowerState) power;
				
				powerScore += (int)(bombpower.damage * 0.2F);
				if (bombpower.amount == 1) {
					areaDamageTotal += bombpower.damage;
					areaDamageInstances++;
				}
			}
		}
        
        int totalRitualDaggerDamage = 0;
        int numFeeds = 0;
        int numLessonLearned = 0;
        
        int numMiracles = 0;
        int expungerDamage = 0;
        int numCatalysts = 0;
        int totalGeneticAlgorithmBlock = 0;
        int totalClawExtraDamage = 0;
		
        // Idea: add score for rampage scaling
        // Idea: maybe add score for pressure points scaling?

        for (CardState card : saveState.playerState.hand) {
            switch (StateFactories.cardIds[card.cardIdIndex]) {
                case RitualDagger.ID:
                    totalRitualDaggerDamage += card.baseDamage;
                    break;
                case GeneticAlgorithm.ID:
                    totalGeneticAlgorithmBlock += card.baseBlock;
                    break;
                case Claw.ID:
                    if (card.upgraded) {
                        totalClawExtraDamage += Math.min(0, card.baseDamage - 5);
                    } else {
                        totalClawExtraDamage += Math.min(0, card.baseDamage - 3);
                    }
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

        for (CardState card : saveState.playerState.drawPile) {
            switch (StateFactories.cardIds[card.cardIdIndex]) {
                case RitualDagger.ID:
                    totalRitualDaggerDamage += card.baseDamage;
                    break;
                case GeneticAlgorithm.ID:
                    totalGeneticAlgorithmBlock += card.baseBlock;
                    break;
                case Claw.ID:
                    if (card.upgraded) {
                        totalClawExtraDamage += Math.min(0, card.baseDamage - 5);
                    } else {
                        totalClawExtraDamage += Math.min(0, card.baseDamage - 3);
                    }
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

        for (CardState card : saveState.playerState.discardPile) {
            switch (StateFactories.cardIds[card.cardIdIndex]) {
                case RitualDagger.ID:
                    totalRitualDaggerDamage += card.baseDamage;
                    break;
                case GeneticAlgorithm.ID:
                    totalGeneticAlgorithmBlock += card.baseBlock;
                    break;
                case Claw.ID:
                    if (card.upgraded) {
                        totalClawExtraDamage += Math.min(0, card.baseDamage - 5);
                    } else {
                        totalClawExtraDamage += Math.min(0, card.baseDamage - 3);
                    }
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

        for (CardState card : saveState.playerState.exhaustPile) {
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
        
        int miracleScore = numMiracles * energyValue * healthMultiplier;
        int expungerScore = expungerDamage;
        int catalystScore = numCatalysts * 2 * healthMultiplier;
        int clawScore = totalClawExtraDamage;
        // Idea: Maybe add score for Alchemize (when no Sozu), Wish (when no Ectoplasm) and limit brake ??
        // Idea: Base catalyst score on current enemy poison and limit brake score in current player strengh?
        
        
        int parasiteScore = saveState.parasiteCount * -100;

        int numOrb = saveState.playerState.maxOrbs;
        
        // Add score for each orb slot, or remove 1000 score when you have 0 orb slots
        int numOrbScore = numOrb == 0 ? -1000 : numOrb * 5;
        
        // Check for Loop
        int loopPowerAmount = 0;
        Optional<PowerState> powerLoop = saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("Loop")).findAny();
        if (powerLoop.isPresent()) {
            loopPowerAmount = powerLoop.get().amount;
        }
		
		int focusAmount = 0;
        Optional<PowerState> powerFocus = saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("Focus")).findAny();
        if (powerFocus.isPresent()) {
            focusAmount += powerFocus.get().amount;
        }
        
        // Check for Electrodynamics
        int hasElectro = 0;
        Optional<PowerState> powerElectro = saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("Electro")).findAny();
        if (powerElectro.isPresent()) {
            hasElectro = 1;
        }
		
        int hasCables = 0;
		Optional<RelicState> relicCables = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(GoldPlatedCables.ID)).findAny();
        if (relicCables.isPresent()) {
            hasCables = 1;
        }
		
        int hasEmotionChip = 0;
		Optional<RelicState> relicEmotionChip = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(EmotionChip.ID)).findAny();
        if (relicEmotionChip.isPresent()) {
			if (relicEmotionChip.get().pulse) {
				hasEmotionChip = 1;
			}
        }
		
        int hasFrozenCore = 0;
		Optional<RelicState> relicFrozenCore = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(FrozenCore.ID)).findAny();
        if (relicFrozenCore.isPresent()) {
			hasFrozenCore = 1;
        }
		
		int baseDamagePerLighing = 0;
		int guaranteedLightningInstances = 0;

        int orbScore = 0;
        for (int iOrb = 0; iOrb < saveState.playerState.orbs.size(); iOrb++) {
            OrbState orb = saveState.playerState.orbs.get(iOrb);
            int currentOrbScore = 0;
			
			int currentLoop = 1;
			
			if (iOrb == 0 && hasCables == 1) {
				currentLoop += 1;
			}
			
			// Todo: Chip and Loop only work on next turn, so maybe don't count their damage now
			if (iOrb == 0 && loopPowerAmount >= 1) {
				//currentLoop += loopPowerAmount;
			}
			
			if (hasEmotionChip == 1) {
				//currentLoop += 1;
			}
            
            if (orb instanceof LightningOrbState) {
                // Add score based on lightning orb damage
				if (hasElectro == 1 || monsterAliveCount <= 1) {
					currentOrbScore += 1;
					baseDamagePerLighing = orb.passiveAmount;
					guaranteedLightningInstances += currentLoop;
				} else {
					currentOrbScore += orb.passiveAmount;
				}
                
            } else if (orb instanceof FrostOrbState) {
                // Add score based on frost orb block
                currentOrbScore += orb.passiveAmount * currentLoop;
                
            } else if (orb instanceof DarkOrbState) {
                // Add score based on dark orb damage
                currentOrbScore += Math.min(0, (orb.evokeAmount - orb.passiveAmount));
				currentOrbScore += orb.passiveAmount * currentLoop;
                
            } else if (orb instanceof PlasmaOrbState) {
                // Add score for plasma orb
                currentOrbScore += energyValue * currentLoop;
				
            } else if (orb instanceof EmptyOrbSlotState) {
				if (hasFrozenCore == 1) {
					hasFrozenCore = 0;
					currentOrbScore += Math.max(0, (2+focusAmount)) * currentLoop;
				} else {
					currentOrbScore = 0;
				}
            }
            
            if (currentOrbScore == 0) {
                // Todo: If orb slot is empty remove all score added by it (this makes capacitor unplayable when you have no orbs, not the best approach)
                currentOrbScore -= 5;
            }
            
            orbScore += currentOrbScore;
        }
		
		Optional<PowerState> powerOmegaPower = saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("OmegaPower")).findAny();
        if (powerOmegaPower.isPresent()) {
            areaDamageTotal += powerOmegaPower.get().amount;
			areaDamageInstances++;
        }
		
		Optional<PowerState> powerCombust = saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("Combust")).findAny();
        if (powerCombust.isPresent()) {
            areaDamageTotal += powerCombust.get().amount;
			areaDamageInstances++;
        }
		
        Optional<RelicState> relicStoneCalendar = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(StoneCalendar.ID) && relic.counter == 7).findAny();
        if (relicStoneCalendar.isPresent()) {
            areaDamageTotal += 52;
			areaDamageInstances++;
        }
		
		int monsterTotalHealth = 0;
		int monsterPreviewHealthLeftover = 0;
        int poisonCount = 0;
		int monsterBuffScore = 0;
        for (MonsterState monster : saveState.curMapNodeState.monsterData) {
			
            if (!monster.halfDead && !monster.isDying && !monster.isEscaping) {
				int currentPoisonCount = 0;
				
				int currentHealth = monster.currentHealth;
				int currentBlock = monster.currentBlock;
				int maxHealth = monster.maxHealth;
				
				Optional<PowerState> powerRegenerate = monster.powers.stream().filter(powerState -> powerState.powerId.equals(RegenerateMonsterPower.POWER_ID)).findAny();
                if (powerRegenerate.isPresent()) {
					int regenAmount = powerRegenerate.get().amount;
					currentHealth += regenAmount;
					if (currentHealth > maxHealth) {
						currentHealth = maxHealth;
					}
                }
				
                monsterTotalHealth += currentHealth;
				
				int maxHealthCanLose = currentHealth;
				int maxDamageCanTake = currentHealth;
				
				int previewDamageInstances = 0;
				int previewDamageToMonster = 0;
				
				int previewHealthLossInstances = 0;
				int previewHealthLossToMonster = 0;
				
				int canKill = 0;
				
				int hasIntangible = 0;
				Optional<PowerState> powerIntangible = monster.powers.stream().filter(powerState -> powerState.powerId.equals("Intangible")).findAny();
                if (powerIntangible.isPresent()) {
					hasIntangible = 1;
                }
				
				Optional<PowerState> powerInvincible = monster.powers.stream().filter(powerState -> powerState.powerId.equals("Invincible")).findAny();
                if (powerInvincible.isPresent()) {
					maxHealthCanLose = Math.min(currentHealth, powerInvincible.get().amount);
					maxDamageCanTake = maxHealthCanLose;
                }
				
				if (maxHealthCanLose == currentHealth) {
					canKill = 1;
				}
				
				if (monster.powers.stream().anyMatch(power -> power.powerId.equals("Barricade"))) {
					if (currentBlock >= 1) {
						maxDamageCanTake += currentBlock;
						monsterTotalHealth += currentBlock;
					}
				}
				
				if (monster.powers.stream().anyMatch(power -> power.powerId.equals("Unawakened"))) {
					monsterTotalHealth += maxHealth;
				}
				
                Optional<PowerState> powerPoison = monster.powers.stream().filter(powerState -> powerState.powerId.equals("Poison")).findAny();
                if (powerPoison.isPresent()) {
                    currentPoisonCount += Math.min(maxHealthCanLose, powerPoison.get().amount);
					previewHealthLossToMonster += currentPoisonCount;
					previewHealthLossInstances++;
                }
				poisonCount += currentPoisonCount;
				
				if (areaDamageTotal >= 1) {
					previewDamageToMonster += areaDamageTotal;
					previewDamageInstances += areaDamageInstances;
                }
				
				if (guaranteedLightningInstances >= 1) {
					int damagePerLighing;
					Optional<PowerState> powerLockon = monster.powers.stream().filter(powerState -> powerState.powerId.equals("Lockon")).findAny();
					if (powerLockon.isPresent()) {
						damagePerLighing = (int)(baseDamagePerLighing * 1.5F);
					} else {
						damagePerLighing = baseDamagePerLighing;
					}
					
					previewDamageToMonster += damagePerLighing * guaranteedLightningInstances;
					previewDamageInstances += guaranteedLightningInstances;
                }
				
				if (hasIntangible == 1) {
					if (previewDamageToMonster >= 1) {
						previewDamageToMonster = previewDamageInstances;
					}
					if (previewHealthLossToMonster >= 1) {
						previewHealthLossToMonster = previewHealthLossInstances;
					}
				}
				
				int willDie = 0;
				
				if (previewHealthLossToMonster >= 1) {
					if (previewHealthLossToMonster > maxHealthCanLose) {
						previewHealthLossToMonster = maxHealthCanLose;
					}
					
					if (previewHealthLossToMonster == maxHealthCanLose && canKill == 1) {
						willDie = 1;
					} else {
						maxDamageCanTake -= previewHealthLossToMonster;
					}
				}
				
				if (willDie == 0 && previewDamageToMonster >= 1) {
					if (previewDamageToMonster > maxDamageCanTake) {
						previewDamageToMonster = maxDamageCanTake;
					}
					
					if (previewDamageToMonster == maxDamageCanTake && canKill == 1) {
						willDie = 1;
					} else {
						maxDamageCanTake -= previewDamageToMonster;
					}
				}
				
				if (willDie == 1) {
					continue;
				}
				
				monsterPreviewHealthLeftover += maxDamageCanTake;
				
				Optional<PowerState> monsterStrength = monster.powers.stream().filter(powerState -> powerState.powerId.equals(StrengthPower.POWER_ID)).findAny();
                if (monsterStrength.isPresent()) {
                    monsterBuffScore += monsterStrength.get().amount * -15;
                }
				
				Optional<PowerState> monsterShackled = monster.powers.stream().filter(powerState -> powerState.powerId.equals(GainStrengthPower.POWER_ID)).findAny();
                if (monsterShackled.isPresent()) {
                    monsterBuffScore += monsterShackled.get().amount * -14;
                }
				
				Optional<PowerState> monsterArtifact = monster.powers.stream().filter(powerState -> powerState.powerId.equals(ArtifactPower.POWER_ID)).findAny();
                if (monsterArtifact.isPresent()) {
                    monsterBuffScore += monsterArtifact.get().amount * -5;
                }
				
				Optional<PowerState> monsterPlatedArmor = monster.powers.stream().filter(powerState -> powerState.powerId.equals(PlatedArmorPower.POWER_ID)).findAny();
                if (monsterPlatedArmor.isPresent()) {
                    monsterBuffScore += monsterPlatedArmor.get().amount * -3;
                }
				
				Optional<PowerState> monsterWeak = monster.powers.stream().filter(powerState -> powerState.powerId.equals(WeakPower.POWER_ID)).findAny();
                if (monsterWeak.isPresent()) {
					Optional<RelicState> relicPaperCrane = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(PaperCrane.ID) && relic.counter == 7).findAny();
					if (relicPaperCrane.isPresent()) {
						monsterBuffScore += monsterWeak.get().amount * 4;
					} else {
						monsterBuffScore += monsterWeak.get().amount * 3;
					}
                }
				
				Optional<PowerState> monsterVulnerable = monster.powers.stream().filter(powerState -> powerState.powerId.equals(VulnerablePower.POWER_ID)).findAny();
                if (monsterVulnerable.isPresent()) {
                    Optional<RelicState> relicPaperFrog = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(PaperFrog.ID) && relic.counter == 7).findAny();
					if (relicPaperFrog.isPresent()) {
						monsterBuffScore += monsterVulnerable.get().amount * 4;
					} else {
						monsterBuffScore += monsterVulnerable.get().amount * 3;
					}
                }
				
				if (monster.id.equals("Lagavulin")) {
					LagavulinState Laga = (LagavulinState) monster;
					boolean isOutTriggered = Laga.isOutTriggered;
					int idleCount = Laga.idleCount;
					if (idleCount >= 2 || isOutTriggered) {
						monsterBuffScore -= 100;
					}
				}
			
            } else if (monster.halfDead) {
				if (monster.id.equals("AwakenedOne")) {
					monsterTotalHealth += monster.maxHealth;
					
				} else if (monster.id.equals("Darkling")) {
					monsterTotalHealth += (int)(monster.maxHealth * 0.5F);
				}
			}
			
			// Idea: Prefer dealing damage to bosses instead of minions?
			// Idea: Prefer dealing damage to monsters with corpse explosion
        }
        //int poisonScore = poisonCount;
        int poisonScore = 0;
		
		turnNode.monsterTotalHealth = monsterTotalHealth;
		//int monsterHealthScore = monsterTotalHealth * -1;
		int monsterHealthScore = monsterPreviewHealthLeftover * -1;
        
        // Todo: if Piramid | Equilibrium = add score for handsize at the end of turn?
        
        // Todo: Add negative score for each status or curse in hand, draw and discard piles (maybe dif values for each pile) (medkit + bluecandle ?)
        
        // Idea: If you have All for one add score for each 0 cost card in the discard pile?
        
        // Idea: If you have grand finalle in the hand add a lot score for when draw pile is empty?
        
        // Idea: If you have thunderstrike add score for each channeled lightning orb?
        
        // Idea: If you have blizzard add score for each channeled frost orb?
        
        // Idea: If you have X cost cards in hand add score for current energy?
        
        // Idea: If you have spirit shield in hand add score for hand size?
        
        // Idea: If you have barrage in hand add score based on channeled orbs?
        
        // Idea: If you have Stack in hand add score based on discard pile size?
        
        // Idea: If you have aggregate in hand add score based on draw pile size?
        
        // Idea: If you have armaments in hand add score based on unupgraded cards in hand?
        
        // Idea: If you have Apotheosis in hand add score based on unupgraded cards in hand/draw/discard?
        
        // Idea: If you have Body slam in hand add score based on current block?
        
        // Idea: If you have Clash in hand add score when you have only attacks in hand?
        
        // Idea: Base Fumes power score in the amount of enemies?
        
        // Idea: Add score for stances (or maybe change power scores based on instances? (e.g. Like water for when you are in calm))?
        
        // Idea: Maybe something to add score when reducing cards cost? (Madness/Mummyhand/Enlightenment/Setup/)
		
        int ritualDaggerScore = totalRitualDaggerDamage * ritualDaggerValue * totalMultiplier;
        int GeneticAlgorithmScore = totalGeneticAlgorithmBlock * GeneticAlgorithmValue * totalMultiplier;
        int lessonLearnedScore = saveState.lessonLearnedCount * lessonLearnedValue * totalMultiplier;
        lessonLearnedScore += numLessonLearned * 10;
        
		int feedScore = numFeeds * 4;
		
        int goldScore = getGoldScore(saveState);
        goldScore *= goldValue * totalMultiplier;

        int potionScore = getPotionScore(saveState);
        
        int relicScore = getRelicScoreInCombat(saveState);
		
		int energyScore = 0;
		Optional<RelicState> relicIceCream = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(IceCream.ID)).findAny();
        if (relicIceCream.isPresent()) {
			energyScore += saveState.playerState.energyPanelTotalEnergy * energyValue;
        }
		
		int blockScore = 0;
		Optional<PowerState> powerBarricade = saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("Barricade")).findAny();
		Optional<PowerState> powerBlur = saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("Blur")).findAny();
        if (powerBarricade.isPresent() || powerBlur.isPresent()) {
            blockScore += saveState.playerState.currentBlock * blockValue;
        } else {
			Optional<RelicState> relicCalipers = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Calipers.ID)).findAny();
			if (relicCalipers.isPresent()) {
				blockScore += Math.min(0, (saveState.playerState.currentBlock - 15)) * blockValue;
			}
		}

        return numOrbScore +
               orbScore +
			   energyScore +
			   blockScore +
               poisonScore +
			   monsterBuffScore +
               clawScore +
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
               monsterHealthScore +
               playerCurrentHealthScore +
			   previewHealingScore +
			   playerMaxHealthScore +
               potionScore +
               relicScore;
    }

    /**
     * This is used for end of battle score.  Only effects that last between battles such as health,
     * potions, and scaling effects matter here.
     */
    public static int getStateScore(StateNode node) {
		
		SaveState saveState = node.saveState;
        
        int totalRitualDaggerDamage = 0;
        int totalGeneticAlgorithmBlock = 0;
        
        for (CardState card : saveState.playerState.hand) {
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

        for (CardState card : saveState.playerState.drawPile) {
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

        for (CardState card : saveState.playerState.discardPile) {
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

        for (CardState card : saveState.playerState.exhaustPile) {
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
        
        // Idea: Maybe change the score value of each hp point based on max hp?
        int playerCurrentHealthScore = saveState.playerState.getCurrentHealth() * healthMultiplier;
        int playerMaxHealthScore = saveState.playerState.maxHealth * maxHealthValue * healthMultiplier;

        int ritualDaggerScore = totalRitualDaggerDamage * ritualDaggerValue * healthMultiplier;
        int GeneticAlgorithmScore = totalGeneticAlgorithmBlock * GeneticAlgorithmValue * healthMultiplier;
        int lessonLearnedScore = saveState.lessonLearnedCount * lessonLearnedValue * healthMultiplier;
        
		int goldScore = getGoldScore(saveState);
        goldScore *= goldValue * healthMultiplier;
        
        int potionScore = getPotionScore(saveState);
		
        int relicScore = getRelicScoreEndOfCombat(saveState);
        
        return ritualDaggerScore +
               GeneticAlgorithmScore +
               lessonLearnedScore +
               goldScore +
               playerCurrentHealthScore +
			   playerMaxHealthScore +
               potionScore +
               relicScore;
    }

	public static int getPotionScore(SaveState saveState) {
		
		int playerMaxHealth = saveState.playerState.maxHealth;
		
		int hasBark = 0;
		Optional<RelicState> relicSacredBark = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(SacredBark.ID)).findAny();
        if (relicSacredBark.isPresent()) {
            hasBark = 1;
        }
		
		int hasToy = 0;
		Optional<RelicState> relicToyOrnithopter = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(ToyOrnithopter.ID)).findAny();
        if (relicToyOrnithopter.isPresent()) {
            hasToy = 1;
        }
		
		int hasWhiteBeast = 0;
		Optional<RelicState> relicWhiteBeast = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(WhiteBeast.ID)).findAny();
        if (relicWhiteBeast.isPresent()) {
            hasWhiteBeast = 1;
        }
		
		int hasSozu = 0;
		Optional<RelicState> relicSozu = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Sozu.ID)).findAny();
        if (relicSozu.isPresent()) {
            hasSozu = 1;
        }
		
		int hasMarkOfTheBloom = 0;
		Optional<RelicState> relicMarkOfTheBloom = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(MarkOfTheBloom.ID)).findAny();
        if (relicMarkOfTheBloom.isPresent()) {
            hasMarkOfTheBloom = 1;
        }
		
		int hasMagicFlower = 0;
		Optional<RelicState> relicMagicFlower = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(MagicFlower.ID)).findAny();
		if (relicMagicFlower.isPresent()) {
			hasMagicFlower = 1;
		}
		
		int toyScore = 0;
		if (hasToy == 1 && hasMarkOfTheBloom == 0) {
			if (hasMagicFlower == 1) {
				toyScore = healthMultiplier * 8;
			} else {
				toyScore = healthMultiplier * 5;
			}
		}
		
		int potionScore = 0;
	    for (int iPotion = 0; iPotion < saveState.playerState.potions.size(); iPotion++) {
            PotionState potion = saveState.playerState.potions.get(iPotion);
			
			if (potion.potionId.equals("Potion Slot")) {
				// Get score for one empty potion slot if we have WhiteBeast
				if (hasWhiteBeast == 1 && hasSozu == 0) {
					if (hasBark == 1) {
						potionScore += 150;
					} else {
						potionScore += 100;
					}
					hasWhiteBeast = 0;
				}
                continue;
            }
			
			// Negative value for unknown and unplayable potions to discard them
			if (!POTION_VALUES.containsKey(potion.potionId) || PotionState.UNPLAYABLE_POTIONS.contains(potion.potionId)) {
                potionScore -= 1000;
				
            } else {
			
				if (potion.potionId.equals(FairyPotion.POTION_ID)) {
					if (hasMarkOfTheBloom == 1) {
						potionScore -= 1000;
					} else {
						int healAmt = getPotionHealing(playerMaxHealth, 30, hasBark, hasMagicFlower);
						potionScore += (300 + (healAmt * healthMultiplier));
					}
					
				} else if (potion.potionId.equals(BloodPotion.POTION_ID)) {
					if (hasMarkOfTheBloom == 1) {
						potionScore -= 1000;
					} else {
						int healAmt = getPotionHealing(playerMaxHealth, 20, hasBark, hasMagicFlower);
						potionScore += (healAmt * healthMultiplier);
					}
					
				} else if (potion.potionId.equals(RegenPotion.POTION_ID) && hasMarkOfTheBloom == 1) {
					potionScore -= 1000;
					
				} else if (hasBark == 1 && POTION_BARK_VALUES.containsKey(potion.potionId)) {
					potionScore += POTION_BARK_VALUES.get(potion.potionId);
					
				} else {
					potionScore += POTION_VALUES.get(potion.potionId);
				}
				
				potionScore += toyScore;
			}
		}
		
		return potionScore;
	}
	
	public static int getGoldScore(SaveState saveState) {
		int goldScore;
		Optional<RelicState> relicCourier = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Courier.ID)).findAny();
        Optional<RelicState> relicMembershipCard = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(MembershipCard.ID)).findAny();
		if (relicCourier.isPresent()) {
            goldScore = MathUtils.round(saveState.playerState.gold * 1.25F);
        } else {
			goldScore = saveState.playerState.gold;
		}
		if (relicMembershipCard.isPresent()) {
            goldScore *= 2;
        }
		return goldScore;
	}
	
	public static int getPotionHealing(int playerMaxHealth, int potency, int hasBark, int hasMagicFlower) {
		int modPotency = potency;
		if (hasBark == 1) {
			modPotency *= 2;
		}
		float percent = modPotency / 100.0F;
		int baseHealAmt = (int)(playerMaxHealth * percent);
		int healAmt;
		if (hasMagicFlower == 1) {
			healAmt = MathUtils.round(baseHealAmt * 1.5F);
		} else {
			healAmt = baseHealAmt;
		}
		return healAmt;
	}

    public static int getRelicScoreEndOfCombat(SaveState saveState) {
        int relicScore = getRelicScoreBoth(saveState);
        
        Optional<RelicState> relicHappyFlower = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(HappyFlower.ID)).findAny();
        if (relicHappyFlower.isPresent()) {
            relicScore += relicHappyFlower.get().counter * 2;
        }
        
        Optional<RelicState> relicIncenseBurner = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(IncenseBurner.ID)).findAny();
        if (relicIncenseBurner.isPresent()) {
            relicScore += relicIncenseBurner.get().counter * 2;
        }
        
        return relicScore;
    }

    public static int getRelicScoreInCombat(SaveState saveState) {
		int relicScore = getRelicScoreBoth(saveState);
        
        Optional<RelicState> relicKunai = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Kunai.ID)).findAny();
        if (relicKunai.isPresent()) {
            relicScore += relicKunai.get().counter * 3;
        }
        
        Optional<RelicState> relicShuriken = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Shuriken.ID)).findAny();
        if (relicShuriken.isPresent()) {
            relicScore += relicShuriken.get().counter * 3;
        }
        
        // Idea: fan
        // Idea: letter
        // Idea: pocketwatch
        
        return relicScore;
    }

    public static int getRelicScoreBoth(SaveState saveState) {
        int relicScore = 0;
        
        Optional<RelicState> relicLizardTail = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(LizardTail.ID) && relic.counter != -2).findAny();
        if (relicLizardTail.isPresent()) {
            relicScore += 600; // Todo: Should be based on max health
        }
        
        Optional<RelicState> relicOmamori = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Omamori.ID)).findAny();
        if (relicOmamori.isPresent()) {
            relicScore += relicOmamori.get().counter * 100;
        }
        
        Optional<RelicState> relicInkBottle = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(InkBottle.ID)).findAny();
        if (relicInkBottle.isPresent()) {
            relicScore += relicInkBottle.get().counter;
        }
        
        Optional<RelicState> relicNunchaku = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Nunchaku.ID)).findAny();
        if (relicNunchaku.isPresent()) {
            relicScore += relicNunchaku.get().counter;
        }
        
        Optional<RelicState> relicPenNib = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(PenNib.ID)).findAny();
        if (relicPenNib.isPresent()) {
            relicScore += relicPenNib.get().counter;
        }
        
        Optional<RelicState> relicSundial = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Sundial.ID)).findAny();
        if (relicSundial.isPresent()) {
            relicScore += relicSundial.get().counter * 3;
        }
        
        return relicScore;
    }
}
