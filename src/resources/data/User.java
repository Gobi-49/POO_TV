package resources.data;

import filein.UsersInput;

import java.util.ArrayList;

public class User {
    private Credentials credentials;
    private int tokensCount;
    private int numFreePremiumMovies;
    private ArrayList<Movie> purchasedMovies;
    private ArrayList<Movie> watchedMovie;
    private ArrayList<Movie> lickedMovie;
    private ArrayList<Movie> ratedMovie;
    public User() {

    }
    public User(UsersInput usersInput) {
        credentials = new Credentials(usersInput.getCredentials());
        tokensCount = 0;
        numFreePremiumMovies = 0;
        purchasedMovies = new ArrayList<>();
        watchedMovie = new ArrayList<>();
        lickedMovie = new ArrayList<>();
        ratedMovie = new ArrayList<>();
    }

    public Credentials getCredentials() {
        return credentials;
    }
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
    public int getTokensCount() {
        return tokensCount;
    }
    public void setTokensCount(int tokensCount) {
        this.tokensCount = tokensCount;
    }
    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }
    public void setNumFreePremiumMovies(int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }
    public ArrayList<Movie> getPurchasedMovies() {
        return purchasedMovies;
    }
    public void setPurchasedMovies(ArrayList<Movie> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }
    public ArrayList<Movie> getWatchedMovie() {
        return watchedMovie;
    }
    public void setWatchedMovie(ArrayList<Movie> watchedMovie) {
        this.watchedMovie = watchedMovie;
    }
    public ArrayList<Movie> getLickedMovie() {
        return lickedMovie;
    }
    public void setLickedMovie(ArrayList<Movie> lickedMovie) {
        this.lickedMovie = lickedMovie;
    }
    public ArrayList<Movie> getRatedMovie() {
        return ratedMovie;
    }
    public void setRatedMovie(ArrayList<Movie> ratedMovie) {
        this.ratedMovie = ratedMovie;
    }
}
