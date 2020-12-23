package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

    private List<DataModel> storage = new ArrayList<>();
    private Map<String, List<Integer>> invertedIndex = new HashMap<>();

    public Repository() {
    }

    public List<DataModel> getStorage() {
        return storage;
    }

    public void setStorage(List<DataModel> storage) {
        this.storage = storage;
    }

    public Map<String, List<Integer>> getInvertedIndex() {
        return invertedIndex;
    }

    public void setInvertedIndex(Map<String, List<Integer>> invertedIndex) {
        this.invertedIndex = invertedIndex;
    }
}
