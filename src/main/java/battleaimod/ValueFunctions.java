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

import savestate.orbs.*;
import savestate.CardState;
import savestate.PotionState;
import savestate.SaveState;
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
        //put(TheBombPower.POWER_ID, 3);
        
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
        put(FruitJuice.POTION_ID, 30);
        
        put(Ambrosia.POTION_ID, 100);
        put(AncientPotion.POTION_ID, 20);
        put(AttackPotion.POTION_ID, 20);
        put(BlessingOfTheForge.POTION_ID, 20);
        put(BlockPotion.POTION_ID, 110);
        put(BloodPotion.POTION_ID, 120);
        
        put(BottledMiracle.POTION_ID, 60);
        put(ColorlessPotion.POTION_ID, 20);
        put(CunningPotion.POTION_ID, 40);
        put(StrengthPotion.POTION_ID, 30);
        put(DexterityPotion.POTION_ID, 30);
        put(DistilledChaosPotion.POTION_ID, 40);
        put(DuplicationPotion.POTION_ID, 100);
        put(EnergyPotion.POTION_ID, 60);
        put(EssenceOfDarkness.POTION_ID, 60);
        put(EssenceOfSteel.POTION_ID, 60);
        put(ExplosivePotion.POTION_ID, 40);
        put(FearPotion.POTION_ID, 20);
        put(FirePotion.POTION_ID, 30);
        put(FocusPotion.POTION_ID, 60);
        
        put(EntropicBrew.POTION_ID, 300);
        put(FairyPotion.POTION_ID, 300);
        put(GhostInAJar.POTION_ID, 200);
        put(RegenPotion.POTION_ID, 100);

        
        put(HeartOfIron.POTION_ID, 48);
        put(LiquidBronze.POTION_ID, 20);
        put(LiquidMemories.POTION_ID, 30);
        put(PoisonPotion.POTION_ID, 20);
        put(PotionOfCapacity.POTION_ID, 30);
        put(PowerPotion.POTION_ID, 50);
        
        put(SneckoOil.POTION_ID, 75);
        put(SwiftPotion.POTION_ID, 40);
        
        put(SpeedPotion.POTION_ID, 75);
        put(SteroidPotion.POTION_ID, 21);
        
        put(WeakenPotion.POTION_ID, 50);
        
        put(StancePotion.POTION_ID, 0);
        put(SmokeBomb.POTION_ID, 0);
        put(Elixir.POTION_ID, 20);
        put(GamblersBrew.POTION_ID, 500);
        put(CultistPotion.POTION_ID, 30);
    }};

    public static int caclculateTurnScore(TurnNode turnNode) {
        
        int playerHealth = turnNode.startingState.saveState.playerState.getCurrentHealth();
		int playerMaxHealth = turnNode.startingState.saveState.playerState.maxHealth;
		
		int preview_guaranteed_healing = 0;
		
		int has_Ectoplasm = 0;
		Optional<RelicState> relicEctoplasm = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Ectoplasm.ID)).findAny();
        if (relicEctoplasm.isPresent()) {
            has_Ectoplasm = 1;
        }
		
		int has_MagicFlower = 0;
		Optional<RelicState> relicMagicFlower = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(MagicFlower.ID)).findAny();
        if (relicMagicFlower.isPresent()) {
            has_MagicFlower = 1;
        }
		
		Optional<RelicState> relicFaceOfCleric = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(FaceOfCleric.ID)).findAny();
        if (relicFaceOfCleric.isPresent()) {
            if (has_MagicFlower == 1) {
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
		
		Optional<RelicState> relicBloodVial = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(BloodVial.ID)).findAny();
        if (relicBloodVial.isPresent()) {
            if (has_MagicFlower == 1) {
				preview_guaranteed_healing += 3;
			} else {
				preview_guaranteed_healing += 2;
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
		
		Optional<RelicState> relicBloodyIdol = turnNode.startingState.saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(BloodyIdol.ID)).findAny();
        if (relicBloodyIdol.isPresent() && has_Ectoplasm == 0) {
            if (has_MagicFlower == 1) {
				preview_guaranteed_healing += 8;
			} else {
				preview_guaranteed_healing += 5;
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
		
		// Preview possible healing?
		// bandages, bites, reaper, bird faced urn
		
		int fightMultiplier = 2;
        int healthMultiplier = 10;
		
        // Maybe change the score value of each hp point based on max hp?
        int playerCurrentHealthScore = playerHealth;
        playerCurrentHealthScore += preview_guaranteed_healing;
		if (playerCurrentHealthScore > playerMaxHealth) {
			playerCurrentHealthScore = playerMaxHealth;
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
		
        // add score for rampage scaling
        // maybe add score for pressure points scaling?

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
        
        int miracleScore = numMiracles * 2 * healthMultiplier;
        int expungerScore = expungerDamage;
        int catalystScore = numCatalysts * 2 * healthMultiplier;
        int clawScore = totalClawExtraDamage;
        // Maybe add score for Alchemize (when no Sozu), Wish (when no Ectoplasm) and limit brake ??
        // Base catalyst score on current enemy poison and limit brake score in current player strengh?
        
        
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
		
		int lightning_damage_per_orb = 0;
		int guaranteed_lightning_instances = 0;

        int orbScore = 0;
        for (int iOrb = 0; iOrb < turnNode.startingState.saveState.playerState.orbs.size(); iOrb++) {
            OrbState orb = turnNode.startingState.saveState.playerState.orbs.get(iOrb);
            int current_orbScore = 0;
			
			int lightning = 0;
            
            if (orb instanceof LightningOrbState) {
                // Add score based on lightning orb damage
				if (electro == 0) {
					current_orbScore += orb.passiveAmount;
				}
				
				lightning_damage_per_orb = orb.passiveAmount;
				lightning = 1;
				guaranteed_lightning_instances += 1;
                
            } else if (orb instanceof FrostOrbState) {
                // Add score based on frost orb block
                current_orbScore += orb.passiveAmount;
                
            } else if (orb instanceof DarkOrbState) {
                // Add score based on dark orb damage
                current_orbScore += orb.evokeAmount;
                
            } else if (orb instanceof PlasmaOrbState) {
                // Add score for plasma orb
                current_orbScore += 5;
            }
			
			if (iOrb == 0) {
                current_orbScore *= loop;
				if (lightning == 1) {
					guaranteed_lightning_instances += loop-1;
				}
            }
            
            if (orb instanceof EmptyOrbSlotState || current_orbScore == 0) {
                // If orb slot is empty remove all score added by it (this makes capacitor unplayable when you have no orbs, not the best approach)
                current_orbScore -= 5;
            }
            
            orbScore += current_orbScore;
            // Add Frozen core somewhere around here
            // Add Emotion Chip somewhere around here
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
        
        // bomb
		
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
				
				int max_possible_damage = monster.currentHealth;
				int max_damage_instance = monster.maxHealth;
				
				int preview_damage = 0;
				
				Optional<PowerState> powerIntangible = monster.powers.stream().filter(powerState -> powerState.powerId.equals("Intangible")).findAny();
                if (powerIntangible.isPresent()) {
					max_damage_instance = 1;
                }
				
				Optional<PowerState> powerInvincible = monster.powers.stream().filter(powerState -> powerState.powerId.equals("Invincible")).findAny();
                if (powerInvincible.isPresent()) {
					max_possible_damage = Math.min(monster.currentHealth, powerInvincible.get().amount);
                }
				
				if (monster.powers.stream().anyMatch(power -> power.powerId.equals("Barricade"))) {
					if (monster.currentBlock >= 1) {
						max_possible_damage += monster.currentBlock;
						monster_total_health += monster.currentBlock;
					}
				}
				
                Optional<PowerState> powerPoison = monster.powers.stream().filter(powerState -> powerState.powerId.equals("Poison")).findAny();
                if (powerPoison.isPresent()) {
                    current_poison_count += Math.min(max_possible_damage, powerPoison.get().amount);
					preview_damage += Math.min(max_damage_instance, current_poison_count);
                }
				
				if (damageOmega >= 1) {
					preview_damage += Math.min(max_damage_instance, damageOmega);
                }
				
				if (damageCombust >= 1) {
					preview_damage += Math.min(max_damage_instance, damageCombust);
                }
				
				if (damageCalendar >= 1) {
					preview_damage += Math.min(max_damage_instance, damageCalendar);
                }
				
				if (electro == 1 && guaranteed_lightning_instances >= 1) {
					int inst_dmg = lightning_damage_per_orb;
					Optional<PowerState> powerLockon = monster.powers.stream().filter(powerState -> powerState.powerId.equals("Lockon")).findAny();
					if (powerLockon.isPresent()) {
						inst_dmg = (int)(inst_dmg * 1.5F);
					}
					int total_lit_dmg = Math.min(max_damage_instance, inst_dmg);
					total_lit_dmg *= guaranteed_lightning_instances;
					orbScore += total_lit_dmg;
					preview_damage += total_lit_dmg;
                }
				
				if (preview_damage > max_possible_damage) {
					preview_damage = max_possible_damage;
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
			// add score for enemy debuffs (consider Paper krane and Odd mushroom)
			// remove score for enemy buffs
			// Prefer dealing damage to bosses instead of minions?
			// poison/pressurepoints bypasses block while attack dmg does not
        }
        //int poisonScore = poison_count;
        int poisonScore = 0;
		
		turnNode.monsterTotalHealth = monster_total_health;
		//int monsterHealthScore = monster_total_health * -1;
		int monsterHealthScore = monster_preview_health_leftover * -1;
        
        // if Ice cream = add score for energy?
        
        // if Calipers | Blur | Barricade = add score for armor at the end of turn?
        
        // if Piramid | Equilibrium = add score for handsize at the end of turn?
        
        // If you have All for one add score for each 0 cost card in the discard pile?
        
        // If you have grand finalle in the hand add a lot score for when draw pile is empty?
        
        // If you have thunderstrike add score for each channeled lightning orb?
        
        // If you have blizzard add score for each channeled frost orb?
        
        // Add negative score for each status or curse in hand, draw and discard piles (maybe dif values for each pile) (medkit + bluecandle ?)
        
        // If you have X cost cards in hand add score for current energy?
        
        // If you have spirit shield in hand add score for hand size?
        
        // If you have barrage in hand add score based on channeled orbs?
        
        // If you have Stack in hand add score based on discard pile size?
        
        // If you have aggregate in hand add score based on draw pile size?
        
        // If you have armaments in hand add score based on unupgraded cards in hand?
        
        // If you have Apotheosis in hand add score based on unupgraded cards in hand/draw/discard?
        
        // If you have Body slam in hand add score based on current block?
        
        // If you have Clash in hand add score when you have only attacks in hand?
        
        // Base Fumes power score in the amount of enemies?
        
        // Add score for stances (or maybe change power scores based on instances? (e.g. Like water for when you are in calm))?
        
        // Maybe something to add score when reducing cards cost? (Madness/Mummyhand/Enlightenment/Setup/)
		
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
        
        int relicScore = getRelicScoreDuring(turnNode.startingState.saveState);

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
        
        // Maybe change the score value of each hp point based on max hp?
        int playerCurrentHealthScore = node.saveState.playerState.getCurrentHealth();
        int playerMaxHealthScore = node.saveState.playerState.maxHealth * 4;

        int ritualDaggerScore = totalRitualDaggerDamage;
        int GeneticAlgorithmScore = totalGeneticAlgorithmBlock;
        int lessonLearnedScore = node.saveState.lessonLearnedCount * 10;
        
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
        goldScore *= 2;
        
        int potionScore = getPotionScore(node.saveState);
		
        int relicScore = getRelicScoreEnd(node.saveState);
        
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
        return saveState.playerState.potions.stream().map(potionState -> {
            if (potionState.potionId.equals("Potion Slot") || !POTION_VALUES.containsKey(potionState.potionId) || PotionState.UNPLAYABLE_POTIONS.contains(potionState.potionId)) {
                return 0;
            }
            return POTION_VALUES.get(potionState.potionId);
        }).reduce(0, Integer::sum);
    }

    public static int getRelicScoreEnd(SaveState saveState) {
        int relicScore = 0;
        
        Optional<RelicState> relicLizardTail = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(LizardTail.ID) && relic.counter != -2).findAny();
        if (relicLizardTail.isPresent()) {
            relicScore += 400;
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
        
        Optional<RelicState> relicHappyFlower = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(HappyFlower.ID)).findAny();
        if (relicHappyFlower.isPresent()) {
            relicScore += relicHappyFlower.get().counter * 2;
        }
        
        Optional<RelicState> relicSundial = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Sundial.ID)).findAny();
        if (relicSundial.isPresent()) {
            relicScore += relicSundial.get().counter * 3;
        }
        
        Optional<RelicState> relicIncenseBurner = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(IncenseBurner.ID)).findAny();
        if (relicIncenseBurner.isPresent()) {
            relicScore += relicIncenseBurner.get().counter * 2;
        }
        
        return relicScore;
    }

    public static int getRelicScoreDuring(SaveState saveState) {
        int relicScore = 0;
        
        Optional<RelicState> relicLizardTail = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(LizardTail.ID) && relic.counter != -2).findAny();
        if (relicLizardTail.isPresent()) {
            relicScore += 400;
        }
        
        Optional<RelicState> relicOmamori = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Omamori.ID)).findAny();
        if (relicOmamori.isPresent()) {
            relicScore += relicOmamori.get().counter * 100;
        }
        
        Optional<RelicState> relicKunai = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Kunai.ID)).findAny();
        if (relicKunai.isPresent()) {
            relicScore += relicKunai.get().counter * 3;
        }
        
        Optional<RelicState> relicShuriken = saveState.playerState.relics.stream().filter(relic -> relic.relicId.equals(Shuriken.ID)).findAny();
        if (relicShuriken.isPresent()) {
            relicScore += relicShuriken.get().counter * 3;
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
        
        // fan
        // letter
        // pocketwatch
        
        // orichalcum when no block?
        // Cloak Clasp base on hand size?
        
        // Increase potion score when Bark/Toy?
        
        // Empty potion slot score for white beast statue and no sozu?
        
        return relicScore;
    }
}
