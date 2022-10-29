package Loader;

import java.util.ArrayList;
import java.util.List;

public class DomainEmailsLoader implements Loader{
    private final Loader loader;

    public DomainEmailsLoader(Loader loader) {
        this.loader = loader;
    }

    @Override
    public List<String> load() {
        List<String> list = new ArrayList<>();
        List<String> source = loader.load();
        for (String line: source){
            list.add(split(line));
        }
        return list;

    }

    private String split(String line) {
        String domain = "@" + line.split("@")[1];
        System.out.println(domain);
        return domain;
    }
}
