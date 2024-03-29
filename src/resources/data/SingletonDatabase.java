package resources.data;

import resources.pages.*;

import java.util.ArrayList;
import java.util.Objects;

public final class SingletonDatabase {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    private static SingletonDatabase singletonDatabase = null;

    /**
     * return the singleton database and creates it if necessary
     * @return the database
     */
    public static SingletonDatabase getDatabase() {
        if (singletonDatabase == null) {
            singletonDatabase = new SingletonDatabase();
        }
        return singletonDatabase;
    }

    /**
     * deletes the database
     * (method called at the end of the program)
     */
    public void deleteDatabase() {
        singletonDatabase = null;
        users = new ArrayList<>();
        movies = new ArrayList<>();
    }

    /**
     * Adds a user to the database
     * @param user the user to add
     */
    public void addUser(final User user) {
        users.add(user);
    }

    /**
     * Adds a movie to the database
     * @param movie the movie to add
     */
    public void addMovie(final Movie movie) {
        movies.add(movie);
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    private final HomepageUnauthenticated homepageUnauthenticated = new HomepageUnauthenticated();
    private final LoginPage loginPage = new LoginPage();
    private final RegisterPage registerPage = new RegisterPage();
    private final HomepageAuthenticated homepageAuthenticated = new HomepageAuthenticated();
    private final MoviesPage moviesPage = new MoviesPage();
    private final DetailsPage detailsPage = new DetailsPage();
    private final UpgradesPage upgradesPage = new UpgradesPage();
    private final LogoutPage logoutPage = new LogoutPage();

    public HomepageUnauthenticated getHomepageUnauthenticated() {
        return homepageUnauthenticated;
    }
    public LoginPage getLoginPage() {
        return loginPage;
    }
    public RegisterPage getRegisterPage() {
        return registerPage;
    }
    public HomepageAuthenticated getHomepageAuthenticated() {
        return homepageAuthenticated;
    }
    public MoviesPage getMoviesPage() {
        return moviesPage;
    }
    public DetailsPage getDetailsPage() {
        return detailsPage;
    }
    public UpgradesPage getUpgradesPage() {
        return upgradesPage;
    }
    public LogoutPage getLogoutPage() {
        return logoutPage;
    }

    /**
     * Get the movies that the user is allowed to see
     * @param user the current user
     * @return an arraylist of the allowed movies
     */
    public ArrayList<Movie> getValidMovies(final User user) {
        ArrayList<Movie> validMovies = new ArrayList<>();
        if (user == null) {
            return validMovies;
        }
        validMovies.addAll(movies);
        validMovies.removeIf(
                i -> i.getCountriesBanned().contains(user.getCredentials().getCountry()));
        return validMovies;
    }

    public boolean containsMovie(String movieName) {
        for (Movie i : movies) {
            if (i.getName().equals(movieName)) {
                return true;
            }
        }
        return false;
    }

    public void removeMovie(String movieName) {
        movies.removeIf(movie -> Objects.equals(movie.getName(), movieName));
    }
}
