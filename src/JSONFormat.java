import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSONFormat implements IFormat {
    @Override
    public void format(ArrayList<String> data) {
        System.out.println("{");
        System.out.println("\"document\": [");
        for (int i = 0; i < data.size(); i++) {
            System.out.print("  \"" + data.get(i) + "\"");
            if (i < data.size() - 1) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println("]");
        System.out.println("}");
    }

    @Override
    public void saveToFile(ArrayList<String> data, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("{\n");
            writer.write("\"document\": [\n");
            for (int i = 0; i < data.size(); i++) {
                writer.write("  \"" + data.get(i) + "\"");
                if (i < data.size() - 1) {
                    writer.write(",\n");
                } else {
                    writer.write("\n");
                }
            }
            writer.write("]\n");
            writer.write("}\n");
        }
        System.out.println("Saved as JSON to: " + filePath);
    }
}
