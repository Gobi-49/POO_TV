package resources.pages;

import java.util.ArrayList;
import java.util.Arrays;

public class LogoutPage extends Page {
    @Override
    public final boolean acceptChange(final String page) {
        ArrayList<String> acceptedPage = new ArrayList<>(
                Arrays.asList("logout", "login", "register"));
        return acceptedPage.contains(page);
    }
}
