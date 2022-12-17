package program;

import filein.ActionsInput;
import filein.Input;
import resources.data.ActiveUser;
import resources.data.SingletonDatabase;
import resources.data.Movie;
import resources.data.User;

public final class InputProcessing {
    /**
     * Adds users from the input to the database
     * @param input the input class
     */
    public static void addUsersToDatabase(final Input input) {
        for (int i = 0; i < input.getUsers().size(); i++) {
            SingletonDatabase.getDatabase().addUser(new User(input.getUsers().get(i)));
        }
    }

    /**
     * Adds the movies from the input to the database
     * @param input the input class
     */
    public static void addMoviesToDatabase(final Input input) {
        for (int i = 0; i < input.getMovies().size(); i++) {
            SingletonDatabase.getDatabase().addMovie(new Movie(input.getMovies().get(i)));
        }
    }

    /**
     * Reads from input the actions that will be executed and determines if
     * the action is "on page" or "change page"
     * @param input input class
     * @param user the current user
     * @param processing the class that processes the information
     */
    public static void actions(final Input input, final ActiveUser user,
                               final Processing processing) {
        for (int i = 0; i < input.getActions().size(); i++) {
            ActionsInput actionsInput = input.getActions().get(i);
            switch (actionsInput.getType()) {
                case "change page" -> processing.changePage(user, actionsInput);
                case "on page" -> processing.onPage(user, actionsInput);
            }
        }
    }
}
