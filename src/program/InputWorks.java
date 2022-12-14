package program;

import filein.ActionsInput;
import filein.Input;
import resources.Actions;
import resources.data.CurrentUser;
import resources.data.Database;
import resources.data.Movie;
import resources.data.User;

import java.util.ArrayList;

public final class InputWorks {
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
    public static void actions(Input input, CurrentUser user) {
        for(int i = 0; i < input.getActions().size(); i++) {
            ActionsInput actionsInput = input.getActions().get(i);
            if(actionsInput.getType().equals("change page")) {
                Actions.changePage(user, actionsInput.getPage());
            }
        }
    }
}
