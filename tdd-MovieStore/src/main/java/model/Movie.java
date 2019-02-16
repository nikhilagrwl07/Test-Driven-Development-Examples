package model;

public class Movie {

    private String title;
    private String directorName;
    private int releaseYear;

    public Movie(String title, String directorName, int releaseYear) {
        this.title = title;
        this.directorName = directorName;
        this.releaseYear = releaseYear;
    }

    public String title() {
        return title;
    }

    public String director() {
        return directorName;
    }

    public int releaseYear() {
        return releaseYear;
    }
}
