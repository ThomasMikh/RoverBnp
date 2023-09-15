package org.interview.executor;

import org.interview.command.CharacterCommand;
import org.interview.command.IRoverCommand;
import org.interview.command.RoverCommandCharacter;
import org.interview.error.InputError;
import org.interview.parser.IParser;
import org.interview.rover.Heading;
import org.interview.rover.Rover;
import org.interview.rover.RoverPosition;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;


public class CommandStdExecutor extends CommandExecutor<CharacterCommand, List<List<String>>> {
    int sizeX;
    int sizeY;
    private List<List<String>> instructions;
    private final IParser<List<List<String>>> parser;

    public CommandStdExecutor(final IParser<List<List<String>>> parser) {
        this.parser = parser;
    }


    @Override
    IParser<List<List<String>>> getParser() {
        return this.parser;
    }

    @Override
    void parseInput(final IParser<List<List<String>>> parser) {
        instructions = parser.parse();
    }

    void getState() throws InputError {
        if ((instructions.get(0).size() != 2)) {
            throw new InputError();
        }
        sizeX = Integer.parseInt(instructions.get(0).get(0));
        sizeY = Integer.parseInt(instructions.get(0).get(1));
    }


    @Override
    Queue<IRoverCommand<CharacterCommand>> initCommands() throws InputError {
        final Queue<IRoverCommand<CharacterCommand>> commands = new ArrayDeque<>();
        for (int i = 1; i < instructions.size() - 1; i += 2) {
            try {
                final RoverPosition roverPosition = new RoverPosition(Heading.valueOf(instructions.get(i).get(2)),
                        Integer.parseInt(instructions.get(i).get(0)), Integer.parseInt(instructions.get(i).get(1)));
                final Rover rover = new Rover(roverPosition, sizeY, sizeX);
                final char[] command = instructions.get(i + 1).get(0).toCharArray();
                commands.add(
                        new RoverCommandCharacter(IntStream.range(0, command.length)
                                .mapToObj(idx -> Character.toString(command[idx]))
                                .map(CharacterCommand::valueOf)
                                .toList(),
                                rover
                        ));
            } catch (final IndexOutOfBoundsException | NumberFormatException e) {
                throw new InputError();
            }
        }
        return commands;
    }

    @Override
    void runCommands(final Queue<IRoverCommand<CharacterCommand>> queue) {
        while (!queue.isEmpty()) {
            final IRoverCommand<CharacterCommand> command = queue.poll();
            final Rover rover = command.rover();
            for (final CharacterCommand c : command.commands()) {
                c.applyCommand(rover);
            }
            notifyNewPosition(rover.position());
        }
    }


    void notifyNewPosition(final RoverPosition position) {
        System.out.println(position.toString());
    }
}
