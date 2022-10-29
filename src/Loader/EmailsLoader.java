package Loader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EmailsLoader implements Loader{
    private final Loader loader;
    private final Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    public EmailsLoader(Loader loader) {
        this.loader = loader;
    }

    @Override
    public List<String> load() {
        List<String> list = new ArrayList<>();
        List<String> source = loader.load();
        for (String line: source){
            if(isEmail(line)) list.add(line);
        }
        return list;
    }

    private boolean isEmail(String line) {
        return pattern.matcher(line).matches();
    }
    
}
