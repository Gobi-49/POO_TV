package program;

import filein.ActionsInput;
import filein.Input;
import resources.Processing;
import resources.data.ActiveUser;
import resources.data.Database;
import resources.data.Movie;
import resources.data.User;

public final class InputProcessing {
    public static void addUsersToDatabase(Input input) {
        for(int i = 0; i < input.getUsers().size(); i++) {
            Database.getDatabase().addUser(new User(input.getUsers().get(i)));
        }
    }
    public static void addMoviesToDatabase(Input input) {
        for(int i = 0; i < input.getMovies().size(); i++) {
            Database.getDatabase().addMovie(new Movie(input.getMovies().get(i)));
        }
    }
    public static void actions(Input input, ActiveUser user, Processing processing) {
        for(int i = 0; i < input.getActions().size(); i++) {
            ActionsInput actionsInput = input.getActions().get(i);
            switch(actionsInput.getType()){
                case "change page":
                    processing.changePage(user, actionsInput);
                    break;
                case "on page":
                    break;
            }
//            if(.equals("change page")) {
//            }
        }
    }
}
