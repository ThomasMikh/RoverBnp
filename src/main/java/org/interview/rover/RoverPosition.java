package org.interview.rover;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RoverPosition {
    private Heading heading;
    private int x;
    private int y;

    @Override
    public String toString() {
        return x + " " + y + " " + heading.toString();
    }
}
