import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class PlainTextFormat implements IFormat{

    @Override
    public void format(ArrayList<String> data){
        for(int i = 0; i < data.size(); i++){
            System.out.println(data.get(i));
        }
    }

    @Override
    public void saveToFile(ArrayList<String> data, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String line : data) {
                writer.write(line + System.lineSeparator());
            }
        }
        System.out.println("Saved as plain text to: " + filePath);
    }
}
