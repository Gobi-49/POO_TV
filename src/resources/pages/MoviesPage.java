package resources.pages;

import com.fasterxml.jackson.databind.node.ObjectNode;
import filein.ActionsInput;
import filein.CredentialsInput;
import filein.FiltersInput;
import resources.Processing;
import resources.data.*;
import resources.visitor.Visitable;
import resources.visitor.Visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class MoviesPage extends Page {
    @Override
    public boolean acceptChange(String page) {
        ArrayList<String> acceptedPage = new ArrayList<>
                (Arrays.asList("homepage autentificat", "see details",  "logout", "movies"));
        return acceptedPage.contains(page);
    }

    @Override
    public void search(ActiveUser activeUser, String startsWith) {
        ObjectNode search = Processing.getObjectMapper().createObjectNode();
        ArrayList<Movie> movies = new ArrayList<>();
        for (Movie i : activeUser.getCurrentMovieList()) {
            if (i.getName().startsWith(startsWith)) {
                movies.add(i);
            }
        }
        search.putPOJO("error", null);
        search.putPOJO("currentMoviesList", movies);
        search.putPOJO("currentUser", activeUser.getUser());
        Processing.getOutput().add(search);
    }
    public void filter(ActiveUser activeUser, FiltersInput filtersInput) {
        ObjectNode filter = Processing.getObjectMapper().createObjectNode();
        ArrayList<Movie> movies = new ArrayList<>(activeUser.getCurrentMovieList());
//        for (Movie i : activeUser.getCurrentMovieList()) {
//            for(String actor : i.getActors()) {
//
//            }
//        }
        if(filtersInput.getSort().getRating().equals("decreasing")) {
            movies.sort((m1,m2)->m2.getRating()-m1.getRating());
        } else {
            movies.sort(Comparator.comparingInt(Movie::getRating));
        }
        if(filtersInput.getSort().getDuration().equals("decreasing")) {
            movies.sort((m1,m2)->m2.getDuration()-m1.getDuration());
        } else {
            movies.sort(Comparator.comparingInt(Movie::getDuration));
        }

        filter.putPOJO("error", null);
        filter.putPOJO("currentMoviesList", movies);
        filter.putPOJO("currentUser", activeUser.getUser());
        Processing.getOutput().add(filter);
    }
}
