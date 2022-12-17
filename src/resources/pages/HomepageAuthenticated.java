package resources.pages;


import java.util.ArrayList;
import java.util.Arrays;

public class HomepageAuthenticated extends Page   {
    @Override
    public final boolean acceptChange(final String page) {
        ArrayList<String> acceptedPage = new ArrayList<>(
                Arrays.asList("movies", "upgrades", "logout", "homepage autentificat"));
        return acceptedPage.contains(page);
    }
}
