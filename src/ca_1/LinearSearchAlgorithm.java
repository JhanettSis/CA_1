/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_1;
/**
 *
 * @author jhane
 */
// Import the ArrayList class to use dynamic arrays.
import java.util.ArrayList; 

public class LinearSearchAlgorithm {

    // This method searches for a book in the list using linear search.
    public static int linearSearch(ArrayList<String> listBooks, String bookToSearch) {
        // Loop through the list of books.
        for (int i = 0; i < listBooks.size(); i++) {
            // Check if the current book is equal to the book we are searching for.
            if (listBooks.get(i).equals(bookToSearch)) {  // Use .equals() to compare strings.
                return i;  // If found, return the index of the book.
            }
        }
        return -1;  // If the book is not found, return -1.
    }
}
