package kireiko.dev.quark.shield.text;

import kireiko.dev.quark.shield.constant.DeviaceType;
import kireiko.dev.quark.shield.constant.SpamType;
import lombok.Data;

@Data
public class Check {
    private boolean isSpam;
    private SpamType type;
    private DeviaceType deviace;
    public Check(boolean isSpam, SpamType type, DeviaceType deviace) {
        this.isSpam = isSpam;
        this.type = type;
        this.deviace = deviace;
    }
}
