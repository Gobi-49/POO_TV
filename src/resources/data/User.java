package resources.data;

import filein.UsersInput;
import resources.MagicNumbers;

import java.util.ArrayList;

public class User {
    private Credentials credentials;
    private int tokensCount;
    private int numFreePremiumMovies;
    private ArrayList<Movie> purchasedMovies;
    private ArrayList<Movie> watchedMovies;
    private ArrayList<Movie> likedMovies;
    private ArrayList<Movie> ratedMovies;
    private ArrayList<String> notifications;
    private ArrayList<String> subscribed;
    public User() {

    }
    public User(final Credentials credentials) {
        this.credentials = credentials;
        tokensCount = 0;
        numFreePremiumMovies = MagicNumbers.NRTOKENS;
        purchasedMovies = new ArrayList<>();
        watchedMovies = new ArrayList<>();
        likedMovies = new ArrayList<>();
        ratedMovies = new ArrayList<>();
        notifications = new ArrayList<>();
        subscribed = new ArrayList<>();
    }
    public User(final UsersInput usersInput) {
        credentials = new Credentials(usersInput.getCredentials());
        tokensCount = 0;
        numFreePremiumMovies = MagicNumbers.NRTOKENS;
        purchasedMovies = new ArrayList<>();
        watchedMovies = new ArrayList<>();
        likedMovies = new ArrayList<>();
        ratedMovies = new ArrayList<>();
        notifications = new ArrayList<>();
        subscribed = new ArrayList<>();
    }

    public final Credentials getCredentials() {
        return credentials;
    }
    public final void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }
    public final int getTokensCount() {
        return tokensCount;
    }
    public final void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }
    public final int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }
    public final void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }
    public final ArrayList<Movie> getPurchasedMovies() {
        return purchasedMovies;
    }
    public final void setPurchasedMovies(final ArrayList<Movie> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }
    public final ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }
    public final void setWatchedMovies(final ArrayList<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }
    public final ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }
    public final void setLikedMovies(final ArrayList<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }
    public final ArrayList<Movie> getRatedMovies() {
        return ratedMovies;
    }
    public final void setRatedMovies(final ArrayList<Movie> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }
    public ArrayList<String> getNotifications() {
        return notifications;
    }
    public void setNotifications(ArrayList<String> notifications) {
        this.notifications = notifications;
    }
    public ArrayList<String> getSubscribed() {
        return subscribed;
    }
    public void setSubscribed(ArrayList<String> subscribed) {
        this.subscribed = subscribed;
    }

    /**
     * adds tokens to the user
     * @param tokens the number of tokens
     */
    public final void addTokes(final int tokens) {
        tokensCount += tokens;
    }

    /**
     * removes tokens from the user
     * @param tokens the number of tokens
     */
    public final void removeTokes(final int tokens) {
        tokensCount -= tokens;
    }

    /**
     * adds a movie to the purchased movies array
     * @param movie the movie to add
     */
    public final void addMovieToPurchase(final Movie movie) {
        purchasedMovies.add(movie);
    }

    /**
     * adds a movie to the watchedMovies array
     * @param movie the movie to add
     */
    public final void addMovieToWatched(final Movie movie) {
        watchedMovies.add(movie);
    }

    /**
     * adds a movie to the lickedMovie array
     * @param movie the movie to add
     */
    public final void addMovieToLiked(final Movie movie) {
        likedMovies.add(movie);
    }

    /**
     * adds a movie to the ratedMovie array
     * @param movie the movie to add
     */
    public final void addMovieToRated(final Movie movie) {
        ratedMovies.add(movie);
    }
}
