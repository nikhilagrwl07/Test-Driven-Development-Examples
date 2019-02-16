import model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class MovieStore {

    List<Movie> movies = new LinkedList<Movie>();

    public void add(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findByPartialTitle(String searchQuery) {
        return movies.stream().filter(titleNamePartialMatch(searchQuery)).collect(Collectors.toList());
    }

    public List<Movie> findByDirectorFullMatch(String directorName) {
        return movies.stream().filter(directorNameFullMatch(directorName)).collect(Collectors.toList()); }

    List<Movie> findMoviesBetweenDates(int from, int to) {
        return movies.stream().filter(releaseYearBetween(from,to)).collect(Collectors.toList());
    }

    private static Predicate<Movie> titleNamePartialMatch(String title)
    {
        return movie -> (movie.title().toLowerCase().contains(title.toLowerCase()));
    }

    private static Predicate<Movie> directorNameFullMatch(String director)
    {
        return movie -> (movie.director().equals(director));
    }

    private static Predicate<Movie> releaseYearBetween(int from, int to)
    {
        return movie -> (movie.releaseYear() > from && movie.releaseYear()<to);
    }
}

