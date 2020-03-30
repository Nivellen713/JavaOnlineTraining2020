package com.training.classes.major.classfirst;

public class Librarian {

    public Library getBooksByGivenAuthor(String authorNameFromUser, Library library) {
        authorNameFromUser = authorNameFromUser.trim();
        if (library.authorName.equalsIgnoreCase(authorNameFromUser)) {
            return library;
        }
        return null;
    }


    public Library getBooksByGivenPublishingHouse(String publishingHouseFromUser, Library library){
        publishingHouseFromUser = publishingHouseFromUser.trim();
        if (library.publishingHouse.equalsIgnoreCase(publishingHouseFromUser)) {
            return library;
        }
        return null;
    }

    public Library getBooksByGivenYearOfPublicised(int yearOfPublicisedFromUser, Library library){
        if (library.yearOfPublicised > yearOfPublicisedFromUser) {
            return library;
        }
        return null;
    }

}
