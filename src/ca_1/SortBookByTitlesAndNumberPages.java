/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_1;

/**
 *
 * @author jhane
 */
// Importing the ArrayList class to use dynamic arrays.
import java.util.ArrayList;

public class SortBookByTitlesAndNumberPages {

    // This method sorts books by the number of pages using Bubble Sort.
    public static ArrayList<Object> bubbleSortByNumPages(ArrayList<String> listBooks, ArrayList<Integer> numPages, String optionSortAscDescNum) {
        
        int i; // Variable for loop control.
        int n = numPages.size(); // Get the number of books (the size of numPages list).
        boolean swapped; // This will be true if a swap occurs in the list.
        boolean ascending = optionSortAscDescNum.equals("1"); // Set ascending to true if option is "1".

        do {
            swapped = false; // Start with no swaps.
            for (i = 1; i < n; i++) { // Loop through the list.
                // Compare the current number of pages with the previous one based on the sorting option.
                if ((ascending && numPages.get(i - 1).compareTo(numPages.get(i)) > 0) || 
                    (!ascending && numPages.get(i - 1).compareTo(numPages.get(i)) < 0)) {
                    
                    // Swap numPages elements if they are in the wrong order.
                    int tempNum = numPages.get(i - 1); // Store the first number of pages temporarily.
                    numPages.set(i - 1, numPages.get(i)); // Set the first number to the second number.
                    numPages.set(i, tempNum); // Set the second number to the temporary number.

                    // Swap corresponding book titles to maintain the correct order.
                    String tempTitle = listBooks.get(i - 1); // Store the first title temporarily.
                    listBooks.set(i - 1, listBooks.get(i)); // Set the first title to the second title.
                    listBooks.set(i, tempTitle); // Set the second title to the temporary title.

                    swapped = true; // Mark that a swap occurred.
                }
            }
            n--; // Decrease n to optimize the sorting by reducing the number of comparisons.
        } while (swapped); // Repeat until no swaps occur.

        // Create a list to hold the sorted books and page numbers.
        ArrayList<Object> result = new ArrayList<>();
        result.add(listBooks); // Add the sorted list of book titles.
        result.add(numPages); // Add the sorted list of page numbers.
        return result; // Return the result.
    }

    // This method sorts books by title using Bubble Sort.
    public static ArrayList<Object> bubbleSortByTitles(ArrayList<String> listBooks, ArrayList<Integer> numPages, String optionSortAscDescTitle) {
    
        int i; // Variable for loop control.
        int n = listBooks.size(); // Get the number of books (the size of listBooks).
        boolean swapped; // This will be true if a swap occurs in the list.
        boolean ascending = optionSortAscDescTitle.equals("1"); // Set ascending to true if option is "1".

        do {
            swapped = false; // Start with no swaps.
            for (i = 1; i < n; i++) { // Loop through the list.
                // Compare the current title with the previous one based on the sorting option.
                if ((ascending && listBooks.get(i - 1).compareTo(listBooks.get(i)) > 0) || 
                    (!ascending && listBooks.get(i - 1).compareTo(listBooks.get(i)) < 0)) {

                    // Swap corresponding book titles to maintain the correct order.
                    String tempTitle = listBooks.get(i - 1); // Store the first title temporarily.
                    listBooks.set(i - 1, listBooks.get(i)); // Set the first title to the second title.
                    listBooks.set(i, tempTitle); // Set the second title to the temporary title.

                    // Swap the corresponding page numbers.
                    int tempNum = numPages.get(i - 1); // Store the first number of pages temporarily.
                    numPages.set(i - 1, numPages.get(i)); // Set the first number to the second number.
                    numPages.set(i, tempNum); // Set the second number to the temporary number.

                    swapped = true; // Mark that a swap occurred.
                }
            }
            n--; // Decrease n to optimize the sorting by reducing the number of comparisons.
        } while (swapped); // Repeat until no swaps occur.

        // Create a list to hold the sorted books and page numbers.
        ArrayList<Object> result = new ArrayList<>();
        result.add(listBooks); // Add the sorted list of book titles.
        result.add(numPages); // Add the sorted list of page numbers.
        return result; // Return the result.
    } 

