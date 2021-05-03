package battleaimod.savestate.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.watcher.WrathNextTurnPower;

public class WrathNextTurnPowerState extends PowerState {
    public WrathNextTurnPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new WrathNextTurnPower(targetAndSource);
    }
}
