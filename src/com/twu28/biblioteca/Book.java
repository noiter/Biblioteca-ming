package com.twu28.biblioteca;

public class Book {
    private String isbn;
    private String name;
    private String author;
    private boolean isAvailable;

    public boolean isAvailable() {
        return isAvailable;
    }

    public Book(String name, String author, String isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        isAvailable = true;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return isbn + ", " + name + ", " + author;
    }

    public String getIsbn() {
        return isbn;
    }
}
