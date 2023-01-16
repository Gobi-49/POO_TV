package resources.data;

import program.changePage.Invoker;
import resources.pages.Page;

import java.util.ArrayList;
import java.util.Stack;

public final class ActiveUser {
    private User user;
    private Page currentPage;
    private ArrayList<Movie> currentMovieList;
    private Movie selectedMovie;
    private Invoker history;
    public ActiveUser() {
        user = null;
        currentPage = SingletonDatabase.getDatabase().getHomepageUnauthenticated();
        currentMovieList = new ArrayList<>();
        history = new Invoker();
    }
    public ActiveUser(final User user) {
        this.user = user;
        currentPage = SingletonDatabase.getDatabase().getHomepageUnauthenticated();
        currentMovieList = new ArrayList<>();
        history = new Invoker();
    }
    public Page getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(final Page currentPage) {
        this.currentPage = currentPage;
    }
    public User getUser() {
        return user;
    }
    public void setUser(final User user) {
        this.user = user;
    }
    public ArrayList<Movie> getCurrentMovieList() {
        return currentMovieList;
    }
    public void setCurrentMovieList(final ArrayList<Movie> currentMovieList) {
        this.currentMovieList = currentMovieList;
    }
    public Movie getSelectedMovie() {
        return selectedMovie;
    }
    public void setSelectedMovie(final Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }
    public Invoker getHistory() {
        return history;
    }
    public void setHistory(Invoker history) {
        this.history = history;
    }
}
