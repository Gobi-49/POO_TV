package fileout;

import resources.data.ActiveUser;
import resources.data.User;

public class UserOut extends User {
    public UserOut(User user) {
        if(user == null) {
            return;
        }
        setCredentials(user.getCredentials());
        setLikedMovies(user.getLikedMovies());
        setNumFreePremiumMovies(user.getNumFreePremiumMovies());
        setPurchasedMovies(user.getPurchasedMovies());
        setratedMovies(user.getratedMovies());
        setTokensCount(user.getTokensCount());
        setwatchedMovies(user.getwatchedMovies());
    }
}
