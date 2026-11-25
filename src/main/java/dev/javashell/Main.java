package dev.javashell;

import dev.javashell.terminal.TerminalManager;
import org.jline.terminal.Terminal;

import java.io.IOException;

public class Main {
    static void main() {

        try (TerminalManager terminalManager =
                new TerminalManager()) {

            Terminal terminal = terminalManager.getTerminal();

            terminal.writer().println("Welcome to JavaShell!");
            terminal.writer().println("Type 'exit' to close.");
            terminal.writer().flush();

            while (true) {

                String input = terminalManager
                        .getReader()
                        .readLine("javashell $ ");

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                terminal.writer().println("You entered: " + input);
                terminal.writer().flush();
            }

        } catch (IOException e) {

            System.err.println("Failed to initialize terminal: " + e.getMessage());
        }
    }
}
