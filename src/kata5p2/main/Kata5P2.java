package kata5p2.main;

import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReaderBD;

public class Kata5P2 {

    public static void main(String[] args) {
        List<Mail> mailList = MailListReaderBD.read("Kata5.db");
        
        Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        
        HistogramDisplay histogramDisplay = new HistogramDisplay("Histogram Display", histogram);
        histogramDisplay.execute();
    }
    
}
