package com.exam;

import java.util.Arrays;

public enum SceneSpecification {
    YELLOW(1),PINK(2),ORANGE(3),BLACK(4),GREEN(5),PURPLE(6);
    private final int id;
    public int getId() { return id; }
    SceneSpecification(int v) {
        this.id=v-1;
    }

    @Override
    public String toString() {
        return String.format("%8s,",this.name());
    }
}
