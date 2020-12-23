package search;

import java.util.Scanner;

public class UserInterface {

    public Scanner scanner = new Scanner(System.in);
    private final String[] source;

    public UserInterface(String[] source) {
        this.source = source;
    }

    public void start() {
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.initRepository(source);
        int option;
        do {
            option = choiceMainMenu();
            switch (option) {
                case 1:
                    searchEngine.searchingData();
                    break;
                case 2:
                    searchEngine.printAllData();
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
            }
        } while (option != 0);
    }

    public int choiceMainMenu() {
        int option;
        do {
            System.out.println("=== Menu ===\n" +
                    "1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit");
            option = Integer.parseInt(scanner.nextLine());
            if (option < 0 || option > 2) {
                System.out.println("Incorrect option! Try again.\n");
            }
        } while (option < 0 || option > 2);
        return option;
    }
}
