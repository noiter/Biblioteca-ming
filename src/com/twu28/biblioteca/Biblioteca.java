package com.twu28.biblioteca;

import java.util.ArrayList;

public class Biblioteca {
    private final Output output;
    private final Input input;
    private ArrayList<Books> bookList;
    private ArrayList<Movies> movieList;

    public Biblioteca(Output output, Input input) {
        this.output = output;
        this.input = input;
        this.bookList = new ArrayList<Books>();
        this.movieList = new ArrayList<Movies>();
    }

    public void addBooks(Books book) {
        bookList.add(book);
    }
    public void addMovies(Movies movie) {
        movieList.add(movie);
    }

    public void start() {
        welcomeUser();
        while (true) {
            if (promptLoop()) break;
        }
    }

    private boolean promptLoop() {
        printMenu();
        int input = this.input.read();

        switch (input) {
            case 0: {
                output.print("Bye!!!");
                return true;
            }
            case 1: {
                addBooks(new Books("Gone With the Wind"));
                output.print("Gone With the Wind");
                return false;
            }
            case 2: {
                selectBook();
                return false;
            }
            case 3: {
                output.print("Please talk to librarian. Thank you!");
                return false;
            }
            case 4: {
                printMovies();
                return false;
            }
            default:
                output.print("Select a valid option");
                return false;
        }
    }

    private void printMovies() {
        output.print("DISPLAYORDER: MoviesName, Director, Rating");
        addMovies(new Movies("SholayRamesh", "Sippy", Rating.NOTYET));
        addMovies(new Movies("Titanic", "Cameron", Rating.B));
        for(int index = 0; index < movieList.size(); index++) {
            if(movieList.get(index).getRating() == Rating.NOTYET) {
                output.print(movieList.get(index).getName() + " "
                        + movieList.get(index).getDirector() + " " + "N/A");
            } else {
                output.print(movieList.get(index).getName() + " "
                        + movieList.get(index).getDirector() + " " + movieList.get(index).getRating().toString());
            }
        }
    }

    private void selectBook() {
        int bookNum = this.input.read();
        if (isAvailable(bookNum)) {
            output.print("Thank You! Enjoy the book.");
        } else {
            output.print("Sorry we don't have that book yet.");
        }
    }

    private boolean isAvailable(int bookNum) {
        return bookNum <= bookList.size() && bookList.get(bookNum - 1).isAvailable();
    }

    public static void main(String[] args) {
        new Biblioteca(new Output(), new Input()).start();
    }

    private void printMenu() {
        output.print("0. Exit");
        output.print("1. View All Books");
        output.print("2. Reserve Book");
        output.print("3. Check Library Number");
        output.print("4. View ALl Movies");
    }

    private void welcomeUser() {
        output.print("Welcome User.");
    }
}
