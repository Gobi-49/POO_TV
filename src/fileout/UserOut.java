package fileout;

import filein.UsersInput;
import resources.data.ActiveUser;
import resources.data.Credentials;
import resources.data.Movie;
import resources.data.User;
import resources.pages.MoviesPage;

import java.util.ArrayList;

public class UserOut {
    private Credentials credentials;
    private int tokensCount;
    private int numFreePremiumMovies;
    private ArrayList<MovieOut> purchasedMovies;
    private ArrayList<MovieOut> watchedMovies;
    private ArrayList<MovieOut> likedMovies;
    private ArrayList<MovieOut> ratedMovies;
    public UserOut() {

    }
    public UserOut(User user) {
        if(user == null) {
            return;
        }
        credentials = new Credentials(user.getCredentials());
        tokensCount = user.getTokensCount();
        numFreePremiumMovies = user.getNumFreePremiumMovies();
        likedMovies = MovieOut.convertMovieArray(user.getLikedMovies());
        purchasedMovies = MovieOut.convertMovieArray(user.getPurchasedMovies());
        ratedMovies = MovieOut.convertMovieArray(user.getRatedMovies());
        watchedMovies = MovieOut.convertMovieArray(user.getWatchedMovies());
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
    public ArrayList<MovieOut> getPurchasedMovies() {
        return purchasedMovies;
    }
    public void setPurchasedMovies(ArrayList<MovieOut> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }
    public ArrayList<MovieOut> getWatchedMovies() {
        return watchedMovies;
    }
    public void setWatchedMovies(ArrayList<MovieOut> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }
    public ArrayList<MovieOut> getLikedMovies() {
        return likedMovies;
    }
    public void setLikedMovies(ArrayList<MovieOut> likedMovies) {
        this.likedMovies = likedMovies;
    }
    public ArrayList<MovieOut> getRatedMovies() {
        return ratedMovies;
    }
    public void setRatedMovies(ArrayList<MovieOut> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }
}
