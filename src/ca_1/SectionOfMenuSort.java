/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_1;

/**
 *
 * @author jhane
 */
// Imports ArrayList to store book titles and page numbers.
import java.util.ArrayList; 
// Imports Scanner to read input from the user.
import java.util.Scanner; 

public class SectionOfMenuSort {

    // Private Scanner object to read user input.
    private Scanner mySc;
    
    // Two ArrayLists to store sorted book titles and sorted page numbers.
    private ArrayList<String> listBooksSort = new ArrayList<>();
    private ArrayList<Integer> numPagesSort = new ArrayList<>();
      
    // Constructor to initialize the Scanner object with the one passed from the main program.
    public SectionOfMenuSort(Scanner mySc) {
        this.mySc = mySc;
    }
    
    // Method to display the sort menu and handle user choices for sorting.
    public void sortMenu(ArrayList<String> listBooks, ArrayList<Integer> numPages, Scanner mySc) {
        String optionSubMenuSort = ""; // Stores the user's menu choice.
        boolean validOption = false; // Flag to check if the option is valid.

        // Loop to keep asking the user for valid input until they choose a valid option.
        while (!validOption) {
            System.out.println("    ❖ Please enter your sorting choice!");
            System.out.println("     ➸ Sort by book title (Press 1): ");
            System.out.println("     ➸ Sort by number of pages (Press 2): ");
            
            // Reads the user's input.
            optionSubMenuSort = mySc.nextLine();
            
            // Switch statement to handle user choice.
            switch (optionSubMenuSort) {
                case "1":
                    System.out.println("    ✾ SORT selected by Book Title");
                    // Calls the method to sort by title.
                    sortByTitle(listBooks, numPages, mySc);
                    validOption = true; // Valid option, so exit loop.
                    break;
                case "2":
                    System.out.println("    ✾ SORT selected by number of pages");
                    // Calls the method to sort by page number.
                    sortByNumberPages(listBooks, numPages, mySc);
                    validOption = true; // Valid option, so exit loop.
                    break;
                default:
                    // If the user input is invalid, prompt them again.
                    System.out.println("    ✾ Invalid choice. Returning to main menu.");
                    validOption = false; // Invalid option, continue loop.
                    break;
            }    
        }
    }
    
    // Method to sort books by title, with ascending or descending options.
    private void sortByTitle(ArrayList<String> listBooks, ArrayList<Integer> numPages, Scanner mySc) {
        String optionSortAscDescTitle = ""; // User's choice for ascending or descending.
        String typeOfSorted = ""; // Stores the type of sorting (asc/desc).
        boolean validOption = false; // Flag to check valid input.

        // Loop to ensure user inputs a valid sorting order.
        while (!validOption) {
            System.out.println("    ❖ Enter Ascending or Descending sort order Title:");
            System.out.println("     ➸ Ascending A-Z (Press 1): ");
            System.out.println("     ➸ Descending Z-A (Press 2): ");
            
            // Reads the user's choice for sort order.
            optionSortAscDescTitle = mySc.nextLine();
            
            // Switch to handle ascending or descending sorting.
            switch (optionSortAscDescTitle) {
                case "1":
                    typeOfSorted = "TitlesAsc"; // Sets type for ascending sorting.
                    // Calls method to sort and display the sorted books by title.
                    sortAndDisplayBooks(listBooks, numPages, optionSortAscDescTitle, typeOfSorted);
                    validOption = true; // Valid option, exit loop.
                    break;
                case "2":
                    typeOfSorted = "TitlesDesc"; // Sets type for descending sorting.
                    // Calls method to sort and display the sorted books by title.
                    sortAndDisplayBooks(listBooks, numPages, optionSortAscDescTitle, typeOfSorted);
                    validOption = true; // Valid option, exit loop.
                    break;
                default:
                    // If input is invalid, prompt the user again.
                    System.out.println("    ✾ Invalid choice. Returning to sort menu.");
                    validOption = false; // Invalid option, continue loop.
                    break;
            }    
        }

        // Clear the sorted ArrayLists after sorting and displaying.
        listBooksSort.clear();
        numPagesSort.clear();
    }
    
