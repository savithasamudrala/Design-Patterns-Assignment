import java.util.ArrayList;
import java.util.Random;

public class TextFile {

    private ArrayList<String> fileContent;

    public TextFile(ArrayList<String> data){
        fileContent = data;
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
        int number = rng.nextInt(options.length);
        System.out.println("#" + fileContent.get(0));

        for(int i = 1; i < fileContent.size(); i++){
            String option = options[number];
            System.out.println("<text=" + fileContent.get(i) + ">");
        }
        System.out.println("</head>");
        System.out.println("</html>");
    }



}
