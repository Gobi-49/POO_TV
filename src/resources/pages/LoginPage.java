package resources.pages;

import com.fasterxml.jackson.databind.node.ObjectNode;
import filein.CredentialsInput;
import fileout.MovieOut;
import fileout.UserOut;
import program.Processing;
import resources.data.ActiveUser;
import resources.data.Credentials;
import resources.data.SingletonDatabase;
import resources.data.User;

import java.util.ArrayList;
import java.util.Arrays;

public class LoginPage extends Page {
    @Override
    public final boolean acceptChange(final String page) {
        ArrayList<String> acceptedPage = new ArrayList<>(
                Arrays.asList("login", "register", "homepage neautentificat"));
        return acceptedPage.contains(page);
    }

    /**
     * method used to set the active user from the existing database if the user exists
     * @param credentialsInput the credentials from the input
     * @param user the current user
     */
    public final void login(final CredentialsInput credentialsInput, final ActiveUser user) {
        ObjectNode login = Processing.getObjectMapper().createObjectNode();
        Credentials credentials = new Credentials(credentialsInput);
        for (User i : SingletonDatabase.getDatabase().getUsers()) {
            if (i.getCredentials().equals(credentials)) {
                user.setUser(i);
                login.putPOJO("error", null);
                login.putPOJO("currentMoviesList",
                        MovieOut.convertMovieArray(user.getCurrentMovieList()));
                login.putPOJO("currentUser", new UserOut(user.getUser()));
                Processing.getOutput().add(login);
                user.setCurrentPage(SingletonDatabase.getDatabase().getHomepageAuthenticated());
                user.setCurrentMovieList(
                        SingletonDatabase.getDatabase().getValidMovies(user.getUser()));
                return;
            }
        }
        login.put("error", "Error");
        login.putPOJO("currentMoviesList", MovieOut.convertMovieArray(user.getCurrentMovieList()));
        login.putPOJO("currentUser", null);
        Processing.getOutput().add(login);
    }
}
