package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SearchEngine {

    public Scanner scanner = new Scanner(System.in);
    public final String SEPARATOR = " ";
    private final Repository repository = new Repository();

    public void run() {
        initRepository();
        searchingData();

    }

    private void initRepository() {
        int number = Util.getNumberOfPeople();
        System.out.println("Enter all people:");
        List<DataModel> storage = repository.getStorage();
        for (int i = 0; i < number; i++) {
            DataModel dataModel = new DataModel();
            dataModel.setDataLine(scanner.nextLine());
            storage.add(dataModel);
        }
        repository.setStorage(storage);
        System.out.println();
    }

    private void searchingData() {
        int queryNumber = Util.getQueriesNumber();

        List<DataModel> storage = repository.getStorage();

        for (int j = 0; j < queryNumber; j++) {
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
    }

    private boolean processSearching(DataModel dataModel, String queryWord) {
        String[] content = dataModel.getDataLine().toLowerCase(Locale.ROOT).split(SEPARATOR);
        for (String each : content) {
            if(each.contains(queryWord.toLowerCase(Locale.ROOT))){
                return true;
            }
        }
        return false;
    }
}
