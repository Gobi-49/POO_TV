package resources;

import resources.data.CurrentUser;
import resources.data.Database;
import resources.pages.HomepageAuthenticated;
import resources.pages.HomepageUnauthenticated;
import resources.pages.Page;

public final class Actions {
    public static void changePage(CurrentUser user, String page) {
        if (!user.getCurrentPage().acceptChange(page)) {
            return;
        }
        switch (page) {
            case "Homepage neautentificat" -> user.setCurrentPage(Database.getDatabase().getHomepageUnauthenticated());
            case "Homepage autentificat" -> user.setCurrentPage(Database.getDatabase().getHomepageAuthenticated());
            case "Login" -> user.setCurrentPage(Database.getDatabase().getLoginPage());
            case "Register" -> user.setCurrentPage(Database.getDatabase().getRegisterPage());
            case "Movies" -> user.setCurrentPage(Database.getDatabase().getMoviesPage());
            case "See details" -> user.setCurrentPage(Database.getDatabase().getDetailsPage());
            case "Upgrades" -> user.setCurrentPage(Database.getDatabase().getUpgradesPage());
            case "Logout" -> user.setCurrentPage(Database.getDatabase().getLogoutPage());
        }
    }
}