    // Method to sort books by the number of pages.
    private void sortByNumberPages(ArrayList<String> listBooks, ArrayList<Integer> numPages, Scanner mySc) {
        String optionSortAscDescNum = ""; // User's choice for ascending or descending sorting.
        String typeOfSorted = ""; // Stores the type of sorting (asc/desc).
        boolean validOption = false; // Flag to check valid input.

        // Loop to ensure valid input from the user.
        while (!validOption) {
            System.out.println("    ❖ Enter Ascending or Descending sort order Pages ");
            System.out.println("     ➸ Ascending 0-9 (Press 1): ");
            System.out.println("     ➸ Descending 9-0 (Press 2): ");
            
            // Reads the user's choice.
            optionSortAscDescNum = mySc.nextLine();
            
            // Switch to handle ascending or descending sorting.
            switch (optionSortAscDescNum) {
                case "1":
                    typeOfSorted = "numPagesAsc"; // Sets type for ascending sorting.
                    // Calls method to sort and display the sorted books by number of pages.
                    sortAndDisplayBooks(listBooks, numPages, optionSortAscDescNum, typeOfSorted);
                    validOption = true; // Valid option, exit loop.
                    break;
                case "2":
                    typeOfSorted = "numPagesDesc"; // Sets type for descending sorting.
                    // Calls method to sort and display the sorted books by number of pages.
                    sortAndDisplayBooks(listBooks, numPages, optionSortAscDescNum, typeOfSorted);
                    validOption = true; // Valid option, exit loop.
                    break;
                default:
                    // If input is invalid, prompt the user again.
                    System.out.println("    ✾ Invalid choice. Returning to sort menu.");
                    validOption = false; // Invalid option, continue loop.
                    break;
            }    
        }

        // Clear the sorted ArrayLists after sorting and displaying.
        listBooksSort.clear();
        numPagesSort.clear();
    }

    // Method to sort and display books, also calculates time taken by sorting algorithms.
    public void sortAndDisplayBooks(ArrayList<String> listBooks, ArrayList<Integer> numPages, String optionSortAscDesc, String typeOfSorted) {
        long startTimeBubbleSort, endTimeBubbleSort, durationBubbleSort; // Variables to measure Bubble Sort time.
        long startTimeSelectionSort, endTimeSelectionSort, durationSelectionSort; // Variables to measure Selection Sort time.
        ArrayList<Object> dataResult; // To store the sorted data result.

        // Switch to select the correct sorting method based on the type.
        switch (typeOfSorted) {
            case "TitlesAsc":
            case "TitlesDesc":
                // Measure the start and end time for Bubble Sort by titles.
                startTimeBubbleSort = System.nanoTime();
                dataResult = SortBookByTitlesAndNumberPages.bubbleSortByTitles(listBooks, numPages, optionSortAscDesc);
                endTimeBubbleSort = System.nanoTime();
                
                // Measure the start and end time for Selection Sort by titles.
                startTimeSelectionSort = System.nanoTime();
                SortBookByTitlesAndNumberPages.selectionSortByTitles(listBooks, numPages, optionSortAscDesc);
                endTimeSelectionSort = System.nanoTime();
                break;

            case "numPagesAsc":
            case "numPagesDesc":
                // Measure the start and end time for Bubble Sort by number of pages.
                startTimeBubbleSort = System.nanoTime();
                dataResult = SortBookByTitlesAndNumberPages.bubbleSortByNumPages(listBooks, numPages, optionSortAscDesc);
                endTimeBubbleSort = System.nanoTime();
                
                // Measure the start and end time for Selection Sort by number of pages.
                startTimeSelectionSort = System.nanoTime();
                SortBookByTitlesAndNumberPages.selectionSortByNumPages(listBooks, numPages, optionSortAscDesc);
                endTimeSelectionSort = System.nanoTime();
                break;

            default:
                System.out.println("Invalid sort type.");
                return; // Exit if the typeOfSorted is invalid.
        }

        // Calculate the duration of each sort (in nanoseconds).
        durationBubbleSort = endTimeBubbleSort - startTimeBubbleSort;
        durationSelectionSort = endTimeSelectionSort - startTimeSelectionSort;

        // Display the sorted list based on the sorting type.
        System.out.println("    ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ");
        if (typeOfSorted.startsWith("Titles")) {
            System.out.println("    ✾ Displaying list book Sorted by Title - " + (typeOfSorted.endsWith("Asc") ? "Ascending" : "Descending") + ":");
            listBooksSort = (ArrayList<String>) dataResult.get(0); // Get the sorted titles.
            numPagesSort = (ArrayList<Integer>) dataResult.get(1); // Get the sorted pages.
        } else {
            
            System.out.println("\n    ✾ Displaying list book Sorted by number of pages - " + (typeOfSorted.endsWith("Asc") ? "Ascending" : "Descending") + ":");
            listBooksSort = (ArrayList<String>) dataResult.get(0); // Get the sorted titles.
            numPagesSort = (ArrayList<Integer>) dataResult.get(1); // Get the sorted pages.
        }

        // Call method to display the sorted books.
        SortBookByTitlesAndNumberPages.displayArrayListSortByNumPages(listBooksSort, numPagesSort);

        // Display the time taken for each sorting method.
        System.out.println("\n    ✾ Time takes BubbleSort : " + durationBubbleSort + " nanosecs");
        System.out.println("    ✾ Time takes SelectionSort : " + durationSelectionSort + " nanosecs");

        // Return to the main menu after sorting.
        CA_1.mainMenu(listBooks, numPages, mySc);
    }
}
