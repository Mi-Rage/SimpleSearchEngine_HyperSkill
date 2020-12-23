package search;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private List<DataModel> storage = new ArrayList<>();

    public Repository() {
    }

    public List<DataModel> getStorage() {
        return storage;
    }

    public void setStorage(List<DataModel> storage) {
        this.storage = storage;
    }
}
