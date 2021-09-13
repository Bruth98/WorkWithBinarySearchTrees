/*
Written by Brady Ruth
 */
import java.util.*;
import java.io.*;

public class FruitTreeTester {
    public static void main(String[] args) {
        System.out.println("Welcome to the fruit tree!\nPlease enter a Fruit File Name.");
        Scanner keyboard = new Scanner(System.in);
        String fileName = keyboard.nextLine();
        System.out.println("Populating tree file");

        LinkedBST<Fruit> fruitTree = new LinkedBST<Fruit>();
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine()) {
                String currLine = fileScanner.nextLine();
                String[] splitLine = currLine.split("\t");
                if (splitLine.length == 2) {
                    Fruit f = new Fruit(Double.parseDouble(splitLine[1]), splitLine[0]); //Weight is at index 1, not 0
                    fruitTree.add(f);
                }
            }
            fileScanner.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("Printing the in-order traversal");
        fruitTree.printInorder();
        System.out.println("\nPrinting the pre-order traversal");
        fruitTree.printPreorder();
        System.out.println("\nPrinting the post-order traversal");
        fruitTree.printPostorder();
        System.out.println(fruitTree.search(new Fruit(0.4859853412170728, "Apple")));//Removing a specific fruit
        System.out.println(("\nDeleting Apple   0.4859853412170728"));
        fruitTree.remove(new Fruit(0.4859853412170728, "Apple"));
        System.out.println("\nPrinting in-order traversal");
        fruitTree.printInorder();
    }
}
