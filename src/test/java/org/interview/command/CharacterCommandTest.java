package org.interview.command;

import org.interview.rover.Heading;
import org.interview.rover.Rover;
import org.interview.rover.RoverPosition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCommandTest {
    final Rover rover = new Rover(new RoverPosition(Heading.N, 1, 1), 10, 10);


    @Test
    void testRotationNorth() {
        rover.position().setHeading(Heading.N);
        CharacterCommand command = CharacterCommand.L;
        command.applyCommand(rover);
        assertEquals(Heading.W, rover.position().getHeading());

        rover.position().setHeading(Heading.N);
        command = CharacterCommand.R;
        command.applyCommand(rover);
        assertEquals(Heading.E, rover.position().getHeading());
    }

    @Test
    void testRotationWest() {
        rover.position().setHeading(Heading.W);
        CharacterCommand command = CharacterCommand.L;
        command.applyCommand(rover);
        assertEquals(Heading.S, rover.position().getHeading());

        rover.position().setHeading(Heading.W);
        command = CharacterCommand.R;
        command.applyCommand(rover);
        assertEquals(Heading.N, rover.position().getHeading());
    }

    @Test
    void testRotationEst() {
        rover.position().setHeading(Heading.E);
        CharacterCommand command = CharacterCommand.L;
        command.applyCommand(rover);
        assertEquals(Heading.N, rover.position().getHeading());

        rover.position().setHeading(Heading.E);
        command = CharacterCommand.R;
        command.applyCommand(rover);
        assertEquals(Heading.S, rover.position().getHeading());
    }

    @Test
    void testRotationSouth() {
        rover.position().setHeading(Heading.S);
        CharacterCommand command = CharacterCommand.L;
        command.applyCommand(rover);
        assertEquals(Heading.E, rover.position().getHeading());

        rover.position().setHeading(Heading.S);
        command = CharacterCommand.R;
        command.applyCommand(rover);
        assertEquals(Heading.W, rover.position().getHeading());
    }
}