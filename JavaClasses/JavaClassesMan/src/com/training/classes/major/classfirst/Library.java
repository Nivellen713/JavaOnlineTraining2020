package com.training.classes.major.classfirst;

public class Library {

    public int bookId;
    public String bookName;
    public String authorName;
    public String publishingHouse;
    public int yearOfPublicised;
    public int pagesInBook;
    public float bookPriceInDollars;
    public String typeCover;

    public Library(String bookName, String authorName, int yearOfPublicised, String publishingHouse,
                   String typeCover, int pagesInBook, float bookPriceInDollars, int bookId) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.yearOfPublicised = yearOfPublicised;
        this.publishingHouse = publishingHouse;
        this.typeCover = typeCover;
        this.pagesInBook = pagesInBook;
        this.bookPriceInDollars = bookPriceInDollars;
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getYearOfPublicised() {
        return yearOfPublicised;
    }

    public void setYearOfPublicised(int yearOfPublicised) {
        this.yearOfPublicised = yearOfPublicised;
    }

    public int getPagesInBook() {
        return pagesInBook;
    }

    public void setPagesInBook(int pagesInBook) {
        this.pagesInBook = pagesInBook;
    }

    public float getBookPriceInDollars() {
        return bookPriceInDollars;
    }

    public void setBookPriceInDollars(float bookPriceInDollars) {
        this.bookPriceInDollars = bookPriceInDollars;
    }

    public String getTypeCover() {
        return typeCover;
    }

    public void setTypeCover(String typeCover) {
        this.typeCover = typeCover;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id = " + bookId +
                ", book name = '" + bookName + '\'' +
                ", author = '" + authorName + '\'' +
                ", publishing house = '" + publishingHouse + '\'' +
                ", year = " + yearOfPublicised +
                ", pages = " + pagesInBook +
                ", priceInDollars = " + bookPriceInDollars +
                ", typeCover = '" + typeCover + '\'' +
                '}';
    }
}