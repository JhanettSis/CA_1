

package ca_1;

/**
 *
 * @author jhane
 */
// This imports the File class, which allows us to open and work with files.
import java.io.File;  
// This imports the exception used if the file is not found.
import java.io.FileNotFoundException; 
// This imports the ArrayList class, used to store lists of items.
import java.util.ArrayList;
// This imports the Scanner class, used to read input from files and users.
import java.util.Scanner;  

public class FillOutArrays {

    // This method reads a file and fills two ArrayLists with book titles and page numbers.
    public static ArrayList<Object> setFile(String fileName) {
        // Create an ArrayList to store book titles.
        ArrayList<String> listBooks = new ArrayList<>();
        // Create an ArrayList to store page numbers of the books.
        ArrayList<Integer> numPages = new ArrayList<>();
        // Create an ArrayList to store both lists (titles and page numbers) together.
        ArrayList<Object> result = new ArrayList<>();
        
        try {
            // Create a Scanner to read the file, using the file name passed as a parameter.
            Scanner myFileReadSc = new Scanner(new File(fileName));
            // Variable to store each line read from the file.
            String line = "";

            // This loop runs while there are more lines to read in the file.
            while (myFileReadSc.hasNextLine()) {
                // Reads the next line from the file.
                line = myFileReadSc.nextLine();

                // Find the last comma in the line (used to separate the book title and page number).
                int lastCommaIndex = line.lastIndexOf(",");
                // If a comma is found, process the line.
                if (lastCommaIndex != -1) {
                    // Extract the part after the comma (the page number) and remove any extra spaces.
                    String numberPart = line.substring(lastCommaIndex + 1).trim();
                    // Extract the part before the comma (the book title) and remove any extra spaces.
                    String titlePart = line.substring(0, lastCommaIndex).trim();

                    try {
                        // Convert the page number from a string to an integer.
                        int pages = Integer.parseInt(numberPart);
                        // Add the book title to the list of books.
                        listBooks.add(titlePart);
                        // Add the page number to the list of page numbers.
                        numPages.add(pages);
                    } catch (NumberFormatException e) {
                        // If the number cannot be converted, print a message and skip the line.
                        System.out.println("Skipping invalid line (invalid number): " + line);
                    }
                } else {
                    // If no comma is found in the line, print a message and skip the line.
                    System.out.println("Skipping invalid line (no comma found): " + line);
                }
            }

            // Add the list of books to the result ArrayList.
            result.add(listBooks);
            // Add the list of page numbers to the result ArrayList.
            result.add(numPages);
        
        } catch (FileNotFoundException e) {
            // If the file is not found, print an error message with the details.
            System.out.println("File not found: " + e.getMessage());
        }
        
        // Return the result, which contains both the book titles and page numbers.
        return result;
    }

    // This method displays the first 5 books and their page numbers.
    public static void displayArrayList(ArrayList<String> listBooks, ArrayList<Integer> numPages) {
        // Prints a decorative line for displaying the books.
        System.out.println("    ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ✾ ");
        System.out.println("    ✾ Displaying up to 5 book titles and pages:");
        // This loop runs for the first 5 books and shows their titles and page numbers.
        for (int i = 0; i < 5; i++) {
            // Prints each book's number in the list, the title, and the page count.
            System.out.println("        ->" + (i+1) + " " + listBooks.get(i) + " - " + numPages.get(i) + " pages");
        }
        // Tells the user there are more books if they exist.
        System.out.println("    ✾ -------> There are more ... ");
    }
}
