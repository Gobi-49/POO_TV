package filein;

public final class ActionsInput {
    private String type;
    private String page;
    private String feature;
    private CredentialsInput credentials;
    private String startsWith;
    private String movie;
    private FiltersInput filters;
    private String count;
    private int rate;
    private MoviesInput addedMovie;
    private String deletedMovie;
    private String subscribedGenre;

    public String getType() {
        return type;
    }
    public void setType(final String type) {
        this.type = type;
    }
    public String getPage() {
        return page;
    }
    public void setPage(final String page) {
        this.page = page;
    }
    public String getFeature() {
        return feature;
    }
    public void setFeature(final String feature) {
        this.feature = feature;
    }
    public CredentialsInput getCredentials() {
        return credentials;
    }
    public void setCredentials(final CredentialsInput credentials) {
        this.credentials = credentials;
    }
    public String getStartsWith() {
        return startsWith;
    }
    public void setStartsWith(final String startsWith) {
        this.startsWith = startsWith;
    }
    public String getMovie() {
        return movie;
    }
    public void setMovie(final String movie) {
        this.movie = movie;
    }
    public FiltersInput getFilters() {
        return filters;
    }
    public void setFilters(final FiltersInput filters) {
        this.filters = filters;
    }
    public String getCount() {
        return count;
    }
    public void setCount(final String count) {
        this.count = count;
    }
    public int getRate() {
        return rate;
    }
    public void setRate(final int rate) {
        this.rate = rate;
    }
    public MoviesInput getAddedMovie() {
        return addedMovie;
    }
    public void setAddedMovie(MoviesInput addedMovie) {
        this.addedMovie = addedMovie;
    }
    public String getDeletedMovie() {
        return deletedMovie;
    }
    public void setDeletedMovie(String deletedMovie) {
        this.deletedMovie = deletedMovie;
    }
    public String getSubscribedGenre() {
        return subscribedGenre;
    }
    public void setSubscribedGenre(String subscribedGenre) {
        this.subscribedGenre = subscribedGenre;
    }
}
