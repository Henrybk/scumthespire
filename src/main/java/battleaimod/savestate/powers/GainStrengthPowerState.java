package battleaimod.savestate.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.GainStrengthPower;

public class GainStrengthPowerState extends PowerState {
    public GainStrengthPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new GainStrengthPower(targetAndSource, amount);
    }
}
