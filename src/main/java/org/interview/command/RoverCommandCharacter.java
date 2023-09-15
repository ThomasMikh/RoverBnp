package org.interview.command;


import org.interview.rover.Rover;

import java.util.List;

public record RoverCommandCharacter(List<CharacterCommand> commands,
                                    Rover rover) implements IRoverCommand<CharacterCommand> {
}
