package program;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import filein.ActionsInput;
import fileout.MovieOut;
import fileout.UserOut;
import program.changePage.Invoker;
import program.changePage.changePgCom;
import resources.data.*;

import resources.pages.Page;

import java.util.ArrayList;
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

    /**
     * changes the current page of the user
     * @param activeUser current user
     * @param actionsInput the actions input
     */
    public void changePage(final ActiveUser activeUser, final ActionsInput actionsInput) {
        if (!activeUser.getCurrentPage().acceptChange(actionsInput.getPage())) {
            Page.error();
            return;
        }
        if (activeUser.getCurrentPage() == SingletonDatabase.getDatabase().getDetailsPage()) {
            activeUser.setSelectedMovie(null);
        }
        switch (actionsInput.getPage()) {
            case "Homepage neautentificat" -> activeUser.getHistory().changePage(new changePgCom(
                    activeUser, SingletonDatabase.getDatabase().getHomepageUnauthenticated()));
            case "Homepage autentificat" -> activeUser.getHistory().changePage(new changePgCom(
                    activeUser, SingletonDatabase.getDatabase().getHomepageAuthenticated()));
            case "login" -> activeUser.getHistory().changePage(new changePgCom(
                    activeUser, SingletonDatabase.getDatabase().getLoginPage()));
            case "register" -> activeUser.getHistory().changePage(new changePgCom(
                    activeUser, SingletonDatabase.getDatabase().getRegisterPage()));
            case "movies" -> {
                activeUser.getHistory().changePage(new changePgCom(
                        activeUser, SingletonDatabase.getDatabase().getMoviesPage()));
            }
            case "see details" -> {
                String movieName = actionsInput.getMovie();
                for (Movie i : activeUser.getCurrentMovieList()) {
                    if (i.getName().equals(movieName)) {
                        activeUser.setSelectedMovie(i);
                        break;
                    }
                }
                if (activeUser.getSelectedMovie() != null) {
                    activeUser.getHistory().changePage(new changePgCom(
                            activeUser, SingletonDatabase.getDatabase().getDetailsPage()));
                } else {
                    Page.error();
                }
            }
            case "upgrades" -> activeUser.getHistory().changePage(new changePgCom(
                    activeUser, SingletonDatabase.getDatabase().getUpgradesPage()));
            case "logout" -> {
                activeUser.setCurrentPage(SingletonDatabase.getDatabase().getLogoutPage());
                activeUser.setUser(null);
                activeUser.setCurrentMovieList(new ArrayList<>());
            }
        }
    }

    /**
     * call the action method of the current page
     * @param activeUser current user
     * @param actionsInput the actions from the input
     */
    public void onPage(final ActiveUser activeUser, final ActionsInput actionsInput) {
        switch (actionsInput.getFeature()) {
            case "login" -> activeUser.getCurrentPage().login(
                    actionsInput.getCredentials(), activeUser);
            case "register" -> activeUser.getCurrentPage().register(
                    actionsInput.getCredentials(), activeUser);
            case "search" -> activeUser.getCurrentPage().search(
                    activeUser, actionsInput.getStartsWith());
            case "filter" -> activeUser.getCurrentPage().filter(
                    activeUser, actionsInput.getFilters());
            case "buy premium account" -> activeUser.getCurrentPage().buyPremium(activeUser);
            case "buy tokens" -> activeUser.getCurrentPage().buyTokens(
                    activeUser, Integer.parseInt(actionsInput.getCount()));
            case "purchase" -> activeUser.getCurrentPage().purchase(activeUser);
            case "watch" -> activeUser.getCurrentPage().watch(activeUser);
            case "like" -> activeUser.getCurrentPage().like(activeUser);
            case "rate" -> activeUser.getCurrentPage().rate(activeUser, actionsInput.getRate());
            case "subscribe" -> {
                if (activeUser.getCurrentPage() == SingletonDatabase.getDatabase().getDetailsPage()) {
                    if (activeUser.getSelectedMovie().getGenres().contains(actionsInput.getSubscribedGenre())
                            && !activeUser.getUser().getSubscribed().contains(actionsInput.getSubscribedGenre())) {
                        activeUser.getUser().getSubscribed().add(actionsInput.getSubscribedGenre());
                    } else {
                        Page.error();
                    }
                } else {
                    Page.error();
                }
            }
        }
    }

    public void backPage(final ActiveUser activeUser) {
        activeUser.getHistory().undo();
    }

    public void database(final ActionsInput actionsInput) {
        switch (actionsInput.getFeature()) {
            case "add" -> {
                Movie movie = new Movie(actionsInput.getAddedMovie());
                if(!SingletonDatabase.getDatabase().containsMovie(movie.getName())) {
                    SingletonDatabase.getDatabase().addMovie(movie);
                    for (User i : SingletonDatabase.getDatabase().getUsers()) {
                        for (String j : i.getSubscribed()) {
                            if(movie.getGenres().contains(j)) {
                                i.addNotification(new Notification(movie.getName(), "ADD"));
                                break;
                            }
                        }
                    }
                } else {
                    Page.error();
                }
            }
            case "delete" -> {
                String deletedMovie = actionsInput.getDeletedMovie();
                if (SingletonDatabase.getDatabase().containsMovie(deletedMovie)) {
                    SingletonDatabase.getDatabase().removeMovie(deletedMovie);
                    for (User i : SingletonDatabase.getDatabase().getUsers()) {
                        for (Movie j : i.getPurchasedMovies()) {
                            if (i.hasMovie(j.getName())) {
                                i.addNotification(new Notification(
                                        deletedMovie, "DELETE"));
                                if(i.getCredentials().getAccountType().equals("premium")) {
                                    i.setNumFreePremiumMovies(i.getNumFreePremiumMovies() + 1);
                                } else {
                                    i.addTokes(2);
                                }
                            }
                        }
                    }
                } else {
                    Page.error();
                }
            }
        }
    }
}
