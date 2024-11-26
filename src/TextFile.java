import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

public class TextFile {

    private ArrayList<String> fileContent;
    private IFormat format;

    public TextFile(ArrayList<String> data){
        fileContent = data;
    }

    public void setFormat(IFormat format){
        this.format = format;
    }

    public void printPlainText(){
       for(int i = 0; i < fileContent.size(); i++){
           System.out.println(fileContent.get(i));
       }
    }

    public void printHTML(){
        System.out.println("<html dir=\"ltr\" lang=\"en\">");
        System.out.println("<head>");
        for(int i = 0; i < fileContent.size(); i++){
            System.out.println("<text=" + fileContent.get(i) + ">");
        }
        System.out.println("</head>");
        System.out.println("</html>");
    }

    public void printMarkdown(){
        String[] options = {"**", "***", "<sub>", "~~","_"};
        Random rng = new Random();
        System.out.println("#" + fileContent.get(0));

        for(int i = 1; i < fileContent.size(); i++){
            int number = rng.nextInt(options.length);
            String option = options[number];
            System.out.println(option + fileContent.get(i) + option);
        }
    }

    public void printFormatted(){
        format.format(fileContent);
    }


    public void save(String filePath) {
        if (format != null) {
            try {
                format.saveToFile(fileContent, filePath);
            } catch (IOException e) {
                System.out.println("Error saving file: " + e.getMessage());
            }
        } else {
            System.out.println("No format selected. Cannot save the file.");
        }
    }




}
