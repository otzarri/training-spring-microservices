package com.in28minutes.microservices.bean;

import java.util.StringJoiner;

public class LimitConfiguration {
    private int maximum;
    private int minimum;

    public LimitConfiguration() {
    }

    public LimitConfiguration(int maximum, int minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LimitConfiguration.class.getSimpleName() + "[", "]")
                .add("maximum=" + maximum)
                .add("minimum=" + minimum)
                .toString();
    }
}
