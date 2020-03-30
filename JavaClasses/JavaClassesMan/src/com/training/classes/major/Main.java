package com.training.classes.major;

import com.training.classes.major.classfirst.Library;
import com.training.classes.major.classfirst.Librarian;
import  java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library[] library = new Library[11];
        Library[] enteredBooks = new Library[11];
        String authorNameFromUser;
        String publishingHouseFromUser;
        String userChoice;
        int yearOfPublicisedFromUser;

        Librarian librarian = new Librarian();
        Scanner scanner = new Scanner(System.in);

        library[0] = new Library("Captain Grant children", "Jule Verne", 2018,
                "AST", "soft", 703, 4.75f, 100);
        library[1] = new Library("The Shining", "Steven King", 2019,
                "AST", "soft", 636, 5.10f, 101);
        library[2] = new Library("Around the World in 80 Days", "Jule Verne", 2015,
                "AZBUKA", "soft", 280, 3.50f, 102);
        library[3] = new Library("Farnham's Freehold", "Robert Heinlein", 2016,
                "MOSKVA", "soft", 510, 3.25f, 103);
        library[4] = new Library("Treasure Island", "Robert Stevenson", 2009,
                "Biblioteka na vse vremena", "hard", 192, 4.10f, 104);
        library[5] = new Library("The Silmarillion", "John Tolkien", 1992,
                "Gil' Estel'", "soft", 414, 2.75f, 105);
        library[6] = new Library("Triumphal Arch", "Erich Remark", 2019,
                "AST", "soft", 638, 4.20f, 106);
        library[7] = new Library("The Anatomy of Human Destructiveness", "Erich Fromm", 2019,
                "AST", "soft", 734, 4.50f, 107);
        library[8] = new Library("Urban landscape", "Jens Huebner", 2018,
                "Content", "hard", 127, 5.75f, 108);
        library[9] = new Library("Introduction in nuclear physics", "Novikova G.", 2005,
                "SRC Regular and chaotic dynamic", "soft", 204, 4.75f, 109);
        library[10] = new Library("The Voyages and Adventures of Captain Hatteras", "Jule Verne", 2016,
                "AZBUKA", "soft", 479, 3.20f, 110);

        System.out.println("Please choice sorting method: \n" +
                "a) list of books by the specified author \n" +
                "b) list of books published by the specified publisher \n" +
                "c) list of books released after a given year");
        userChoice = scanner.next();
        userChoice = userChoice.trim().toLowerCase();
        System.out.println();

        switch (userChoice){
            case "a":
                System.out.print("Please choice your author: " + scanner.nextLine());
                authorNameFromUser = scanner.nextLine();
                for (int i = 0; i < library.length; i++) {
                    enteredBooks[i] = librarian.getBooksByGivenAuthor(authorNameFromUser, library[i]);
                    if (enteredBooks[i] != null){
                        System.out.println(enteredBooks[i]);
                    }
                }
                break;
            case "b":
                System.out.print("Please choice your publishing house: ");
                publishingHouseFromUser = scanner.next();
                for (int i = 0; i < library.length; i++) {
                    enteredBooks[i] = librarian.getBooksByGivenPublishingHouse(publishingHouseFromUser, library[i]);
                    if (enteredBooks[i] != null){
                        System.out.println(enteredBooks[i]);
                    }
                }
                break;
            case "c":
                System.out.print("Please choice your year: ");
                yearOfPublicisedFromUser = scanner.nextInt();
                for (int i = 0; i < library.length; i++) {
                    enteredBooks[i] = librarian.getBooksByGivenYearOfPublicised(yearOfPublicisedFromUser, library[i]);
                    if (enteredBooks[i] != null){
                        System.out.println(enteredBooks[i]);
                    }
                }
                break;
            default:
                System.out.println("Sorry, but I don't know your sorted method");
        }
    }
}
