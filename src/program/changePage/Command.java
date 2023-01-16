package program.changePage;

import resources.data.ActiveUser;
import resources.pages.Page;

public interface Command {
    void execute();
    void undo();
}
