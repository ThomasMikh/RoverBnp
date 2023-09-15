package org.interview.rover;

import org.interview.error.PlateauOutOfBoundError;


public record Rover(RoverPosition position, int limitY, int limitX) implements IRover {
    public void face(final Heading heading) {
        position.setHeading(heading);
    }

    @Override
    public void moveFront() throws PlateauOutOfBoundError {
        final Heading heading = position.getHeading();
        if (heading.equals(Heading.N) || heading.equals(Heading.S)) {
            int y = position.getY();
            y = heading.equals(Heading.N) ? y + 1 : y - 1;
            if (y > limitY || y < 0) {
                throw new PlateauOutOfBoundError();
            }
            position.setY(y);
        } else {
            int x = position.getX();
            x = heading.equals(Heading.E) ? x + 1 : x - 1;
            if (x > limitX || x < 0) {
                throw new PlateauOutOfBoundError();
            }
            position.setX(x);
        }
    }
}