package resources.pages;

import com.fasterxml.jackson.databind.node.ObjectNode;
import fileout.MovieOut;
import fileout.UserOut;
import resources.MagicNumbers;
import program.Processing;
import resources.data.ActiveUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailsPage extends Page {
    @Override
    public final boolean acceptChange(final String page) {
        ArrayList<String> acceptedPage = new ArrayList<>(
                Arrays.asList("homepage autentificat", "movies", "upgrades", "logout",
                        "see details"));
        return acceptedPage.contains(page);
    }

    @Override
    public final void purchase(final ActiveUser activeUser) {
        if (activeUser.getSelectedMovie() == null ||
                activeUser.getUser().getPurchasedMovies().contains(activeUser.getSelectedMovie())) {
            error();
            return;
        }
        if (activeUser.getUser().getNumFreePremiumMovies() > 0
                && activeUser.getUser().getCredentials().getAccountType().equals("premium")) {
            activeUser.getUser().addMovieToPurchase(activeUser.getSelectedMovie());
            activeUser.getUser().setNumFreePremiumMovies(
                    activeUser.getUser().getNumFreePremiumMovies() - 1);
            print(activeUser);
            return;
        }
        if (activeUser.getUser().getTokensCount() >= 2) {
            activeUser.getUser().addMovieToPurchase(activeUser.getSelectedMovie());
            activeUser.getUser().removeTokes(2);
            print(activeUser);
            return;
        }
        error();
    }
    @Override
    public final void watch(final ActiveUser activeUser) {
        if (activeUser.getUser().getPurchasedMovies().contains(activeUser.getSelectedMovie())) {
            if (activeUser.getUser().getWatchedMovies().contains(
                    activeUser.getSelectedMovie())) {
                print(activeUser);
                return;
            }
            activeUser.getUser().addMovieToWatched(activeUser.getSelectedMovie());
            print(activeUser);
            return;
        }
        error();
    }
    @Override
    public final void like(final ActiveUser activeUser) {
        if (activeUser.getUser().getWatchedMovies().contains(activeUser.getSelectedMovie())) {
            if (activeUser.getUser().getLikedMovies().contains(
                    activeUser.getSelectedMovie())) {
                print(activeUser);
                return;
            }
            activeUser.getUser().addMovieToLiked(activeUser.getSelectedMovie());
            activeUser.getSelectedMovie().addLike();
            print(activeUser);
            return;
        }
        error();
    }
    @Override
    public final void rate(final ActiveUser activeUser, final int rate) {
        if (rate > MagicNumbers.MAXRATING || rate < MagicNumbers.MINRATING) {
            error();
            return;
        }
        if (activeUser.getUser().getWatchedMovies().contains(activeUser.getSelectedMovie())) {
            if (!activeUser.getUser().getRatedMovies().contains(
                    activeUser.getSelectedMovie())) {
                activeUser.getUser().addMovieToRated(activeUser.getSelectedMovie());
            }
            activeUser.getSelectedMovie().addRating(rate, activeUser.getUser());
            print(activeUser);
            return;
        }
        error();
    }

    /**
     * prints the output of the action
     * @param activeUser the current user
     */
    public final void print(final ActiveUser activeUser) {
        ObjectNode seeDetails = Processing.getObjectMapper().createObjectNode();
        seeDetails.putPOJO("error", null);
        seeDetails.putPOJO("currentMoviesList",
                new ArrayList<>(List.of(new MovieOut(activeUser.getSelectedMovie()))));
        seeDetails.putPOJO("currentUser", new UserOut(activeUser.getUser()));
        Processing.getOutput().add(seeDetails);
    }

    @Override
    public void defaultAction(ActiveUser activeUser) {
        if (activeUser.getSelectedMovie() != null) {
            ObjectNode changeCard = Processing.getObjectMapper().createObjectNode();
            changeCard.putPOJO("error", null);
            changeCard.putPOJO("currentMoviesList",
                    new ArrayList<>(List.of(new MovieOut(activeUser.getSelectedMovie()))));
            changeCard.putPOJO("currentUser", new UserOut(activeUser.getUser()));
            Processing.getOutput().add(changeCard);
        }
    }
}
