package fileout;

import resources.data.ActiveUser;
import resources.data.User;

public class UserOut extends User {
    public UserOut(User user) {
        if(user == null) {
            return;
        }
        setCredentials(user.getCredentials());
        setLickedMovie(getLickedMovie());
        setNumFreePremiumMovies(getNumFreePremiumMovies());
        setPurchasedMovies(getPurchasedMovies());
        setRatedMovie(getRatedMovie());
        setTokensCount(getTokensCount());
        setWatchedMovie(getWatchedMovie());
    }
}
