package resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import filein.ActionsInput;
import filein.CredentialsInput;
import fileout.MovieOut;
import fileout.UserOut;
import resources.data.*;
import resources.pages.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
            Page.error();
            return;
        }
        if (activeUser.getCurrentPage() == Database.getDatabase().getDetailsPage()) {
            activeUser.setSelectedMovie(null);
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
                changeCard.putPOJO("currentMoviesList", MovieOut.convertMovieArray(activeUser.getCurrentMovieList()));
                changeCard.putPOJO("currentUser", new UserOut(activeUser.getUser()));
                output.add(changeCard);
            }
            case "see details" -> {
                String movieName = actionsInput.getMovie();
                for(Movie i : activeUser.getCurrentMovieList()) {
                    if(i.getName().equals(movieName)) {
                        activeUser.setSelectedMovie(i);
                        break;
                    }
                }
                if (activeUser.getSelectedMovie() != null) {
                    activeUser.setCurrentPage(Database.getDatabase().getDetailsPage());
                    ObjectNode changeCard = objectMapper.createObjectNode();
                    changeCard.putPOJO("error", null);
                    changeCard.putPOJO("currentMoviesList", new ArrayList<>(List.of(new MovieOut(activeUser.getSelectedMovie()))));
                    changeCard.putPOJO("currentUser", new UserOut(activeUser.getUser()));
                    output.add(changeCard);
                } else {
                    Page.error();
                }
            }
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
            case "buy premium account" -> activeUser.getCurrentPage().buyPremium(activeUser);
            case "buy tokens" -> activeUser.getCurrentPage().buyTokens(activeUser, Integer.parseInt(actionsInput.getCount()));
            case "purchase" -> activeUser.getCurrentPage().purchase(activeUser);
            case "watch" -> activeUser.getCurrentPage().watch(activeUser);
            case "like" -> activeUser.getCurrentPage().like(activeUser);
            case "rate" -> activeUser.getCurrentPage().rate(activeUser, actionsInput.getRate());
        }
    }
}
