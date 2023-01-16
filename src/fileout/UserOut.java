package fileout;

import resources.data.Credentials;
import resources.data.Notification;
import resources.data.User;

import java.util.ArrayList;

public final class UserOut {
    private Credentials credentials;
    private int tokensCount;
    private int numFreePremiumMovies;
    private ArrayList<MovieOut> purchasedMovies;
    private ArrayList<MovieOut> watchedMovies;
    private ArrayList<MovieOut> likedMovies;
    private ArrayList<MovieOut> ratedMovies;
    private ArrayList<Notification> notifications;
    public UserOut() {

    }
    public UserOut(final User user) {
        if (user == null) {
            return;
        }
        credentials = new Credentials(user.getCredentials());
        tokensCount = user.getTokensCount();
        numFreePremiumMovies = user.getNumFreePremiumMovies();
        likedMovies = MovieOut.convertMovieArray(user.getLikedMovies());
        purchasedMovies = MovieOut.convertMovieArray(user.getPurchasedMovies());
        ratedMovies = MovieOut.convertMovieArray(user.getRatedMovies());
        watchedMovies = MovieOut.convertMovieArray(user.getWatchedMovies());
        notifications = new ArrayList<>(user.getNotifications());
    }

    public Credentials getCredentials() {
        return credentials;
    }
    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }
    public int getTokensCount() {
        return tokensCount;
    }
    public void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }
    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }
    public void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }
    public ArrayList<MovieOut> getPurchasedMovies() {
        return purchasedMovies;
    }
    public void setPurchasedMovies(final ArrayList<MovieOut> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }
    public ArrayList<MovieOut> getWatchedMovies() {
        return watchedMovies;
    }
    public void setWatchedMovies(final ArrayList<MovieOut> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }
    public ArrayList<MovieOut> getLikedMovies() {
        return likedMovies;
    }
    public void setLikedMovies(final ArrayList<MovieOut> likedMovies) {
        this.likedMovies = likedMovies;
    }
    public ArrayList<MovieOut> getRatedMovies() {
        return ratedMovies;
    }
    public void setRatedMovies(final ArrayList<MovieOut> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }
    public ArrayList<Notification> getNotifications() {
        return notifications;
    }
    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }
}
