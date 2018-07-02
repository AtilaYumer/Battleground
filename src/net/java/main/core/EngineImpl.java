package net.java.main.core;

import net.java.main.dispachers.CommandDispatcherImpl;
import net.java.main.exceptions.GameException;
import net.java.main.interfaces.InputReader;
import net.java.main.io.ConsoleReader;
import net.java.main.io.OutputWriter;

import java.io.IOException;

public class EngineImpl {
    private boolean isStarted;
    private OutputWriter outputWriter;
    private InputReader inputReader;
    private CommandDispatcherImpl commandDispatcher;

    public EngineImpl(
            OutputWriter outputWriter,
            CommandDispatcherImpl commandDispatcher) {
        this.outputWriter = outputWriter;
        this.inputReader = new ConsoleReader();
        this.commandDispatcher = commandDispatcher;
    }

    public void start() {

        while (true) {
            try {
                String userInput = this.inputReader.readLine();
                String[] args = userInput.split("\\s+");

                String result = this.commandDispatcher.dispatchCommand(args);

                this.outputWriter.writeLine(result);

                if (result.equals("Game over!")) {
                    break;
                }
            } catch (GameException | IOException e) {
                this.outputWriter.writeLine(e.getMessage());
            }
        }
    }
}
