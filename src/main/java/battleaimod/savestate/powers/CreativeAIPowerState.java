package battleaimod.savestate.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.CreativeAIPower;

public class CreativeAIPowerState extends PowerState {
    public CreativeAIPowerState(AbstractPower power) {
        super(power);
    }

    @Override
    public AbstractPower loadPower(AbstractCreature targetAndSource) {
        return new CreativeAIPower(targetAndSource, amount);
    }
}
