package resources.pages;

import resources.visitor.Visitable;
import resources.visitor.Visitor;

import java.util.ArrayList;
import java.util.Arrays;

public class DetailsPage extends Page {
    @Override
    public boolean acceptChange(String page) {
        ArrayList<String> acceptedPage = new ArrayList<>
                (Arrays.asList("Homepage autentificat", "Movies", "Upgrades", "Logout", "See details"));
        return acceptedPage.contains(page);
    }
}
