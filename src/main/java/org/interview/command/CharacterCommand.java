package org.interview.command;

import org.interview.error.InvalidInstructionError;
import org.interview.rover.Heading;
import org.interview.rover.Rover;

public enum CharacterCommand {
    M,
    R,
    L;

    public void applyCommand(final Rover rover) throws InvalidInstructionError {
        switch (this) {
            case L -> rover.face(applyLeftRotation(rover.position().getHeading()));
            case R -> rover.face(applyRightRotation(rover.position().getHeading()));
            case M -> rover.moveFront();
            default -> throw new InvalidInstructionError();
        }
    }

    public Heading applyLeftRotation(final Heading currentHeading) {
        return Heading.getByDegree((currentHeading.getDegree() + 270) % 360);
    }

    public Heading applyRightRotation(final Heading currentHeading) {
        return Heading.getByDegree((currentHeading.getDegree() + 90) % 360);
    }
}
