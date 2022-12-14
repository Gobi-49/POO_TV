package fileout;

import resources.data.CurrentUser;
import resources.data.Movie;
import resources.data.User;
import resources.pages.Page;

import java.util.ArrayList;

public class UserOut extends User {
    public UserOut(CurrentUser currentUser) {
        setCredentials(currentUser.getCredentials());
        setLickedMovie(getLickedMovie());
        setNumFreePremiumMovies(getNumFreePremiumMovies());
        setPurchasedMovies(getPurchasedMovies());
        setRatedMovie(getRatedMovie());
        setTokensCount(getTokensCount());
        setWatchedMovie(getWatchedMovie());
    }
}
