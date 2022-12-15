package resources.pages;

import com.fasterxml.jackson.databind.node.ObjectNode;
import filein.CredentialsInput;
import resources.Processing;
import resources.data.ActiveUser;
import resources.data.Credentials;
import resources.data.Database;
import resources.data.User;
import resources.visitor.Visitable;
import resources.visitor.Visitor;

import java.util.ArrayList;
import java.util.Arrays;

public class RegisterPage extends Page {
    @Override
    public boolean acceptChange(String page) {
        ArrayList<String> acceptedPage = new ArrayList<>
                (Arrays.asList("register", "login", "homepage neautentificat"));
        return acceptedPage.contains(page);
    }

    public void register(CredentialsInput credentialsInput, ActiveUser user) {
        ObjectNode register = Processing.getObjectMapper().createObjectNode();
        Credentials credentials = new Credentials(credentialsInput);
        for (User i : Database.getDatabase().getUsers()) {
            if (i.getCredentials().equals(credentials)) {
                user.setUser(i);
                register.putPOJO("error", "Error");
                register.putPOJO("currentMoviesList", user.getCurrentMovieList());
                register.putPOJO("currentUser", null);
                Processing.getOutput().add(register);
                user.setCurrentPage(Database.getDatabase().getHomepageUnauthenticated());
                return;
            }
        }
        User newUser = new User(credentials);
        Database.getDatabase().addUser(newUser);
        register.putPOJO("error", null);
        register.putPOJO("currentMoviesList", user.getCurrentMovieList());
        register.putPOJO("currentUser", newUser);
        user.setCurrentPage(Database.getDatabase().getHomepageAuthenticated());
        user.setUser(newUser);
        user.setCurrentMovieList(Database.getDatabase().getValidMovies(user.getUser()));
        Processing.getOutput().add(register);
    }
}
