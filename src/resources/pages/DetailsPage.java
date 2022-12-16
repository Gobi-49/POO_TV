package resources.pages;

import com.fasterxml.jackson.databind.node.ObjectNode;
import fileout.MovieOut;
import fileout.UserOut;
import resources.Processing;
import resources.data.ActiveUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DetailsPage extends Page {
    @Override
    public boolean acceptChange(String page) {
        ArrayList<String> acceptedPage = new ArrayList<>
                (Arrays.asList("homepage autentificat", "movies", "upgrades", "logout", "see details"));
        return acceptedPage.contains(page);
    }

    @Override
    public void purchase(ActiveUser activeUser) {
        if (activeUser.getUser().getNumFreePremiumMovies() > 0) {
            activeUser.getUser().addMovieToPurchase(activeUser.getSelectedMovie());
            activeUser.getUser().setNumFreePremiumMovies(activeUser.getUser().getNumFreePremiumMovies() - 1);
            print(activeUser);
            return;
        }
        if(activeUser.getUser().getTokensCount() >= 2) {
            activeUser.getUser().addMovieToPurchase(activeUser.getSelectedMovie());
            activeUser.getUser().removeTokes(2);
            print(activeUser);
            return;
        }
        error();
    }
    @Override
    public void watch(ActiveUser activeUser) {
        if (activeUser.getUser().getPurchasedMovies().contains(activeUser.getSelectedMovie())) {
            activeUser.getUser().addMovieToWatched(activeUser.getSelectedMovie());
            print(activeUser);
            return;
        }
        error();
    }
    @Override
    public void like(ActiveUser activeUser) {
        if (activeUser.getUser().getWatchedMovies().contains(activeUser.getSelectedMovie())) {
            activeUser.getUser().addMovieToLiked(activeUser.getSelectedMovie());
            activeUser.getSelectedMovie().addLike();
            print(activeUser);
            return;
        }
        error();
    }
    @Override
    public void rate(ActiveUser activeUser, int rate) {
        if (activeUser.getUser().getWatchedMovies().contains(activeUser.getSelectedMovie())) {
            activeUser.getUser().addMovieToRated(activeUser.getSelectedMovie());
            activeUser.getSelectedMovie().addRating(rate);
            print(activeUser);
            return;
        }
        error();
    }
    public void print(ActiveUser activeUser) {
        ObjectNode seeDetails = Processing.getObjectMapper().createObjectNode();
        seeDetails.putPOJO("error", null);
        seeDetails.putPOJO("currentMoviesList", new ArrayList<>(List.of(new MovieOut(activeUser.getSelectedMovie()))));
        seeDetails.putPOJO("currentUser", new UserOut(activeUser.getUser()));
        Processing.getOutput().add(seeDetails);
    }
}
