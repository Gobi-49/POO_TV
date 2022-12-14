package resources.pages;

import resources.visitor.Visitable;
import resources.visitor.Visitor;

import java.util.ArrayList;
import java.util.Arrays;

public class HomepageAuthenticated extends Page   {

    @Override
    public boolean acceptChange(String page) {
        ArrayList<String> acceptedPage = new ArrayList<>
                (Arrays.asList("Movies", "Upgrades", "Logout", "Homepage autentificat"));
        return acceptedPage.contains(page);
    }
}