    // This method sorts books by the number of pages using Selection Sort.
    public static ArrayList<Object> selectionSortByNumPages(ArrayList<String> listBooks, ArrayList<Integer> numPages, String optionSortAscDescNum) {
        
        boolean ascending = optionSortAscDescNum.equals("1"); // Set ascending to true if option is "1".
        int n = numPages.size(); // Get the number of books.

        for (int i = 0; i < n - 1; i++) { // Loop through the list for each book.
            int index = i; // Start with the current index as the minimum or maximum.

            for (int j = i + 1; j < n; j++) { // Check all other elements after the current index.
                // For ascending order, find the smallest element; for descending, find the largest.
                if ((ascending && numPages.get(j).compareTo(numPages.get(index)) < 0) || 
                    (!ascending && numPages.get(j).compareTo(numPages.get(index)) > 0)) {
                    index = j; // Update the index if a smaller or larger element is found.
                }
            }

            // Swap the elements in numPages if needed.
            if (index != i) {
                int tempNum = numPages.get(i); // Store the current number temporarily.
                numPages.set(i, numPages.get(index)); // Set the current number to the number at the index found.
                numPages.set(index, tempNum); // Set the number at the index to the temporary number.

                // Swap the corresponding elements in listBooks.
                String tempTitle = listBooks.get(i); // Store the current title temporarily.
                listBooks.set(i, listBooks.get(index)); // Set the current title to the title at the index found.
                listBooks.set(index, tempTitle); // Set the title at the index to the temporary title.
            }
        }

        // Create a list to hold the sorted books and page numbers.
        ArrayList<Object> result = new ArrayList<>();
        result.add(listBooks); // Add the sorted list of book titles.
        result.add(numPages); // Add the sorted list of page numbers.
        return result; // Return the result.
    }
    
    // This method sorts books by title using Selection Sort.
    public static ArrayList<Object> selectionSortByTitles(ArrayList<String> listBooks, ArrayList<Integer> numPages, String optionSortAscDescTitle) {
        
        boolean ascending = optionSortAscDescTitle.equals("1"); // Set ascending to true if option is "1".
        int n = listBooks.size(); // Get the number of books.

        for (int i = 0; i < n - 1; i++) { // Loop through the list for each book.
            int index = i; // Start with the current index as the minimum or maximum.

            for (int j = i + 1; j < n; j++) { // Check all other elements after the current index.
                // For ascending order, find the smallest element; for descending, find the largest.
                if ((ascending && listBooks.get(j).compareTo(listBooks.get(index)) < 0) || 
                    (!ascending && listBooks.get(j).compareTo(listBooks.get(index)) > 0)) {
                    index = j; // Update the index if a smaller or larger element is found.
                }
            }

            // Swap the elements in numPages if needed.
            if (index != i) {
                // Swap the corresponding elements in listBooks.
                String tempTitle = listBooks.get(i); // Store the current title temporarily.
                listBooks.set(i, listBooks.get(index)); // Set the current title to the title at the index found.
                listBooks.set(index, tempTitle); // Set the title at the index to the temporary title.
                
                int tempNum = numPages.get(i); // Store the current number temporarily.
                numPages.set(i, numPages.get(index)); // Set the current number to the number at the index found.
                numPages.set(index, tempNum); // Set the number at the index to the temporary number.
            }
        }

        // Create a list to hold the sorted books and page numbers.
        ArrayList<Object> result = new ArrayList<>();
        result.add(listBooks); // Add the sorted list of book titles.
        result.add(numPages); // Add the sorted list of page numbers.
        return result; // Return the result.
    }

    // This method displays the sorted lists of book titles and their number of pages.
    public static void displayArrayListSortByNumPages(ArrayList<String> listBooks, ArrayList<Integer> numPages) {
        
        // Print end message after displaying all books.
        System.out.println("    ✾ -------> Start List  ---------------------------------------------");
        // Loop through the sorted list of books and print each title with its number of pages.
        for (int i = 0; i < listBooks.size(); i++) {
            System.out.println("        |" + (i + 1) + " | " + listBooks.get(i) + "    | " + numPages.get(i) + " pages");
        }
        // Print end message after displaying all books.
        System.out.println("    ✾ -------> End List  ---------------------------------------------");
    }
}
