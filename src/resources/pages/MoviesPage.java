package resources.pages;

import com.fasterxml.jackson.databind.node.ObjectNode;
import filein.FiltersInput;
import fileout.MovieOut;
import fileout.UserOut;
import program.Processing;
import resources.data.ActiveUser;
import resources.data.Movie;
import resources.data.SingletonDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MoviesPage extends Page {
    @Override
    public final boolean acceptChange(final String page) {
        ArrayList<String> acceptedPage = new ArrayList<>(
                Arrays.asList("homepage autentificat", "see details",  "logout", "movies"));
        return acceptedPage.contains(page);
    }

    @Override
    public final void search(final ActiveUser activeUser, final String startsWith) {
        ObjectNode search = Processing.getObjectMapper().createObjectNode();
        ArrayList<Movie> movies = new ArrayList<>();
        for (Movie i : activeUser.getCurrentMovieList()) {
            if (i.getName().startsWith(startsWith)) {
                movies.add(i);
            }
        }
        search.putPOJO("error", null);
        search.putPOJO("currentMoviesList", MovieOut.convertMovieArray(movies));
        search.putPOJO("currentUser", new UserOut(activeUser.getUser()));
        Processing.getOutput().add(search);
    }

    /**
     * filters the current movie list with
     * @param activeUser the current user
     * @param filtersInput the filtering conditions
     */
    public final void filter(final ActiveUser activeUser, final FiltersInput filtersInput) {
        ArrayList<Movie> movies = new ArrayList<>(
                SingletonDatabase.getDatabase().getValidMovies(activeUser.getUser()));
        if (filtersInput.getContains() != null) {
            if (filtersInput.getContains().getActors() != null) {
                for (String i : filtersInput.getContains().getActors()) {
                    movies.removeIf(movie -> !movie.getActors().contains(i));
                }
            }
            if (filtersInput.getContains().getGenre() != null) {
                for (String i : filtersInput.getContains().getGenre()) {
                    movies.removeIf(movie -> !movie.getGenres().contains(i));
                }
            }
        }
        if (filtersInput.getSort() != null) {
            if (filtersInput.getSort().getRating() != null) {
                if (filtersInput.getSort().getRating().equals("decreasing")) {
                    movies.sort((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()));
                } else {
                    movies.sort(Comparator.comparingDouble(Movie::getRating));
                }
            }
            if (filtersInput.getSort().getDuration() != null) {
                if (filtersInput.getSort().getDuration().equals("decreasing")) {
                    movies.sort((m1, m2) -> m2.getDuration() - m1.getDuration());
                } else {
                    movies.sort(Comparator.comparingInt(Movie::getDuration));
                }
            }
        }
        ObjectNode filter = Processing.getObjectMapper().createObjectNode();
        filter.putPOJO("error", null);
        filter.putPOJO("currentMoviesList", MovieOut.convertMovieArray(movies));
        filter.putPOJO("currentUser", new UserOut(activeUser.getUser()));
        activeUser.setCurrentMovieList(movies);
        Processing.getOutput().add(filter);
    }
}
