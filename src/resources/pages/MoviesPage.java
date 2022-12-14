package resources.pages;

import resources.visitor.Visitable;
import resources.visitor.Visitor;

import java.util.ArrayList;
import java.util.Arrays;

public class MoviesPage extends Page {
    @Override
    public boolean acceptChange(String page) {
        ArrayList<String> acceptedPage = new ArrayList<>
                (Arrays.asList("homepage autentificat", "see details",  "logout", "movies"));
        return acceptedPage.contains(page);
    }
}
