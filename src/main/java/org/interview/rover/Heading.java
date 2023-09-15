package org.interview.rover;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum Heading {
    N(0),
    E(90),
    S(180),
    W(270);
    private final int degree;
    private static final Map<Integer, Heading> map = new HashMap<>();

    static {

        for (final Heading heading : Heading.values()) {
            map.put(heading.degree, heading);
        }
    }

    @Override
    public String toString() {
        return this.name();
    }

    public static Heading getByDegree(int degree) {
        return map.get(degree);
    }

}