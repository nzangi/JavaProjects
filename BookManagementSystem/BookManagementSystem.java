package BookManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

/*
The projects deals with BookManagementSystem
It will be able to:

(1) Show the available books in library (Title,Pages,Author,Year of publication)
(2) Add a book in the library (Title,Pages,Author,Year of publication)
(3) Remove a book in library
(4) Update the book details
(5) Issue the book to student using student ADM NO
(6) Return a book

 */
public class BookManagementSystem {
    public static void main(String[] args){
        addBooksInLibrary();

    }
    public static void showBooksInLibrary(){

    }
    public static void addBooksInLibrary(){
        Scanner scanner = new Scanner(System.in);
        String bookNameTitle;
        String bookAuthor;
        int bookPages;
        int bookYearOfPublication;
        ArrayList<String> addBooksToLibrary = new ArrayList<>();
        System.out.print("Enter the number of books to add in library: ");
        int numberOfBooks = scanner.nextInt();
        scanner.nextLine();
        int i =0;
        while (i < numberOfBooks){
            System.out.print("Enter the book title name of book "+(i+1)+": ");
            bookNameTitle = scanner.nextLine();
            System.out.print("Enter the name of the author: ");
            bookAuthor = scanner.nextLine();
            System.out.print("Enter the number of pages of book "+bookNameTitle+": ");
            bookPages= scanner.nextInt();
            System.out.print("Enter the year of publication: ");
            bookYearOfPublication = scanner.nextInt();
            addBooksToLibrary.add(bookNameTitle+" "+bookAuthor+" "+bookPages+" "+bookYearOfPublication);
            i++;
            scanner.nextLine();
        }
        System.out.print(addBooksToLibrary);

    }
    public static void issueBooksInLibrary(){

    }
    public static void returnBooksInLibrary(){

    }
    public static void updateBooksInLibrary(){

    }
    public static void removeBooksInLibrary(){

    }
}
