package search;

import java.util.List;
import java.util.Scanner;

public class Util {

    static Scanner scanner = new Scanner(System.in);

    public static int getQueriesNumber() {
        System.out.println("Enter the number of search people:");
        int result = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return result;
    }

    public static String getQueryWord() {
        System.out.println("Enter data to search people:");
        String result = scanner.nextLine();
        System.out.println();
        return result;
    }

    public static void printResult(List<DataModel> storage, List<Integer> resultIndex) {
        if (resultIndex.size() > 0) {
            System.out.println("Found people:");
            for(Integer each: resultIndex) {
                System.out.println(storage.get(each).getDataLine());
            }
        } else {
            System.out.println("No matching data found.");
        }
        System.out.println();
    }

    public static int getNumberOfPeople() {
        System.out.println("Enter the number of people:");
        return Integer.parseInt(scanner.nextLine());
    }

}
