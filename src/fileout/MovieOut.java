package fileout;

import filein.MoviesInput;
import resources.data.Movie;

import java.util.ArrayList;

public class MovieOut {
    private String name;
    private int year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;
    private int numLikes;
    private Double rating;
    private int numRatings;
    public MovieOut() {
    }
    public MovieOut(MoviesInput moviesInput) {
        name = moviesInput.getName();
        year = moviesInput.getYear();
        duration = moviesInput.getDuration();
        genres = moviesInput.getGenres();
        actors = moviesInput.getActors();
        countriesBanned = moviesInput.getCountriesBanned();
        numLikes = 0;
        rating = 0.0;
        numRatings = 0;
    }
    public MovieOut(Movie movie) {
        name = movie.getName();
        year = movie.getYear();
        duration = movie.getDuration();
        genres = movie.getGenres();
        actors = movie.getActors();
        countriesBanned = movie.getCountriesBanned();
        numLikes = movie.getNumLikes();
        rating = movie.getRating();
        numRatings = movie.getNumRatings();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public ArrayList<String> getGenres() {
        return genres;
    }
    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }
    public ArrayList<String> getActors() {
        return actors;
    }
    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }
    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }
    public void setCountriesBanned(ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }
    public int getNumLikes() {
        return numLikes;
    }
    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public int getNumRatings() {
        return numRatings;
    }
    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }

    public static ArrayList<MovieOut> convertMovieArray(ArrayList<Movie> movies) {
        ArrayList<MovieOut> movieOuts = new ArrayList<>();
        for(Movie i :movies) {
            movieOuts.add(new MovieOut(i));
        }
        return movieOuts;
    }
}
