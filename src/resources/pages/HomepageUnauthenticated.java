package resources.pages;


import java.util.ArrayList;
import java.util.Arrays;

public class HomepageUnauthenticated extends Page {
    @Override
    public final boolean acceptChange(final String page) {
        ArrayList<String> acceptedPage = new ArrayList<>(
                Arrays.asList("login", "register", "homepage neautentificat"));
        return acceptedPage.contains(page);
    }
}
