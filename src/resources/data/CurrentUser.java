package resources.data;

import filein.UsersInput;
import resources.pages.HomepageAuthenticated;
import resources.pages.HomepageUnauthenticated;
import resources.pages.Page;

import java.util.ArrayList;

public class CurrentUser extends User{
    private Page currentPage;
    public CurrentUser() {
        setCredentials(null);
        currentPage = Database.getDatabase().getHomepageUnauthenticated();
    }
    public CurrentUser(UsersInput usersInput) {
        super(usersInput);
        currentPage = Database.getDatabase().getHomepageUnauthenticated();
    }
    public Page getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
    }
}
