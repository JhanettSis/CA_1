

package ca_1;  

// This imports the ArrayList class, which helps store a list of items.
import java.util.ArrayList;  
// This imports the Scanner class, which helps take input from the user.
import java.util.Scanner;    

/**
 *
 * @author jhane
 */
public class CA_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // This creates a Scanner object to read input from the keyboard.
        Scanner mySc = new Scanner(System.in);
        // This boolean variable checks if the user wants to exit the program.
        boolean exit = false;
        // This string will have the name of the file entered by the user.
        String fileName = "";
        // This string will have the user's choice to exit or not.
        String wantToExit = "";

        // This while loop will keep running until 'exit' is true.
        while (!exit) {
            
            System.out.println("☸☸==================☸☸  Menu  ☸☸==================☸☸");
            // Shows a menu header to the user.
            // Asks the user to input the name of the file to read.
            System.out.println("  ❖ Please enter the full path to your file");
            System.out.println("     (e.g., C:/Users/username/Downloads/MOCK_DATA.txt). ");
            System.out.println("     Make sure to include the drive letter and all folders leading to your file.");
            
            System.out.print("  ❖ Please insert the name of the file to read: ");
            // Reads the file name from the user's input.
            fileName = mySc.nextLine();

            // Calls a method to read the file and return the data in an ArrayList.
            ArrayList<Object> data = FillOutArrays.setFile(fileName);

            // This checks if the data is not empty.
            if (!data.isEmpty()) {
                // Gets the list of books (strings) from the data (the first item in the list).
                ArrayList<String> listBooks = (ArrayList<String>) data.get(0);
                
                // Gets the list of page numbers (integers) from the data (the second item in the list).
                ArrayList<Integer> numPages = (ArrayList<Integer>) data.get(1);
                
                // Displays the list of books and their corresponding page numbers.
                FillOutArrays.displayArrayList(listBooks, numPages);

                // Calls the main menu method to let the user choose sorting or searching options.
                mainMenu(listBooks, numPages, mySc);
            }

            // Asks the user if they want to exit the program.
            System.out.println("    \n❖ Do you want to exit? (Press 'yes' to exit!)");
            System.out.println("    ❖ Otherwise press any key!");
            // Reads the user's input (either 'yes' to exit or any other key to continue).
            wantToExit = mySc.nextLine();
            // If the user types 'yes', the exit option is set to true, and the loop will end.
            if (wantToExit.equalsIgnoreCase("yes")) {
                exit = true;
            }
        }
        // Closes the Scanner object to free system resources (it's good practice).
        mySc.close();
    }

    // This method handles the main menu where the user can choose to sort or search.
    // and this method is reciving the ArrayList listBook and numPages And the variable of Scanner.
    public static void mainMenu(ArrayList<String> listBooks, ArrayList<Integer> numPages, Scanner mySc) {

        // Creates an object to handle sorting operations in the menu.
        SectionOfMenuSort sectionMenuSort = new SectionOfMenuSort(mySc);
        // Creates an object to handle searching operations in the menu.
        SectionOfMenuSearch sectionMenuSearch = new SectionOfMenuSearch(mySc);
        
        // This boolean variable ensures the user selects a valid option.
        boolean validOption = false;
        // This string will store the user's choice from the menu.
        String optionMenu = "";

        // This loop keeps running until the user selects a valid option.
        while (!validOption) {

            // Asks the user to choose between sorting, searching, or exiting.
            System.out.println("\n    ❖ Do you wish to SORT or SEARCH? ");
            System.out.println("     ➸ SORT(Press 1): ");
            System.out.println("     ➸ SEARCH(Press 2): ");
            System.out.println("     ➸ Do you want to exit? (press yes)");
            // Reads the user's choice from the input.
            optionMenu = mySc.nextLine();

            // This switch case checks the user's input and performs the appropriate action.
            switch (optionMenu) {
                // If the user presses "1", it calls the method to sort the data.
                case "1":
                    // Calls the method to show the sorting options.
                    sectionMenuSort.sortMenu(listBooks, numPages, mySc);
                    // Sets validOption to true, meaning the option was valid.
                    validOption = true;
                    break;
                // If the user presses "2", it calls the method to search the data.
                case "2":
                    // Calls the method to show the searching options.
                    sectionMenuSearch.searchMenu(listBooks, numPages, mySc);
                    // Sets validOption to true, meaning the option was valid.
                    validOption = true;
                    break;
                // If the user types "yes", the program will exit.
                case "yes":
                    // Prints a message to let the user know the program is ending.
                    System.out.println("    ✾ The program is over!");
                    // Exits the program.
                    System.exit(0);
                    break;
                // This default case happens if the user enters an invalid option.
                default:
                    // Tells the user to press a valid number for the option.
                    System.out.println("    ✾ Press the number of Option!");
                    // validOption is set to false, so the loop continues.
                    validOption = false;
                    break;
            }
        }
    }
}
