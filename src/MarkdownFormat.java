import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MarkdownFormat implements IFormat {
    @Override
    public void format(ArrayList<String> data){
        String[] options = {"**", "***", "<sub>", "~~","_"};
        Random rng = new Random();
        System.out.println("#" + data.get(0));

        for(int i = 1; i < data.size(); i++){
            int number = rng.nextInt(options.length);
            String option = options[number];
            System.out.println(option + data.get(i) + option);
        }
    }

    @Override
    public void saveToFile(ArrayList<String> data, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("# " + data.get(0) + System.lineSeparator());
            String[] options = {"**", "*", "_", "~~"};
            Random rng = new Random();
            for (int i = 1; i < data.size(); i++) {
                int randomOption = rng.nextInt(options.length);
                String markdown = options[randomOption];
                writer.write(markdown + data.get(i) + markdown + System.lineSeparator());
            }
        }
        System.out.println("Saved as Markdown to: " + filePath);
    }

}
