// Name: Dr. Jonathan Cazalas
// Date: 9/13/2023
// Introduction to Recursion...

import java.util.*;

public class RecursionDemo {

    static void showMenu() {
        System.out.println("\n|-----------------------------------------------|");
        System.out.println("|------          Recursion Menu           ------|");
        System.out.println("|-----------------------------------------------|");
        System.out.println("|   1.  Infinite WHILE loop (no recursion)      |");
        System.out.println("|   2.  Recursion without stopping case         |");
        System.out.println("|   3.  Countdown (Iterative)                   |");
        System.out.println("|   4.  Countdown (Recursive)                   |");
        System.out.println("|   5.  Factorial                               |");
        System.out.println("|   6.  Bunny Ears                              |");
        System.out.println("|   7.  Fibonacci                               |");
        System.out.println("|   8.  Count X                                 |");
        System.out.println("|   9.  All Star                                |");
        System.out.println("|   10  Quit                                    |");
        System.out.println("|-----------------------------------------------|\n");
    }

    static void infiniteLoop() {
        int count = 1;
        while (true) {
            System.out.printf("%d: This, ummm, yeah, will never stop!!!\n", count++);
        }
    }

    static void infiniteRecursion(int n) {
        System.out.printf("%d: This message will print - in theory - and infinite number of times.\n", n);
        infiniteRecursion(n + 1);
    }

    static void countDownIterative(int count) {
        for (int i = count; i > 0; i--) {
            System.out.printf("%d! ", i);
        }
        System.out.println("\nBlast Off!!!");
    }

    static void countDownRecursive(int n) {
        if (n > 0) {
            System.out.printf("%d! ", n);
            countDownRecursive(n - 1);
        }
        else {
            System.out.println("\nBlast Off!!!");
        }
    }

    //      n! = n * (n - 1)!
    // fact(n) = n * fact(n - 1)
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        else {
            return n * fact(n - 1);
        }
    }

    // bE(8) = 2 + be(7)
    // be(n) = 2 + be(n - 1)
    static int bunnyEars(int numBunnies) {
        // IF we have NO bunnies
        if (numBunnies == 0) {
            return 0;
        }
        else {
            return 2 + bunnyEars(numBunnies - 1);
        }
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    
    //
    public static int countX(String s) {
        return 1; // delete this line of code...it's only here to fulfill the method contract (to return an int)
    }
    
    public static String allStar(String s) {
        return ""; // delete this line of code...it's only here to fulfill the method contract (to return a String)
    }

    // readAndVerifyMenuChoice()
    // Parameters:  Scanner
    // Return type: int
    // Description: reads and verifies user input as a valid menu selection
    //              method returns user selection as an int once verified
    // -------
    public static int readAndVerifyMenuChoice(Scanner in) {
        String inputLine;
        int choice;

        while (true) {
            System.out.print("> Please enter your choice: ");
            inputLine = in.nextLine();

            if ((inputLine.length() == 1 && Character.isDigit(inputLine.charAt(0))) || (inputLine.length() == 2 && Character.isDigit(inputLine.charAt(0)) && Character.isDigit(inputLine.charAt(1)))) {
                choice = Integer.parseInt(inputLine);
                if (choice >= 1 && choice <= 12) {
                    return choice;
                }
                else {
                    System.out.println("\n   ERROR: invalid input. You must integer a valid integer selection from the menu.\n");
                }
            }
            else {
                System.out.println("\n   ERROR: invalid input. You must integer a valid integer selection from the menu.\n");
            }
        }
    }

    // readAndVerifyYNchoice()
    // Parameters:  Scanner
    // Return type: char
    // Description: reads and verifies user input as a valid choice (Y or N)
    //              method returns user selection as a char once verified
    // -------
    public static char readAndVerifyYNchoice(Scanner in) {
        String inputLine;

        while (true) {
            System.out.print("> Are you sure??? (Y/N): ");
            inputLine = in.nextLine();

            if (inputLine.equalsIgnoreCase("y") || inputLine.equalsIgnoreCase("n")) {
                return inputLine.toUpperCase().charAt(0); // returns choice is an uppercase character
            }
            else {
                System.out.println("\n   ERROR: invalid input. You must enter \"Y\" or \"N\".\n");
            }
        }
    }

    //**************************************************************************//
    //**********                         MAIN                         **********//
    //**************************************************************************//
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int userChoice;
        char ynChoice;

        do {
            showMenu();
            userChoice = readAndVerifyMenuChoice(in);

            if (userChoice == 1) {
                ynChoice = readAndVerifyYNchoice(in);
                if (ynChoice == 'Y' || ynChoice == 'y') {
                    System.out.println("> Your call. Press enter for endless fun...");

                    // Just pausing execution...waiting for user to press "Enter", which we then consume
                    in.nextLine();
                    infiniteLoop();
                }
                else {
                    System.out.println("> Smart choice. Who really wants to run an infinite loop anyway.?.");
                }
            }
            else if (userChoice == 2) {
                ynChoice = readAndVerifyYNchoice(in);
                if (ynChoice == 'Y' || ynChoice == 'y') {
                    System.out.println("> Your call. Press enter for \"endless\" fun...although, bummer, it does end...");

                    // Just pausing execution...waiting for user to press "Enter", which we then consume
                    in.nextLine();
                    infiniteRecursion(1);
                }
                else {
                    System.out.println("> Smart choice. Who really wants to run an infinite loop anyway.?.");
                }
            }
            // Count Down (Iterative)
            else if (userChoice == 3) {
                countDownIterative(10);
            }
            // Count Down (Recursive)
            else if (userChoice == 4) {
                countDownRecursive(10);
            }
            // Factorial
            else if (userChoice == 5) {
                System.out.println("\nFACTORIAL");
                System.out.printf("   Enter an integer: ");
                int num = Integer.parseInt(in.nextLine());
                System.out.printf("   The fact of %d is %d.\n\n", num, fact(num));
            }
            // Bunny Ears
            else if (userChoice == 6) {
                System.out.println("\nBUNNY EARS");
                System.out.printf("   Enter the number of bunnies in the line: ");
                int numBunnies = Integer.parseInt(in.nextLine());
                System.out.printf("   Given %d bunnies, the number of bunny ears is %d.\n\n", numBunnies, bunnyEars(numBunnies));
            }
            // Fibonacci
            else if (userChoice == 7) {
                System.out.println("\nFACTORIAL");
                System.out.printf("   Which Fibonacci number do you want? ");
                int num = Integer.parseInt(in.nextLine());
                System.out.printf("   fib(%d) is %d.\n\n", num, fib(num));
            }
            // Fibonacci
            else if (userChoice == 8) {
                System.out.println("\nCOUNT X");
                System.out.print("   Enter a String with multiple x's (or no x's): ");
                String someString = in.nextLine();
                System.out.printf("   The number of x's in %s is %d.\n\n", someString, countX(someString));
            }
            // Fibonacci
            else if (userChoice == 9) {
                System.out.println("\nALL STAR");
                System.out.printf("   Enter a String of text with no spaces: ");
                String someString = in.nextLine();
                System.out.printf("   Here is the new String: %s\n\n", allStar(someString));
            }
            // Quit...
            else if (userChoice == 10) {
                System.out.println("Goodbye!");
                break;
            }
            else {
                // Per the readAndVerifyMenuChoice() method...this ELSE option will NEVER happen
                System.out.println("\nInvalid Selection. Please try again.\n");
            }

        } while (true);

        // close Scanner
        in.close();

    } // END main()
}
