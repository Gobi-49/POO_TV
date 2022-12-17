package resources.data;

import filein.MoviesInput;

import java.util.ArrayList;
import java.util.Objects;

public class Movie {
    private String name;
    private int year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;
    private int numLikes;
    private Double rating;
    private ArrayList<Integer> ratings;
    private int numRatings;
    public Movie() {
    }
    public Movie(MoviesInput moviesInput) {
        name = moviesInput.getName();
        year = moviesInput.getYear();
        duration = moviesInput.getDuration();
        genres = moviesInput.getGenres();
        actors = moviesInput.getActors();
        countriesBanned = moviesInput.getCountriesBanned();
        numLikes = 0;
        rating = (double) 0;
        numRatings = 0;
        ratings = new ArrayList<>();
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

    public void addLike() {
        numLikes++;
    }
    public void addRating(int rate) {
        numRatings++;
        ratings.add(rate);
        calculateRating();
    }
    public void calculateRating() {
        int sum = 0;
        for(Integer i : ratings) {
            sum += i;
        }
        rating = (double) (sum/numRatings);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                ", genres=" + genres +
                ", actors=" + actors +
                ", countriesBanned=" + countriesBanned +
                ", numLikes=" + numLikes +
                ", rating=" + rating +
                ", ratings=" + ratings +
                ", numRatings=" + numRatings +
                '}';
    }
}
