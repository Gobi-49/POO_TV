package resources.data;

import filein.MoviesInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Movie {
    private String name;
    private String year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;
    private int numLikes;
    private Double rating;
    private HashMap<User, Integer> ratings;
    private int numRatings;
    public Movie() {
    }
    public Movie(final MoviesInput moviesInput) {
        name = moviesInput.getName();
        year = moviesInput.getYear();
        duration = moviesInput.getDuration();
        genres = moviesInput.getGenres();
        actors = moviesInput.getActors();
        countriesBanned = moviesInput.getCountriesBanned();
        numLikes = 0;
        rating = (double) 0;
        numRatings = 0;
        ratings = new HashMap<>();
    }

    public final String getName() {
        return name;
    }
    public final void setName(final String name) {
        this.name = name;
    }
    public final String getYear() {
        return year;
    }
    public final void setYear(final String year) {
        this.year = year;
    }
    public final int getDuration() {
        return duration;
    }
    public final void setDuration(final int duration) {
        this.duration = duration;
    }
    public final ArrayList<String> getGenres() {
        return genres;
    }
    public final void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }
    public final ArrayList<String> getActors() {
        return actors;
    }
    public final void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }
    public final ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }
    public final void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }
    public final int getNumLikes() {
        return numLikes;
    }
    public final void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }
    public final Double getRating() {
        return rating;
    }
    public final void setRating(final Double rating) {
        this.rating = rating;
    }
    public final int getNumRatings() {
        return numRatings;
    }
    public final void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }

    /**
     * adds a like to the movie
     */
    public final void addLike() {
        numLikes++;
    }

    /**
     * adds rating to the movie
     * @param rate the rate
     */
    public final void addRating(final int rate, User user) {
        ratings.put(user, rate);
        calculateRating();
        numRatings = ratings.size();
    }

    /**
     * Calculates the rating of the movie
     */
    public final void calculateRating() {
        double sum = 0;
        for (User i : ratings.keySet()) {
            sum += ratings.get(i);
        }
        rating = sum / ratings.size();
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public final String toString() {
        return "Movie{"
                + "name='"
                + name
                + '\''
                + ", year="
                + year
                + ", duration="
                + duration
                + ", genres="
                + genres
                + ", actors="
                + actors
                + ", countriesBanned="
                + countriesBanned
                + ", numLikes="
                + numLikes
                + ", rating="
                + rating
                + ", ratings="
                + ratings
                + ", numRatings="
                + numRatings
                + '}';
    }
}
