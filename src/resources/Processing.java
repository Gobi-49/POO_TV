package resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import filein.ActionsInput;
import filein.CredentialsInput;
import fileout.UserOut;
import resources.data.ActiveUser;
import resources.data.Credentials;
import resources.data.Database;
import resources.data.User;

import java.util.ArrayList;

public final class Processing {
    private static ObjectMapper objectMapper;
    private static ArrayNode output;
    public Processing(final ObjectMapper objectMapper, final ArrayNode output) {
        Processing.objectMapper = objectMapper;
        Processing.output = output;
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
    public static ArrayNode getOutput() {
        return output;
    }

    public void changePage(ActiveUser activeUser, ActionsInput actionsInput) {
        if (!activeUser.getCurrentPage().acceptChange(actionsInput.getPage())) {
            ObjectNode changeCard = objectMapper.createObjectNode();
            changeCard.put("error", "Error");
            changeCard.putPOJO("currentMoviesList", activeUser.getCurrentMovieList());
            if(activeUser.getUser() == null) {
                changeCard.putPOJO("currentUser", null);
            } else {
                changeCard.putPOJO("currentUser", new UserOut(activeUser.getUser()));
            }
            output.add(changeCard);
            return;
        }
        switch (actionsInput.getPage()) {
            case "Homepage neautentificat" -> activeUser.setCurrentPage(Database.getDatabase().getHomepageUnauthenticated());
            case "Homepage autentificat" -> activeUser.setCurrentPage(Database.getDatabase().getHomepageAuthenticated());
            case "login" -> activeUser.setCurrentPage(Database.getDatabase().getLoginPage());
            case "register" -> activeUser.setCurrentPage(Database.getDatabase().getRegisterPage());
            case "movies" -> {
                activeUser.setCurrentPage(Database.getDatabase().getMoviesPage());
                ObjectNode changeCard = objectMapper.createObjectNode();
                changeCard.putPOJO("error", null);
                changeCard.putPOJO("currentMoviesList", activeUser.getCurrentMovieList());
                changeCard.putPOJO("currentUser", new UserOut(activeUser.getUser()));
                output.add(changeCard);
            }
            case "see details" -> activeUser.setCurrentPage(Database.getDatabase().getDetailsPage());
            case "upgrades" -> activeUser.setCurrentPage(Database.getDatabase().getUpgradesPage());
            case "logout" -> {
                activeUser.setCurrentPage(Database.getDatabase().getLogoutPage());
                activeUser.setUser(null);
                activeUser.setCurrentMovieList(new ArrayList<>());
            }
        }
    }
    public void onPage(ActiveUser activeUser, ActionsInput actionsInput) {
        switch (actionsInput.getFeature()) {
            case "login" -> activeUser.getCurrentPage().login(actionsInput.getCredentials(), activeUser);
            case "register" -> activeUser.getCurrentPage().register(actionsInput.getCredentials(), activeUser);
            case "search" -> activeUser.getCurrentPage().search(activeUser, actionsInput.getStartsWith());
            case "filter" -> activeUser.getCurrentPage().filter(activeUser,actionsInput.getFilters());
            case "buy tokens" ->
        }
    }
}
