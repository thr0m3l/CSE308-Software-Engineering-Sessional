package CharAdder;

import AdderAdapter.CharToIntAdapter;
import AdderAdapter.AdderAdapter;

public class CharAdder {

    private String filename;

    public CharAdder(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    public Integer calculateSum(){
        AdderAdapter adapter = new CharToIntAdapter(filename);
        return adapter.calculateSum();
    }
}
