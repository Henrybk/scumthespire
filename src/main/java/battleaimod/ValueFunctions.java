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
import savestate.monsters.MonsterState;

import java.util.HashMap;
import java.util.Optional;

import com.badlogic.gdx.math.MathUtils;

public class ValueFunctions {
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
        put(BloodPotion.POTION_ID, 150); // Todo: Should be based on max health
        put(RegenPotion.POTION_ID, 100);
        put(GhostInAJar.POTION_ID, 200);
		
        put(FairyPotion.POTION_ID, 300); // Todo: Should be based on max health
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
        put(LiquidMemories.POTION_ID, 0);
        put(StancePotion.POTION_ID, 0);
        put(SmokeBomb.POTION_ID, 0);
        put(Elixir.POTION_ID, 0);
        put(GamblersBrew.POTION_ID, 0);
        put(CultistPotion.POTION_ID, 0);
    }};

    public static final HashMap<String, Integer> POTION_BARK_VALUES = new HashMap<String, Integer>() {{
        put(BlockPotion.POTION_ID, 210);
        put(BloodPotion.POTION_ID, 290); // Todo: Should be based on max health
        put(RegenPotion.POTION_ID, 200);
        put(GhostInAJar.POTION_ID, 370);
		
        put(FairyPotion.POTION_ID, 400); // Todo: Should be based on max health
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
        
        int playerHealth = turnNode.startingState.saveState.playerState.getCurrentHealth();
		int playerMaxHealth = turnNode.startingState.saveState.playerState.maxHealth;
		
		int playerMissingHealth = playerMaxHealth - playerHealth;
		
		int preview_guaranteed_healing = 0;
		
		int has_Ectoplasm = 0;
		Optional<RelicState> relicEctoplasm = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Ectoplasm.ID)).findAny();
        if (relicEctoplasm.isPresent()) {
            has_Ectoplasm = 1;
        }
		
		int hasMarkOfTheBloom = 0;
		Optional<RelicState> relicMarkOfTheBloom = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(MarkOfTheBloom.ID)).findAny();
        if (relicMarkOfTheBloom.isPresent()) {
            hasMarkOfTheBloom = 1;
        }
		
		int fightHasRewards = 0;
		if (turnNode.startingState.saveState.curMapNodeState.rewardAllowed) {
			fightHasRewards = 1;
		}
		int isBoss = 0;
		int isLastBoss = 0;
		if (turnNode.startingState.saveState.curMapNodeState.roomType == MapRoomNodeState.RoomType.BOSS) {
			isBoss = 1;
			if (turnNode.startingState.saveState.ascensionLevel < 20 || AbstractDungeon.bossList.size() != 2) {
				isLastBoss = 1;
			} else {
				fightHasRewards = 0;
			}
		}
		
		// Can't heal with MarkOfTheBloom
		// Don't count healing when facing heart
		if (hasMarkOfTheBloom == 0 && turnNode.startingState.saveState.floorNum != 55) {
			int has_MagicFlower = 0;
			Optional<RelicState> relicMagicFlower = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(MagicFlower.ID)).findAny();
			if (relicMagicFlower.isPresent()) {
				has_MagicFlower = 1;
			}
			
			if (has_MagicFlower == 1) {
				Optional<RelicState> relicFaceOfCleric = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(FaceOfCleric.ID)).findAny();
				if (relicFaceOfCleric.isPresent()) {
					preview_guaranteed_healing += 1;
				}
			}

			Optional<RelicState> relicBurningBlood = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(BurningBlood.ID)).findAny();
			if (relicBurningBlood.isPresent()) {
				if (has_MagicFlower == 1) {
					preview_guaranteed_healing += 9;
				} else {
					preview_guaranteed_healing += 6;
				}
			}

			Optional<RelicState> relicBlackBlood = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(BlackBlood.ID)).findAny();
			if (relicBlackBlood.isPresent()) {
				if (has_MagicFlower == 1) {
					preview_guaranteed_healing += 18;
				} else {
					preview_guaranteed_healing += 12;
				}
			}
			
			Optional<RelicState> relicMeatOnTheBone = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(MeatOnTheBone.ID)).findAny();
			if (relicMeatOnTheBone.isPresent() && playerHealth <= playerMaxHealth / 2.0F) {
				if (has_MagicFlower == 1) {
					preview_guaranteed_healing += 18;
				} else {
					preview_guaranteed_healing += 12;
				}
			}
			
			Optional<PowerState> powerRepair = turnNode.startingState.saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("Repair")).findAny();
			if (powerRepair.isPresent()) {
				if (has_MagicFlower == 1) {
					preview_guaranteed_healing += MathUtils.round(powerRepair.get().amount * 1.5F);
				} else {
					preview_guaranteed_healing += powerRepair.get().amount;
				}
			}
			
			Optional<RelicState> relicBloodVial = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(BloodVial.ID)).findAny();
			if (relicBloodVial.isPresent()) {
				if (has_MagicFlower == 1) {
					preview_guaranteed_healing += 3;
				} else {
					preview_guaranteed_healing += 2;
				}
			}
			
			if (fightHasRewards == 1) {
				Optional<RelicState> relicBloodyIdol = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(BloodyIdol.ID)).findAny();
				if (relicBloodyIdol.isPresent() && has_Ectoplasm == 0) {
					preview_guaranteed_healing += 5;
					Optional<RelicState> relicMawBank = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(MawBank.ID)).findAny();
					if (relicMawBank.isPresent() && relicMawBank.get().counter != -2) {
						preview_guaranteed_healing += 5;
					}
				}
			}
			
			int still_missing_health = 0;
			if (preview_guaranteed_healing >= playerMissingHealth) {
				preview_guaranteed_healing = playerMissingHealth;
			} else {
				still_missing_health = (playerMissingHealth - preview_guaranteed_healing);
			}
			
			// Post-boss heal
			if (still_missing_health > 0 && isLastBoss == 1) {
				if (turnNode.startingState.saveState.ascensionLevel >= 5) {
					preview_guaranteed_healing += MathUtils.round(still_missing_health * 0.75F);
				} else {
					preview_guaranteed_healing += playerMaxHealth;
				}
				
				if (preview_guaranteed_healing >= playerMissingHealth) {
					preview_guaranteed_healing = playerMissingHealth;
				}
			}
		}
		
		// Idea: Preview possible healing? bandages, bites, reaper, bird faced urn
		
		int fightMultiplier = 2;
        int healthMultiplier = 10;
		
		int energyValue = 5;
		
        // Idea: Maybe change the score value of each hp point based on max hp?
        int playerCurrentHealthScore = playerHealth;
		
		if (preview_guaranteed_healing > 0) {
			playerCurrentHealthScore += preview_guaranteed_healing;
		}
        playerCurrentHealthScore *= healthMultiplier;
		
        int playerMaxHealthScore = playerMaxHealth * 4 * fightMultiplier * healthMultiplier;

        int powerScore = turnNode.startingState.saveState.playerState.powers.stream()
            .map(powerState -> POWER_VALUES .getOrDefault(powerState.powerId, 0) * powerState.amount)
            .reduce(0, Integer::sum);
        
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

        for (CardState card : turnNode.startingState.saveState.playerState.hand) {
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

        for (CardState card : turnNode.startingState.saveState.playerState.drawPile) {
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

        for (CardState card : turnNode.startingState.saveState.playerState.discardPile) {
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
        
        int miracleScore = numMiracles * energyValue * healthMultiplier;
        int expungerScore = expungerDamage;
        int catalystScore = numCatalysts * 2 * healthMultiplier;
        int clawScore = totalClawExtraDamage;
        // Idea: Maybe add score for Alchemize (when no Sozu), Wish (when no Ectoplasm) and limit brake ??
        // Idea: Base catalyst score on current enemy poison and limit brake score in current player strengh?
        
        
        int parasiteScore = turnNode.startingState.saveState.parasiteCount * -100;

        int numOrb = turnNode.startingState.saveState.playerState.maxOrbs;
        
        // Add score for each orb slot, or remove 1000 score when you have 0 orb slots
        int numOrbScore = numOrb == 0 ? -1000 : numOrb * 5;
        
        // Check for Loop
        int loop = 1;
        Optional<PowerState> powerLoop = turnNode.startingState.saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("Loop")).findAny();
        if (powerLoop.isPresent()) {
            loop += powerLoop.get().amount;
        }
		
		int focus = 0;
        Optional<PowerState> powerFocus = turnNode.startingState.saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("Focus")).findAny();
        if (powerFocus.isPresent()) {
            focus += powerFocus.get().amount;
        }
        
        // Check for Electrodynamics
        int electro = 0;
        Optional<PowerState> powerElectro = turnNode.startingState.saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("Electro")).findAny();
        if (powerElectro.isPresent()) {
            electro = 1;
        }
		
		Optional<RelicState> relicCables = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(GoldPlatedCables.ID)).findAny();
        if (relicCables.isPresent()) {
            loop += 1;
        }
		
        int Chip = 0;
		Optional<RelicState> relicEmotionChip = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(EmotionChip.ID)).findAny();
        if (relicEmotionChip.isPresent()) {
			if (relicEmotionChip.get().pulse) {
				Chip = 1;
			}
        }
		
        int FrozenC = 0;
		Optional<RelicState> relicFrozenCore = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(FrozenCore.ID)).findAny();
        if (relicFrozenCore.isPresent()) {
			FrozenC = 1;
        }
		
		int lightning_damage_per_orb = 0;
		int guaranteed_lightning_instances = 0;

        int orbScore = 0;
        for (int iOrb = 0; iOrb < turnNode.startingState.saveState.playerState.orbs.size(); iOrb++) {
            OrbState orb = turnNode.startingState.saveState.playerState.orbs.get(iOrb);
            int current_orbScore = 0;
			
			int current_loop = 1;
			if (iOrb == 0) {
				current_loop = loop;
			}
			
			if (Chip == 1) {
				current_loop += 1;
			}
			
			// Todo: Chip and Loop only work on next turn, so maybe don't count their damage now
            
            if (orb instanceof LightningOrbState) {
                // Add score based on lightning orb damage
				if (electro == 0) {
					current_orbScore += orb.passiveAmount;
				} else {
					current_orbScore += 1;
					lightning_damage_per_orb = orb.passiveAmount;
					guaranteed_lightning_instances += loop;
				}
                
            } else if (orb instanceof FrostOrbState) {
                // Add score based on frost orb block
                current_orbScore += orb.passiveAmount * current_loop;
                
            } else if (orb instanceof DarkOrbState) {
                // Add score based on dark orb damage
                current_orbScore += Math.min(0, (orb.evokeAmount - orb.passiveAmount));
				current_orbScore += orb.passiveAmount * current_loop;
                
            } else if (orb instanceof PlasmaOrbState) {
                // Add score for plasma orb
                current_orbScore += energyValue * current_loop;
				
            } else if (orb instanceof EmptyOrbSlotState) {
				if (FrozenC == 1) {
					FrozenC = 0;
					current_orbScore += Math.max(0, (2+focus)) * current_loop;
				} else {
					current_orbScore = 0;
				}
            }
            
            if (current_orbScore == 0) {
                // If orb slot is empty remove all score added by it (this makes capacitor unplayable when you have no orbs, not the best approach)
                current_orbScore -= 5;
            }
            
            orbScore += current_orbScore;
        }
		
		
		int damageOmega = 0;
		Optional<PowerState> powerOmegaPower = turnNode.startingState.saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("OmegaPower")).findAny();
        if (powerOmegaPower.isPresent()) {
            damageOmega += powerOmegaPower.get().amount;
        }
		int damageCombust = 0;
		Optional<PowerState> powerCombust = turnNode.startingState.saveState.playerState.powers.stream().filter(powerState -> powerState.powerId.equals("Combust")).findAny();
        if (powerCombust.isPresent()) {
            damageCombust += powerCombust.get().amount;
        }
		int damageCalendar = 0;
        Optional<RelicState> relicStoneCalendar = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(StoneCalendar.ID) && relic.counter == 7).findAny();
        if (relicStoneCalendar.isPresent()) {
            damageCalendar += 52;
        }
        
        // Todo: bomb
		
        int monster_count = 0;
		int monster_total_health = 0;
		int monster_preview_health_leftover = 0;
        int poison_count = 0;
        for (MonsterState monster : turnNode.startingState.saveState.curMapNodeState.monsterData) {
			int count_add = 0;
			
            if (!monster.isDying && !monster.isEscaping && !monster.halfDead && monster.currentHealth >= 1) {
                count_add = 1;
				int current_poison_count = 0;
				
                monster_total_health += monster.currentHealth;
				
				int max_damage_monster_can_take = monster.currentHealth;
				int max_damage_per_instance = monster.maxHealth;
				
				int preview_damage = 0;
				
				Optional<PowerState> powerIntangible = monster.powers.stream().filter(powerState -> powerState.powerId.equals("Intangible")).findAny();
                if (powerIntangible.isPresent()) {
					max_damage_per_instance = 1;
                }
				
				Optional<PowerState> powerInvincible = monster.powers.stream().filter(powerState -> powerState.powerId.equals("Invincible")).findAny();
                if (powerInvincible.isPresent()) {
					max_damage_monster_can_take = Math.min(monster.currentHealth, powerInvincible.get().amount);
                }
				
				if (monster.powers.stream().anyMatch(power -> power.powerId.equals("Barricade"))) {
					if (monster.currentBlock >= 1) {
						max_damage_monster_can_take += monster.currentBlock;
						monster_total_health += monster.currentBlock;
					}
				}
				
                Optional<PowerState> powerPoison = monster.powers.stream().filter(powerState -> powerState.powerId.equals("Poison")).findAny();
                if (powerPoison.isPresent()) {
                    current_poison_count += Math.min(max_damage_monster_can_take, powerPoison.get().amount);
					preview_damage += Math.min(max_damage_per_instance, current_poison_count);
                }
				
				if (damageOmega >= 1) {
					preview_damage += Math.min(max_damage_per_instance, damageOmega);
                }
				
				if (damageCombust >= 1) {
					preview_damage += Math.min(max_damage_per_instance, damageCombust);
                }
				
				if (damageCalendar >= 1) {
					preview_damage += Math.min(max_damage_per_instance, damageCalendar);
                }
				
				if (electro == 1 && guaranteed_lightning_instances >= 1) {
					int base_dmg_per_lighing_orb_instance = lightning_damage_per_orb;
					Optional<PowerState> powerLockon = monster.powers.stream().filter(powerState -> powerState.powerId.equals("Lockon")).findAny();
					if (powerLockon.isPresent()) {
						base_dmg_per_lighing_orb_instance = (int)(base_dmg_per_lighing_orb_instance * 1.5F);
					}
					int final_lighing_dmg_per_instance = Math.min(max_damage_per_instance, base_dmg_per_lighing_orb_instance);
					final_lighing_dmg_per_instance *= guaranteed_lightning_instances;
					orbScore += final_lighing_dmg_per_instance;
					preview_damage += final_lighing_dmg_per_instance;
                }
				
				if (preview_damage > max_damage_monster_can_take) {
					preview_damage = max_damage_monster_can_take;
				}
				
				int preview_health_leftover = monster.currentHealth - preview_damage;
				
				monster_preview_health_leftover += preview_health_leftover;
				poison_count += current_poison_count;
            }
			
			if (monster.powers.stream().anyMatch(power -> power.powerId.equals("Unawakened"))) {
				count_add = 1;
                monster_total_health += monster.maxHealth;
			}
			
			if (count_add == 1) {
				monster_count++;
			}
			// Todo: add score for enemy debuffs (consider Paper krane and Odd mushroom)
			// Todo: remove score for enemy buffs
			// Todo: poison/pressurepoints bypasses block while attack dmg does not
			// Idea: Prefer dealing damage to bosses instead of minions?
        }
        //int poisonScore = poison_count;
        int poisonScore = 0;
		
		turnNode.monsterTotalHealth = monster_total_health;
		//int monsterHealthScore = monster_total_health * -1;
		int monsterHealthScore = monster_preview_health_leftover * -1;
        
        // Todo: if Ice cream = add score for energy?
        
        // Todo: if Calipers | Blur | Barricade = add score for armor at the end of turn?
        
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
		
        int ritualDaggerScore = totalRitualDaggerDamage * fightMultiplier * healthMultiplier;
        int GeneticAlgorithmScore = totalGeneticAlgorithmBlock * fightMultiplier * healthMultiplier;
        int feedScore = numFeeds * 4;
        int lessonLearnedScore = numLessonLearned * 10 + turnNode.startingState.saveState.lessonLearnedCount * 10 * fightMultiplier * healthMultiplier;
        
        int goldScore = 0;
		Optional<RelicState> relicCourier = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Courier.ID)).findAny();
        Optional<RelicState> relicMembershipCard = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(MembershipCard.ID)).findAny();
		if (relicCourier.isPresent()) {
            goldScore = MathUtils.round(turnNode.startingState.saveState.playerState.gold * 1.25F);
        } else {
			goldScore = turnNode.startingState.saveState.playerState.gold;
		}
		if (relicMembershipCard.isPresent()) {
            goldScore *= 2;
        }
        goldScore *= 2 * fightMultiplier * healthMultiplier;

        int potionScore = getPotionScore(turnNode.startingState.saveState);
        
        int relicScore = getRelicScoreInCombat(turnNode.startingState.saveState);

        int additonalHeuristicScore =
                BattleAiMod.additionalValueFunctions.stream()
                        .map(function -> function
                                .apply(turnNode.startingState.saveState)).mapToInt(Integer::intValue).sum();

        return numOrbScore +
               orbScore +
               poisonScore +
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
			   playerMaxHealthScore +
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
        
        // Idea: Maybe change the score value of each hp point based on max hp?
        int healthMultiplier = 10;
        int playerCurrentHealthScore = node.saveState.playerState.getCurrentHealth() * healthMultiplier;
        int playerMaxHealthScore = node.saveState.playerState.maxHealth * 4 * healthMultiplier;

        int ritualDaggerScore = totalRitualDaggerDamage * healthMultiplier;
        int GeneticAlgorithmScore = totalGeneticAlgorithmBlock * healthMultiplier;
        int lessonLearnedScore = node.saveState.lessonLearnedCount * 10 * healthMultiplier;
        
		int goldScore = 0;
		Optional<RelicState> relicCourier = node.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Courier.ID)).findAny();
        Optional<RelicState> relicMembershipCard = node.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(MembershipCard.ID)).findAny();
		if (relicCourier.isPresent()) {
            goldScore = MathUtils.round(node.saveState.playerState.gold * 1.25F);
        } else {
			goldScore = node.saveState.playerState.gold;
		}
		if (relicMembershipCard.isPresent()) {
            goldScore *= 2;
        }
        goldScore *= 2 * healthMultiplier;
        
        int potionScore = getPotionScore(node.saveState);
		
        int relicScore = getRelicScoreEndOfCombat(node.saveState);
        
        int additonalHeuristicScore =
                BattleAiMod.additionalValueFunctions.stream()
                        .map(function -> function
                                .apply(node.saveState)).mapToInt(Integer::intValue).sum();
        
        return ritualDaggerScore +
               GeneticAlgorithmScore +
               lessonLearnedScore +
               goldScore +
               playerCurrentHealthScore +
			   playerMaxHealthScore +
               potionScore +
               relicScore +
               additonalHeuristicScore;
    }

	public static int getPotionScore(SaveState saveState) {
		int healthMultiplier = 10;
		
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
			if (!POTION_VALUES.containsKey(potion.potionId) || PotionState.UNPLAYABLE_POTIONS.contains(potion.potionId)) {
                continue;
            }
			if (hasBark == 1 && POTION_BARK_VALUES.containsKey(potion.potionId)) {
				potionScore += POTION_BARK_VALUES.get(potion.potionId);
			} else {
				potionScore += POTION_VALUES.get(potion.potionId);
			}
			if (hasToy == 1) {
				potionScore += healthMultiplier * 5;
			}
		}
		
		return potionScore;
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
