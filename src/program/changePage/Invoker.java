package program.changePage;

import resources.pages.Page;

import java.util.LinkedList;
import java.util.Stack;

public class Invoker {
    private LinkedList<Command> history = new LinkedList<>();

    public void changePage(Command command) {
        history.push(command);
        command.execute();
    }

    public void undo() {
        if (history.isEmpty()) {
            Page.error();
            return;
        }
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }
}
