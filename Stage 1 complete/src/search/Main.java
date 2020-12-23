package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] searchHere = scanner.nextLine().split(" ");
        String keyWord = scanner.nextLine();
        int index = 0;
        for (int i = 0; i < searchHere.length; i++) {
            if(keyWord.equals(searchHere[i])) {
                index = i + 1;
                break;
            }
        }
        if (index != 0) {
            System.out.println(index);
        } else {
            System.out.println("Not Found");
        }
    }
}
