package resources.data;

import filein.UsersInput;
import resources.pages.Page;

import java.util.ArrayList;

public class ActiveUser {
    private User user;
    private Page currentPage;
    private ArrayList<Movie> currentMovieList;
    private Movie selectedMovie;
    public ActiveUser() {
        user = null;
        currentPage = Database.getDatabase().getHomepageUnauthenticated();
        currentMovieList = new ArrayList<>();
    }
    public ActiveUser(User user) {
        this.user = user;
        currentPage = Database.getDatabase().getHomepageUnauthenticated();
        currentMovieList = new ArrayList<>();
    }
    public Page getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public ArrayList<Movie> getCurrentMovieList() {
        return currentMovieList;
    }
    public void setCurrentMovieList(ArrayList<Movie> currentMovieList) {
        this.currentMovieList = currentMovieList;
    }
    public Movie getSelectedMovie() {
        return selectedMovie;
    }
    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }
}
