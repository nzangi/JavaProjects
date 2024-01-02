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
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                What do want to do in library:
                1 To show books in store
                2 Issue books in store
                3 Return book to library
                4 Update books in store
                5 Remove book in library\s""");
        int choice = scanner.nextInt();
        if (choice==1){
            showBooksInLibrary();
        } else if (choice==2) {
            issueBooksInLibrary();
        } else if (choice==3) {
            returnBooksInLibrary();
        } else if (choice==4) {
            updateBooksInLibrary();
        }
        else {
            removeBooksInLibrary();
        }
    }
    public static void showBooksInLibrary(){
        ArrayList<String> booksInLibrary = addBooksInLibrary();
        printBooksInLibrary(booksInLibrary);
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
    public static void printBooksInLibrary(ArrayList<String> booksInLibrary){
        System.out.println("|---------------------------------------------------------------------|");
        System.out.println("|BOOK ID  || BOOK NAME || AUTHOR  ||   PAGES   || YEAR OF PUBLICATION |");
        System.out.println("|---------------------------------------------------------------------|");

        for (String bookInLibrary: booksInLibrary ){
            System.out.println(bookInLibrary);
        }
        System.out.println("|---------------------------------------------------------------------|");
    }
    public static String[] issueBooksInLibrary(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> booksInLibrary = addBooksInLibrary();
        printBooksInLibrary(booksInLibrary);


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
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> booksInLibrary = addBooksInLibrary();
        System.out.println("|---------------------------------------------------------------------|");
        System.out.println("Books in library to update");
        System.out.println("|---------------------------------------------------------------------|");
        printBooksInLibrary(booksInLibrary);
        System.out.print("Enter the book ID to edit: ");
        int bookId = scanner.nextInt();
        String bookToUpdate = booksInLibrary.get(bookId-1);
        String formattedBookToUpdate = bookToUpdate.replaceAll("[\\[\\]| ]+", ",");
        String[] formattedBookToUpdateArray = formattedBookToUpdate.split(",");
        for (int i =0;i<formattedBookToUpdateArray.length;i++){
            System.out.println("(2) Book Title is : "+formattedBookToUpdateArray[2]);
            System.out.println("(3) Book Author  is : "+formattedBookToUpdateArray[3]);
            System.out.println("(4) Total book pages are :"+formattedBookToUpdateArray[4]);
            System.out.println("(5) Book Year of publication is :"+formattedBookToUpdateArray[5]);
        }
        System.out.print("Enter the book Item to update from (2-5) to edit: ");
        int bookItemToUpdate = scanner.nextInt();
        scanner.nextLine();
        for (int i =2;i <formattedBookToUpdateArray.length;i++){
            System.out.print("Update your value selected of "+bookItemToUpdate+" : ");
            String bookValueToUpdate = scanner.nextLine();
            formattedBookToUpdateArray[i] = bookValueToUpdate;
            break;
        }
        booksInLibrary.remove(bookId-1);
        booksInLibrary.add("|     "+formattedBookToUpdateArray[1]+"  ||  "+formattedBookToUpdateArray[2]+"        ||    "+formattedBookToUpdateArray[3]+"   ||   "+formattedBookToUpdateArray[4]+"    ||         "+formattedBookToUpdateArray[5]+"        |");

        printBooksInLibrary(booksInLibrary);

    }
    public static void removeBooksInLibrary(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> booksInLibrary = addBooksInLibrary();
        printBooksInLibrary(booksInLibrary);
        System.out.print("Enter the book to remove from the library: ");
        int bookToRemove = scanner.nextInt();
        booksInLibrary.remove(bookToRemove);
        System.out.println("You have successfully removed the book from library.");
        printBooksInLibrary(booksInLibrary);

    }
}
