package resources.data;

import resources.pages.*;

import java.util.ArrayList;

public class Database {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    private static Database database = null;
    
    public static Database getDatabase() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    public void deleteDatabase() {
        database = null;
        users = new ArrayList<>();
        movies = new ArrayList<>();
    }
    
    public void addUser(User user) {
        users.add(user);
    }
    public void addMovie(Movie movie) {
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

    public ArrayList<Movie> getValidMovies(User user) {
        ArrayList <Movie> validMovies = new ArrayList<>();
        if(user == null) {
            return validMovies;
        }
        validMovies.addAll(movies);
        validMovies.removeIf(i -> i.getCountriesBanned().contains(user.getCredentials().getCountry()));
        return validMovies;
    }
}
