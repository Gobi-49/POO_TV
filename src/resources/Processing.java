package resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import filein.ActionsInput;
import fileout.UserOut;
import resources.data.ActiveUser;
import resources.data.Database;

public final class Processing {
    private ObjectMapper objectMapper;
    private ArrayNode output;
    public Processing(final ObjectMapper objectMapper, final ArrayNode output) {
        this.objectMapper = objectMapper;
        this.output = output;
    }
    public void changePage(ActiveUser activeUser, ActionsInput actionsInput) {
        if (!activeUser.getCurrentPage().acceptChange(actionsInput.getPage())) {
            ObjectNode changeCard = objectMapper.createObjectNode();
            changeCard.put("error", "Error");
            changeCard.putPOJO("currentMoviesList", Database.getDatabase().getValidMovies(activeUser.getUser()));
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
            case "movies" -> activeUser.setCurrentPage(Database.getDatabase().getMoviesPage());
            case "see details" -> activeUser.setCurrentPage(Database.getDatabase().getDetailsPage());
            case "upgrades" -> activeUser.setCurrentPage(Database.getDatabase().getUpgradesPage());
            case "logout" -> activeUser.setCurrentPage(Database.getDatabase().getLogoutPage());
        }
    }
//    public static void onPage(CurrentUser activeUser, String)
}
