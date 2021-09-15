package org.aprikhodskiy.otusintegration.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum GradeEnum {
    JUNIOR, MIDDLE, SENIOR, PRINCIPAL;

    private static final List<GradeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static GradeEnum getRandom() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public GradeEnum next() {
        return VALUES.get(Math.min(this.ordinal() + 1, VALUES.size() - 1));
    }
}