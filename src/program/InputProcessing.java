package program;

import com.fasterxml.jackson.databind.node.ObjectNode;
import filein.ActionsInput;
import filein.Input;
import fileout.UserOut;
import resources.data.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

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
                case "back" -> processing.backPage(user);
                case "database" -> processing.database(actionsInput);
            }
        }
        if (user.getUser() != null) {
            if(user.getUser().getCredentials().getAccountType().equals("premium")) {
                if (user.getUser().getLikedMovies().size() == 0) {
                    user.getUser().addNotification(new Notification(
                            "No recommendation", "Recommendation"));
                    ObjectNode error = Processing.getObjectMapper().createObjectNode();
                    error.putPOJO("error", null);
                    error.putPOJO("currentMoviesList", null);
                    error.putPOJO("currentUser", new UserOut(user.getUser()));
                    Processing.getOutput().add(error);
                    return;
                }
                HashMap<String, Integer> topLiked = new HashMap<>();
                user.getUser().getSubscribed().forEach((genre) -> topLiked.put(genre, 0));
                for(Movie i : user.getUser().getLikedMovies()) {
                    for (String j : user.getUser().getSubscribed())
                        if (i.getGenres().contains(j)) {
                            topLiked.replace(j, topLiked.get(j) + 1);
                        }
                }
                String selectedGenre;
                int max = 0;
                for(String i : topLiked.keySet()) {
                    if(max < topLiked.get(i)) {
                        selectedGenre = i;
                        max = topLiked.get(i);
                    }
                }
                ArrayList<Movie> mostLiked = new ArrayList<>(SingletonDatabase.getDatabase().getValidMovies(user.getUser()));
                mostLiked.sort(new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        if(o1.getNumLikes() != o2.getNumLikes()) {
                            return o1.getNumLikes() - o2.getNumLikes();
                        } else {
                            return o2.getName().compareTo(o1.getName());
                        }
                    }
                });
                int i = mostLiked.size() - 1;
                while (user.getUser().hasMovie(mostLiked.get(i).getName())) {
                    i--;
                }
                user.getUser().addNotification(new Notification(
                        mostLiked.get(i).getName(), "Recommendation"));

                ObjectNode notification = Processing.getObjectMapper().createObjectNode();
                notification.putPOJO("error", null);
                notification.putPOJO("currentMoviesList", null);
                notification.putPOJO("currentUser", new UserOut(user.getUser()));
                Processing.getOutput().add(notification);
            }
        }
    }
}
