

package ca_1;
/**
 *
 * @author jhane
 */
// Importing ArrayList to store lists of book titles and their page numbers.
import java.util.ArrayList; 
// Importing Scanner to read input from the user.
import java.util.Scanner; 

public class SectionOfMenuSearch {
    
    // Private Scanner object to read user input.
    private Scanner mySc; 

    // Constructor that initializes the Scanner object with the one passed from the main program.
    public SectionOfMenuSearch(Scanner mySc) {
        this.mySc = mySc;
    }

    // Static method that displays the search menu and handles the searching of books.
    public static void searchMenu(ArrayList<String> listBooks, ArrayList<Integer> numPages, Scanner mySc) {
         // Variable to store the book name entered by the user.
        String bookNameToSearch = "";
        // Variables for taking the time with function LinearSearch.
        long startTimeLinearSearch, endTimeLinearSearch, durationLinearSearch; 
        // Variables for taking the time with function BinarySearch.
        long startTimeBinarySearch, endTimeBinarySearch, durationBinarySearch;
        
        // Variables for taking the time with function BubbleSort.
        long startTimeBubbleSort, endTimeBubbleSort, durationBubbleSort;
        
        // Variables for taking the time with function SelectionSort.
        long startTimeSelectionSort, endTimeSelectionSort, durationSelectionSort;
        

        // Prompting the user to enter the book name they want to search for.
        System.out.print("   ➸ Please enter the name of the book you wish to find: ");
        // Reading user input and removing any leading/trailing spaces.
        bookNameToSearch = mySc.nextLine().trim(); 

        // Step 1.1: Sort the books by title using Bubble and Selection Sort (ascending order by default).
        // Start measuring time for Bubble Sort function.
        startTimeBubbleSort = System.nanoTime();
        ArrayList<Object> dataResultSorted = SortBookByTitlesAndNumberPages.bubbleSortByTitles(listBooks, numPages, "1");
        // End measuring time for Binary Search.
        endTimeBubbleSort = System.nanoTime();
        
        // Start measuring time for Bubble Sort function.
        startTimeSelectionSort = System.nanoTime();
        SortBookByTitlesAndNumberPages.selectionSortByTitles(listBooks, numPages, "1");
        // End measuring time for Binary Search.
        endTimeSelectionSort = System.nanoTime();
        

        // Retrieve the sorted book titles and corresponding page numbers from the result.
        ArrayList<String> resultBooksSorted = (ArrayList<String>) dataResultSorted.get(0); // Sorted list of book titles.
        ArrayList<Integer> resultNumPagesSorted = (ArrayList<Integer>) dataResultSorted.get(1); // Corresponding page numbers.

        // Step 2: Perform Linear Search on the sorted list of books.
        // Start measuring time for Linear Search.
        startTimeLinearSearch = System.nanoTime();
        int indexPossitionLinear = LinearSearchAlgorithm.linearSearch(resultBooksSorted, bookNameToSearch.trim());
        // End measuring time for Linear Search.
        endTimeLinearSearch = System.nanoTime();

        // Step 3: Perform Binary Search on the sorted list of books.
        // Start measuring time for Binary Search.
        startTimeBinarySearch = System.nanoTime();
        BinarySearchAlgorithm.binarySearchAlgorithm(resultBooksSorted, bookNameToSearch.trim());
        // End measuring time for Binary Search.
        endTimeBinarySearch = System.nanoTime();

        // Step 4: Calculate the time taken for each search algorithm.
        durationLinearSearch = endTimeLinearSearch - startTimeLinearSearch; // Time for Linear Search.
        durationBinarySearch = endTimeBinarySearch - startTimeBinarySearch; // Time for Binary Search.
        durationBubbleSort = endTimeBubbleSort - startTimeBubbleSort; // Time for Linear Search.
        durationSelectionSort = endTimeSelectionSort - startTimeSelectionSort; // Time for Binary Search.

        // Step 5: Display the results of the search.
        if (indexPossitionLinear == -1) {
            // If the book was not found, display this message.
            System.out.println("The book could not be found!");
        } else {
            // If the book was found using Linear Search, display the details.
            System.out.println("    ✾ Search completed by LinearSearch and BinarySearch. Book found: " + bookNameToSearch);
            System.out.println("        -> Position: " + (indexPossitionLinear + 1) + " " + resultBooksSorted.get(indexPossitionLinear) + " - " + resultNumPagesSorted.get(indexPossitionLinear) + " pages");

            // Step 6: Display the time taken by each search method.
            System.out.println("        ->> Bubble Sort : " + durationBubbleSort + " nanosecs");
            System.out.println("        ->> Selection Sort : " + durationSelectionSort + " nanosecs");
            System.out.println("\n        ->> LinearSearch : " + durationLinearSearch + " nanosecs");
            System.out.println("        ->> BinarySearch : " + durationBinarySearch + " nanosecs");
        }

        // End of the search process.
        System.out.println("=========================  End Process  ===========================================");

        // Return to the main menu after the search is complete.
        CA_1.mainMenu(listBooks, numPages, mySc);
    }
}
