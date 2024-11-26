import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> data = new ArrayList<>();

        data.add("The first");
        data.add("The first");
        data.add("The first");

        TextFile file = new TextFile(data);
        //file.printPlainText();
        //file.printHTML();
        //file.printMarkdown();

        int option = 0;
        switch (option) {
            case 0:
                file.setFormat(new PlainTextFormat());
                break;
            case 1:
                file.setFormat(new HTMLFormat());
                break;
            case 2:
                file.setFormat(new MarkdownFormat());
                break;
            default:
                file.printFormatted();
        }

        // Call the save method after the format has been selected
        saveFile(file);
    }

    /**
     * Method to prompt the user for a file path and save the formatted content
     */
    private static void saveFile(TextFile file) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path to save the document:");
        String filePath = scanner.nextLine();

        file.save(filePath);
        System.out.println("File saved successfully!");
        scanner.close();
    }
}
