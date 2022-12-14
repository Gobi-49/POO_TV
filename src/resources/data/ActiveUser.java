package resources.data;

import filein.UsersInput;
import resources.pages.Page;

public class ActiveUser {
    private User user;
    private Page currentPage;
    public ActiveUser() {
        user = null;
        currentPage = Database.getDatabase().getHomepageUnauthenticated();
    }
    public ActiveUser(User user) {
        this.user = user;
        currentPage = Database.getDatabase().getHomepageUnauthenticated();
    }
    public Page getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
