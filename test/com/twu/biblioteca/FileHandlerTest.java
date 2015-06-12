package com.twu.biblioteca;


import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FileHandlerTest {
    @Test
    public void shouldReadListOfAvailableBooks() throws IOException {
        String testFileName = "listOfBooks.txt";

        FileHandler readBooks = new FileHandler(testFileName);

        ArrayList<Book> actualListOfBooks = readBooks.readListOfBooks();

        ArrayList<Book> expectedListOfBooks = new ArrayList<>();
        expectedListOfBooks.add(new Book("Macbeth", "William Shakespear", 1611));
        expectedListOfBooks.add(new Book("Angles And Demons", "Dan Brown", 2009));

        assertThat(actualListOfBooks, is(expectedListOfBooks));
    }
}
