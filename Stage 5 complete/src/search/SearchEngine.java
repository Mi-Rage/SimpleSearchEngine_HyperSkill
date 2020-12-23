package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SearchEngine {

    public final String SEPARATOR = " ";
    private final Repository repository = new Repository();

    public void initRepository(String[] source) {
        String fileName = source[1];
        List<DataModel> storage = repository.getStorage();
        Map<String, List<Integer>> invertedIndex = repository.getInvertedIndex();

        File file = new File(fileName);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                DataModel dataModel = new DataModel();
                dataModel.setDataLine(fileScanner.nextLine());
                storage.add(dataModel);
                String[] content = dataModel.getDataLine()
                        .toLowerCase(Locale.ROOT)
                        .split(SEPARATOR);
                for (String eachContent : content) {
                    List<Integer> indexes = new ArrayList<>();
                    if (invertedIndex.containsKey(eachContent)) {
                        indexes = invertedIndex.get(eachContent);
                        indexes.add(storage.size() - 1);
                    } else {
                        indexes.add(storage.size() - 1);
                        invertedIndex.put(eachContent, indexes);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + fileName);
        }

        repository.setStorage(storage);
        repository.setInvertedIndex(invertedIndex);

        System.out.println();
    }

    public void searchingData() {

        List<DataModel> storage = repository.getStorage();
        Map<String, List<Integer>> invertedIndex = repository.getInvertedIndex();

        String queryWord = Util.getQueryWord().toLowerCase(Locale.ROOT);
        List<Integer> resultIndex = new ArrayList<>();
        if (invertedIndex.containsKey(queryWord)) {
            resultIndex = invertedIndex.get(queryWord);
        }

        Util.printResult(storage, resultIndex);
    }

    public void printAllData() {
        List<DataModel> storage = repository.getStorage();
        Util.printResult(storage);
    }
}
