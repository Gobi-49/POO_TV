package resources.pages;

import com.fasterxml.jackson.databind.node.ObjectNode;
import filein.CredentialsInput;
import fileout.MovieOut;
import fileout.UserOut;
import resources.Processing;
import resources.data.ActiveUser;
import resources.data.Credentials;
import resources.data.Database;
import resources.data.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class LoginPage extends Page {
    @Override
    public boolean acceptChange(String page) {
        ArrayList<String> acceptedPage = new ArrayList<>
                (Arrays.asList("login", "register", "homepage neautentificat"));
        return acceptedPage.contains(page);
    }
    public void login(CredentialsInput credentialsInput, ActiveUser user) {
        ObjectNode login = Processing.getObjectMapper().createObjectNode();
        Credentials credentials = new Credentials(credentialsInput);
        for (User i : Database.getDatabase().getUsers()) {
            if (i.getCredentials().equals(credentials)) {
                user.setUser(i);
                login.putPOJO("error", null);
                login.putPOJO("currentMoviesList", MovieOut.convertMovieArray(user.getCurrentMovieList()));
                login.putPOJO("currentUser", new UserOut(user.getUser()));
                Processing.getOutput().add(login);
                user.setCurrentPage(Database.getDatabase().getHomepageAuthenticated());
                user.setCurrentMovieList(Database.getDatabase().getValidMovies(user.getUser()));
                return;
            }
        }
        login.put("error", "Error");
        login.putPOJO("currentMoviesList", MovieOut.convertMovieArray(user.getCurrentMovieList()));
        login.putPOJO("currentUser", null);
        Processing.getOutput().add(login);
    }
}
