package resources.data;

import filein.UsersInput;

import java.util.ArrayList;

public class User {
    private Credentials credentials;
    private int tokensCount;
    private int numFreePremiumMovies;
    private ArrayList<Movie> purchasedMovies;
    private ArrayList<Movie> watchedMovies;
    private ArrayList<Movie> likedMovies;
    private ArrayList<Movie> ratedMoviess;
    public User() {

    }
    public User(Credentials credentials) {
        this.credentials = credentials;
        tokensCount = 0;
        numFreePremiumMovies = 15;
        purchasedMovies = new ArrayList<>();
        watchedMovies = new ArrayList<>();
        likedMovies = new ArrayList<>();
        ratedMoviess = new ArrayList<>();
    }
    public User(UsersInput usersInput) {
        credentials = new Credentials(usersInput.getCredentials());
        tokensCount = 0;
        numFreePremiumMovies = 15;
        purchasedMovies = new ArrayList<>();
        watchedMovies = new ArrayList<>();
        likedMovies = new ArrayList<>();
        ratedMoviess = new ArrayList<>();
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
    public ArrayList<Movie> getwatchedMovies() {
        return watchedMovies;
    }
    public void setwatchedMovies(ArrayList<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }
    public ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }
    public void setLikedMovies(ArrayList<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }
    public ArrayList<Movie> getratedMovies() {
        return ratedMoviess;
    }
    public void setratedMovies(ArrayList<Movie> ratedMoviess) {
        this.ratedMoviess = ratedMoviess;
    }
    public void addTokes(int tokens) {
        tokensCount += tokens;
    }
    public void removeTokes(int tokens) {
        tokensCount -= tokens;
    }
}
