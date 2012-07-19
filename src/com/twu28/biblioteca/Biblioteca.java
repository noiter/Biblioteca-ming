package com.twu28.biblioteca;

import java.util.ArrayList;

public class Biblioteca {
    private final Output output;
    private final Input input;
    private ArrayList<Books> bookList;

    public Biblioteca(Output output, Input input) {
        this.output = output;
        this.input = input;
        this.bookList = new ArrayList<Books>();
    }

    public void addBooks(Books books1) {
        bookList.add(books1);
    }

    public void start() {
        welcomeUser();
        while (true) {
            printMenu();
            int input = this.input.read();
            if (input == 0) {
                output.print("Bye!!!");
                break;
            } else if (input == 1) {
                addBooks(new Books("Gone With the Wind"));
                output.print("Gone With the Wind");
            } else if (input == 2) {
                selectBook();
            } else if (input == 3) {
                output.print("Please talk to librarian. Thank you!");
            } else {
                output.print("Select a valid option");
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
        output.print("1. View All Books.");
        output.print("2. Reserve Book");
        output.print("3. Check Library Number");
    }

    private void welcomeUser() {
        output.print("Welcome User.");
    }
}
