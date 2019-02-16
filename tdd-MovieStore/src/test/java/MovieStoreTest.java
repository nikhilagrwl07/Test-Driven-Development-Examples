import model.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class MovieStoreTest {

    private final Movie harryPotter = new Movie("Harry Potter", "Director 1", 2008);
    private final Movie starWars = new Movie("Star Wars", "Director 1", 2009);
    private final Movie starTrek = new Movie("STAR Trek", "Director 3", 2010);
    private final Movie avengers = new Movie("avengers", "Director 3", 2011);
    private final Movie ironMan = new Movie("ironMan", "Director 3", 2012);
    private final MovieStore movieStore = new MovieStore();

    @Before
    public void setUp() throws Exception {
        movieStore.add(starTrek);
        movieStore.add(harryPotter);
        movieStore.add(starWars);
        movieStore.add(avengers);
        movieStore.add(ironMan);
    }

    @Test
    public void returnNoResultsWhenNoTitlePartialMatchSearchCaseInsensitive(){
        List<Movie> movies = movieStore.findByPartialTitle("abc");
        Assert.assertThat(movies.size(), is(0));
    }

    @Test
    public void findMoviesWhenTitlePartiallyMatch(){

        List<Movie> movies = movieStore.findByPartialTitle("star");

        Assert.assertThat(movies.size(), is(2));
        Assert.assertThat(movies, hasItems(starTrek, starWars));
    }

    @Test
    public void findMoviesWhenDirectorExactlyMatch(){
        List<Movie> movies = movieStore.findByDirectorFullMatch("Director 1");

        Assert.assertThat(movies.size(), is(2));
        Assert.assertThat(movies, hasItems(harryPotter, starWars));
    }

    @Test
    public void findMoviesWhenReleaseDateFallBetweenTwoValues(){
        List<Movie> movies = movieStore.findMoviesBetweenDates(2009, 2011);

        Assert.assertThat(movies.size(), is(1));
        Assert.assertThat(movies, hasItems(starTrek));
    }
}