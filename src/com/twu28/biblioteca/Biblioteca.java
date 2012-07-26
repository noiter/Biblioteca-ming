package com.twu28.biblioteca;

import java.util.LinkedList;

public class Biblioteca {
    private final Output output;
    private final Input input;
    private LinkedList<Book> books;
    private LinkedList<Movie> movies;
    private LinkedList<User> users;
    private boolean isLoggedIn = false;

    public Biblioteca(Output output, Input input, LinkedList<Book> books, LinkedList<Movie> movies, LinkedList<User> users) {
        this.output = output;
        this.input = input;
        this.books = books;
        this.movies = movies;
        this.users = users;
    }

    protected void setIsLoggedIn() {
        this.isLoggedIn = true;
    }

    protected void addBook(Book book) {
        books.add(book);
    }
    protected void addUser(User user) {
        users.add(user);
    }

    public void start() {
        welcomeUser();
        while (true) {
            if (promptLoop()) break;
        }
    }

    private boolean promptLoop() {
        printMenu();
        int input = Integer.parseInt(this.input.read());
        switch (input) {
            case 0: {
                output.print("Bye!!!");
                return true;
            }
            case 1: {
                printBooks();
                return false;
            }
            case 2: {
                if(isLoggedIn) {
                    selectBook();
                }
                output.print("Sorry, but you need to login first!");
                return false;
            }
            case 3: {
                login();
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

    private void printBooks() {
        for (Book book : books) {
            output.print(book.toString());
        }
    }

    private void printMovies() {
        output.print("DISPLAY: MoviesName - Director - Rating");

        for (Movie movie : movies) {
            this.output.print(movie.toString());
        }
    }

    private void selectBook() {
        String isbn = this.input.read();

        if (isAvailable(isbn)) {
            Book book = findByIsbn(isbn);
            book.setAvailable(false);
            output.print("Thank You! Enjoy the book.");
        } else {
            output.print("Sorry we don't have that book yet.");
        }
    }

    private boolean isAvailable(String isbn) {
        Book book = findByIsbn(isbn);
        if (book == null) {
            return false;
        }
        if (book.isAvailable()) {
            return true;
        }
        return false;
    }

    private Book findByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    private void login() {
        String inputUserName = this.input.read();
        String inputUserPwd = this.input.read();

        if(verify(inputUserName, inputUserPwd)) {
            this.isLoggedIn = true;
            output.print("Thanks! Enjoy.");
        }
    }

    private boolean verify(String userName, String userPwd) {
        for(User user : users) {
            if(user.getName().equals(userName) && user.getPwd().equals(userPwd)) {
                return true;
            }
        }
        return false;
    }

    private boolean valid(String userName, String userPwd) {
        for(User user : users) {
            if(user.getName().equals(userName) && user.getPwd().equals(userPwd)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList<Book> books = new LinkedList<Book>();
        books.add(new Book("TDD", "Kent Beck", "001"));
        books.add(new Book("Head First Java", "Kathy Sierra", "002"));

        LinkedList<Movie> movies = new LinkedList<Movie>();
        movies.add(new Movie("SholayRamesh", "Sippy", Rating.NOTYET));
        movies.add(new Movie("Titanic", "Cameron", Rating.B));

        LinkedList<User> users = new LinkedList<User>();
        users.add(new User("111-1112", "123456"));
        users.add(new User("111-1113", "654321"));

        new Biblioteca(new Output(), new Input(), books, movies, users).start();
    }
}
