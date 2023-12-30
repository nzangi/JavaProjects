package BookManagementSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
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
        returnBooksInLibrary();

    }
    public static void showBooksInLibrary(){

    }
    public static ArrayList<String> addBooksInLibrary(){
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
        int bookID = 0;
        while (i < numberOfBooks){
            System.out.print("Enter the book title name of book "+(i+1)+": ");
            bookNameTitle = scanner.nextLine();
            System.out.print("Enter the name of the author: ");
            bookAuthor = scanner.nextLine();
            System.out.print("Enter the number of pages of book "+bookNameTitle+": ");
            bookPages= scanner.nextInt();
            System.out.print("Enter the year of publication: ");
            bookYearOfPublication = scanner.nextInt();
            bookID=bookID+1;
            addBooksToLibrary.add("|     "+bookID+"  ||  "+bookNameTitle+"        ||    "+bookAuthor+"   ||   "+bookPages+"    ||         "+bookYearOfPublication+"        |");
            i++;
            scanner.nextLine();
        }

        return  addBooksToLibrary;

    }
    public static String[] issueBooksInLibrary(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> booksInLibrary = addBooksInLibrary();
        System.out.println("|---------------------------------------------------------------------|");
        System.out.println("|BOOK ID  || BOOK NAME || AUTHOR  ||   PAGES   || YEAR OF PUBLICATION |");
        System.out.println("|---------------------------------------------------------------------|");

        for (String bookInLibrary: booksInLibrary ){
            System.out.println(bookInLibrary);
        }
        System.out.println("|---------------------------------------------------------------------|");

        System.out.print("Enter the book ID you want to issue? ");
        int bookIdToIssue=scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the student ADM No to issue the book: ");
        String studentAdmnNo = scanner.nextLine();
        String bookToIssue = booksInLibrary.get(bookIdToIssue-1);
        String formattedBookToIssued = bookToIssue.replaceAll("[\\[\\]| ]+", ",");

        String[] formattedBookToIssuedArray = formattedBookToIssued.split(",");
        System.out.println();
        for (int i=0;i<formattedBookToIssuedArray.length;i++ ){
            System.out.println("You have issue book "+formattedBookToIssuedArray[2]+" to student Admission number "+studentAdmnNo);
            break;

        }

        String[] studentDataIssuedBook = {studentAdmnNo,formattedBookToIssuedArray[2]};
        return studentDataIssuedBook;

    }
    public static void returnBooksInLibrary(){
        Scanner scanner = new Scanner(System.in);
        String[] issuedBook = issueBooksInLibrary();
        System.out.println(Arrays.toString(issuedBook));

        System.out.print("Enter the name of the book which has been returned: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter the Student Admission : ");
        String studentAdmnNo = scanner.nextLine();

        if (Objects.equals(studentAdmnNo, issuedBook[0]) && Objects.equals(bookName, issuedBook[1])){
            System.out.println("The book is successfully returned to library!");
        }
        else {
            System.out.println("Incorrect return details!");
        }



    }
    public static void updateBooksInLibrary(){

    }
    public static void removeBooksInLibrary(){

    }
}
