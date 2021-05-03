package battleaimod.savestate.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.ToolsOfTheTradePower;

public class ToolsOfTheTradePowerState extends PowerState {
    public ToolsOfTheTradePowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new ToolsOfTheTradePower(targetAndSource, amount);
    }
}
