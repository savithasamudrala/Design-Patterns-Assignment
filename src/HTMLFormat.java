import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HTMLFormat implements IFormat {

    @Override
    public void format(ArrayList<String> data){
        System.out.println("<html dir=\"ltr\" lang=\"en\">");
        System.out.println("<head>");
        for(int i = 0; i < data.size(); i++){
            System.out.println("<text=" + data.get(i) + ">");
        }
        System.out.println("</head>");
        System.out.println("</html>");
    }

    @Override
    public void saveToFile(ArrayList<String> data, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("<html>\n");
            writer.write("<head>\n");
            for (String line : data) {
                writer.write("<text>" + line + "</text>\n");
            }
            writer.write("</head>\n");
            writer.write("</html>\n");
        }
        System.out.println("Saved as HTML to: " + filePath);
    }

}
