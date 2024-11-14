import java.util.ArrayList;

public class PlainTextFormat implements IFormat{

    public void format(){
        for(int i = 0; i < fileContent.size(); i++){
            System.out.println(fileContent.get(i));
        }
    }

    @Override
    public void format(ArrayList<String> data) {

    }
}
