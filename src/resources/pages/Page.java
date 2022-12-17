package resources.pages;

import com.fasterxml.jackson.databind.node.ObjectNode;
import filein.CredentialsInput;
import filein.FiltersInput;
import program.Processing;
import resources.data.ActiveUser;

import java.util.ArrayList;

public abstract class Page {
    /**
     * method used the check if we can change page
     * overridden in each page
     * @param page the credentials from the input
     */
    public boolean acceptChange(final String page) {
        return false;
    }

    /**
     * method used to set the active user from the existing database if the user exists
     * prints error if the current page is not LoginPage
     * @param credentials the credentials from the input
     * @param activeUser the current user
     */
    public void login(final CredentialsInput credentials, final ActiveUser activeUser) {
        error();
    }

    /**
     * The method used to register new users
     * prints error if the current page is not RegisterPage
     * @param credentials the credentials from the input
     * @param activeUser the active user that is registering
     */
    public void register(final CredentialsInput credentials, final ActiveUser activeUser) {
        error();
    }

    /**
     * method used for the action "search"
     * overridden in the MoviesPage
     * prints error if the current page is not MoviePage
     * @param activeUser the current user
     */
    public void search(final ActiveUser activeUser, final String startsWith) {
        error();
    }

    /**
     * method used for the action "filter"
     * overridden in the MoviesPage
     * prints error if the current page is not MoviePage
     * @param activeUser the current user
     * @param filtersInput filtering condition
     */
    public void filter(final ActiveUser activeUser, final FiltersInput filtersInput) {
        error();
    }
    /**
     * method used for the action "buy tokens"
     * overridden in the UpgradePage
     * prints error if the current page is not UpgradePage
     * @param activeUser the current user
     * @param count number of tokens to be bought
     */
    public void buyTokens(final ActiveUser activeUser, final int count) {
        error();
    }

    /**
     * method used for the action "buy premium"
     * overridden in the UpgradePage
     * prints error if the current page is not MoviePage
     * @param activeUser the current user
     */
    public void buyPremium(final ActiveUser activeUser) {
        error();
    }
    /**
     * method used for the action "purchase movie"
     * overridden in the DetailsPage
     * prints error if the current page is not DetailsPage
     * @param activeUser the current user
     */
    public void purchase(final ActiveUser activeUser) {
        error();
    }

    /**
     * method used for the action "watch movie"
     * overridden in the DetailsPage
     * prints error if the current page is not DetailsPage
     * @param activeUser the current user
     */
    public void watch(final ActiveUser activeUser) {
        error();
    }

    /**
     * method used for the action "like movie"
     * overridden in the DetailsPage
     * prints error if the current page is not DetailsPage
     * @param activeUser the current user
     */
    public void like(final ActiveUser activeUser) {
        error();
    }

    /**
     * method used for the action "rate movie"
     * It is overridden in the DetailsPage
     * prints error if the current page is not DetailsPage
     * @param activeUser the current user
     * @param rating the rating of the movie
     */
    public void rate(final ActiveUser activeUser, final int rating) {
        error();
    }

    /**
     * a method used to print the error output
     */
    public static void error() {
        ObjectNode error = Processing.getObjectMapper().createObjectNode();
        error.put("error", "Error");
        error.putPOJO("currentMoviesList", new ArrayList<>());
        error.putPOJO("currentUser", null);
        Processing.getOutput().add(error);
    }

    /**
     * method used to be overridden for printing the output
     * @param activeUser the current user
     */
    public void print(final ActiveUser activeUser) {
    }
}
