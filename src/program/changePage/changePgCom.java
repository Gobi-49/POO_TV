package program.changePage;

import resources.data.ActiveUser;
import resources.pages.Page;

public class changePgCom implements Command {
    private Page prevPage;
    private final ActiveUser activeUser;
    Page nextPage;
    public changePgCom(ActiveUser activeUser, Page page) {
        this.activeUser = activeUser;
        nextPage = page;
    }

    @Override
    public void execute() {
        prevPage = activeUser.getCurrentPage();
        activeUser.setCurrentPage(nextPage);
        activeUser.getCurrentPage().defaultAction(activeUser);
    }

    @Override
    public void undo() {
        activeUser.setCurrentPage(prevPage);
        activeUser.getCurrentPage().defaultAction(activeUser);
    }
}
