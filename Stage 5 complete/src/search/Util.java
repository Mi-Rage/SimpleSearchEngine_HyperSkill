package search;

import java.util.List;
import java.util.Scanner;

public class Util {

    static Scanner scanner = new Scanner(System.in);

    public static String getQueryWord() {
        System.out.println("\nEnter a name or email to search all suitable people.");
        String result = scanner.nextLine();
        System.out.println();
        return result;
    }

    public static void printResult(List<DataModel> storage, List<Integer> resultIndex) {
        if (resultIndex.size() > 0) {
            System.out.printf("%d persons found:\n", resultIndex.size());
            for (Integer each : resultIndex) {
                System.out.println(storage.get(each).getDataLine());
            }
        } else {
            System.out.println("No matching people found.");
        }
        System.out.println();
    }

    public static void printResult(List<DataModel> storage) {
        System.out.println("\n=== List of people ===");
        for (DataModel each : storage) {
            System.out.println(each.getDataLine());
        }
    }

}
