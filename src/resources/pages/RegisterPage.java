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

public class RegisterPage extends Page {
    @Override
    public final boolean acceptChange(final String page) {
        ArrayList<String> acceptedPage = new ArrayList<>(
                Arrays.asList("register", "login", "homepage neautentificat"));
        return acceptedPage.contains(page);
    }

    /**
     * The method used to register new users
     * @param credentialsInput the credentials from the input
     * @param user the active user that is registering
     */
    public final void register(final CredentialsInput credentialsInput, final ActiveUser user) {
        ObjectNode register = Processing.getObjectMapper().createObjectNode();
        Credentials credentials = new Credentials(credentialsInput);
        for (User i : SingletonDatabase.getDatabase().getUsers()) {
            if (i.getCredentials().equals(credentials)) {
                user.setUser(i);
                register.putPOJO("error", "Error");
                register.putPOJO("currentMoviesList",
                        MovieOut.convertMovieArray(user.getCurrentMovieList()));
                register.putPOJO("currentUser", null);
                Processing.getOutput().add(register);
                user.setCurrentPage(SingletonDatabase.getDatabase().getHomepageUnauthenticated());
                return;
            }
        }
        User newUser = new User(credentials);
        SingletonDatabase.getDatabase().addUser(newUser);
        register.putPOJO("error", null);
        register.putPOJO("currentMoviesList",
                MovieOut.convertMovieArray(user.getCurrentMovieList()));
        register.putPOJO("currentUser", new UserOut(newUser));
        user.setCurrentPage(SingletonDatabase.getDatabase().getHomepageAuthenticated());
        user.setUser(newUser);
        user.setCurrentMovieList(SingletonDatabase.getDatabase().getValidMovies(user.getUser()));
        Processing.getOutput().add(register);
    }
}
