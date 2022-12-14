package resources.pages;

import resources.visitor.Visitable;
import resources.visitor.Visitor;

import java.util.ArrayList;
import java.util.Arrays;

public class UpgradesPage extends Page {
    @Override
    public boolean acceptChange(String page) {
        ArrayList<String> acceptedPage = new ArrayList<>
                (Arrays.asList("homepage autentificat", "movies", "upgrades", "logout"));
        return acceptedPage.contains(page);
    }
}
