package resources.pages;

import com.fasterxml.jackson.databind.node.ObjectNode;
import filein.ActionsInput;
import filein.CredentialsInput;
import filein.FiltersInput;
import fileout.UserOut;
import resources.Processing;
import resources.data.ActiveUser;

import java.util.ArrayList;

public abstract class Page {
    public boolean acceptChange(String page) {
        return false;
    }

    public void login(CredentialsInput credentials, ActiveUser activeUser) {
        error();
    }
    public void register(CredentialsInput credentials, ActiveUser activeUser) {
        error();
    }
    public void logout(CredentialsInput credentialsInput, ActiveUser activeUser){
        error();
    }
    public void search(ActiveUser activeUser, String startsWith){
        error();
    }
    public void filter(ActiveUser activeUser, FiltersInput filtersInput) {
        error();
    }
    public void buyTokens(ActiveUser activeUser, int count) {
        error();
    }
    public void buyPremium(ActiveUser activeUser) {
        error();
    }
    public void purchase(ActiveUser activeUser) {
        error();
    }
    public void watch(ActiveUser activeUser) {
        error();
    }
    public void like(ActiveUser activeUser) {
        error();
    }
    public void rate(ActiveUser activeUser, int rate) {
        error();
    }
    public static void error() {
        ObjectNode error = Processing.getObjectMapper().createObjectNode();
        error.put("error", "Error");
        error.putPOJO("currentMoviesList", new ArrayList<>());
        error.putPOJO("currentUser", null);
        Processing.getOutput().add(error);
    }
    public void print(ActiveUser activeUser) {
    }
}
