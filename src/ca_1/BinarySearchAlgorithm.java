

package ca_1;
/**
 *
 * @author jhane
 */
import java.util.ArrayList; // Import the ArrayList class to use dynamic arrays.

public class BinarySearchAlgorithm {

    // This method searches for a book in the list using binary search.
    public static int binarySearchAlgorithm(ArrayList<String> resultBook, String bookToSearch) {

        // Set the starting point of the search to the first index.
        int leftPoint = 0; 
        // Set the ending point of the search to the last index.
        int rightPoint = resultBook.size() - 1; 

        // Continue searching while there are elements in the search range.
        while (leftPoint <= rightPoint) {
            // Calculate the middle index of the current search range.
            int middlePoint = leftPoint + (rightPoint - leftPoint) / 2;
            // Compare the middle element with the bookToSearch, ignoring case.
            int comparisonResult = resultBook.get(middlePoint).compareTo(bookToSearch);

            if (comparisonResult == 0) {
                return middlePoint; // If found, return the index of the book.
            } else if (comparisonResult < 0) {
                leftPoint = middlePoint + 1; // Search in the right half of the list.
            } else {
                rightPoint = middlePoint - 1; // Search in the left half of the list.
            }
        }

        return -1; // If the book is not found, return -1.
    }
}
