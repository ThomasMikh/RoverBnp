package org.interview.rover;

import org.interview.error.PlateauOutOfBoundError;

public interface IRover {
    RoverPosition position();

    void moveFront() throws PlateauOutOfBoundError;
}
