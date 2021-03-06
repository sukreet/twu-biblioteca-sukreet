package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadBookList {
    String fileName;

    public ReadBookList(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Book> readListOfBooks() throws IOException {
        ArrayList<Book> listOfBooks = new ArrayList<>();
        String name, author, year;
        int yearOfPublication;


        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                name = line.substring(0, 39);
                name = name.trim();
                author = line.substring(40, 79);
                author = author.trim();
                year = line.substring(80, 89);
                year = year.trim();
                yearOfPublication = Integer.parseInt(year);

                listOfBooks.add(new Book(name, author, yearOfPublication));

                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        }

        return listOfBooks;
    }
}
