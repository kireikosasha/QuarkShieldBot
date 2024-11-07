package kireiko.dev.quark.shield.math;

import kireiko.dev.quark.shield.constant.DeviaceType;

public class MathBuilder {
    public static DeviaceType buildDeviance(float percent) {
        if (percent > 55) return DeviaceType.EXTREME;
        else if (percent > 40) return DeviaceType.HIGH;
        else if (percent > 25) return DeviaceType.MEDIUM;
        else return DeviaceType.LOW;
    }
}
