package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SearchEngine {

    public final String SEPARATOR = " ";
    private final Repository repository = new Repository();

    public void initRepository(String[] source) {
        String fileName = source[1];
        List<DataModel> storage = repository.getStorage();

        File file = new File(fileName);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                DataModel dataModel = new DataModel();
                dataModel.setDataLine(fileScanner.nextLine());
                storage.add(dataModel);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + fileName);
        }

        repository.setStorage(storage);
        System.out.println();
    }

    public void searchingData() {

        List<DataModel> storage = repository.getStorage();

        String queryWord = Util.getQueryWord();
        List<Integer> resultIndex = new ArrayList<>();
        for (int i = 0; i < storage.size(); i++) {
            DataModel dataModel = storage.get(i);
            if (processSearching(dataModel, queryWord)) {
                resultIndex.add(i);
            }
        }
        Util.printResult(storage, resultIndex);
    }

    private boolean processSearching(DataModel dataModel, String queryWord) {
        String[] content = dataModel.getDataLine().toLowerCase(Locale.ROOT).split(SEPARATOR);
        for (String each : content) {
            if (each.contains(queryWord.toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

    public void printAllData() {
        List<DataModel> storage = repository.getStorage();
        Util.printResult(storage);
    }
}
