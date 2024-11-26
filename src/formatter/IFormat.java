package formatter;

import java.io.IOException;
import java.util.ArrayList;

public interface IFormat {

    public void format(ArrayList<String> data);
    void saveToFile(ArrayList<String> data, String filePath) throws IOException;

}
