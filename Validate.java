package idea.library;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Validate {

    public boolean validateBookId(String Id){
        return Id.length()>0 && Id.length()<=4;
    }

    public boolean validates(String name){
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }
}
