package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReturnMovieTest {
    private ArrayList<Movie> movies = new ArrayList<>();
    private MovieList movieList;

    @Before
    public void setup() {
        movies.add(new Movie("Movie1", "Director1", 1999, "7/10"));
        movies.add(new Movie("Movie2", "Director2", 1998, "unrated"));
    }

    @Test
    public void shouldGiveProperMsgWhenEnteredMovieIsNotAValidMovieToReturn() throws IOException {

        ConsoleIO consoleIO = mock(ConsoleIO.class);
        when(consoleIO.read()).thenReturn("Good");
        movieList = new MovieList(movies);
        User authorisedUser = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);
        ReturnMovie returnMovie = new ReturnMovie(consoleIO, movieList, authorisedUser);

        String expected = returnMovie.action();

        assertThat(expected, is("That is not a valid movie to return\n"));
    }


    @Test
    public void shouldGiveProperMsgWhenEnteredMovieIsReturnedCorrectly() throws IOException {

        ConsoleIO consoleIO = mock(ConsoleIO.class);
        when(consoleIO.read()).thenReturn("Movie1");
        movieList = new MovieList(movies);
        User authorisedUser = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);
        ReturnMovie returnMovie = new ReturnMovie(consoleIO, movieList, authorisedUser);
        CheckOutMovies checkOutMovies = new CheckOutMovies(consoleIO, movieList, authorisedUser);
        checkOutMovies.action();
        String expected = returnMovie.action();

        assertThat(expected, is("Thank you for returning the movie.\n"));
    }

}
