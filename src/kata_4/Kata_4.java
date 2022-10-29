package kata_4;

import Loader.*;
import Histo.*;
import java.io.File;

public class Kata_4 {

    public static void main(String[] args) {
        Histogram<String> histogram = new Histogram<String>();
        Loader loader = new DomainEmailsLoader(new EmailsLoader(new FileLoader(new File("emails.txt"))));
        
        for (String emails: loader.load()){
            histogram.increment(emails);
        }
        HistogramDisplay histogramdisplay = new HistogramDisplay("Histogram Display", histogram);
        histogramdisplay.execute();
    }
    
}
