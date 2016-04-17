import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by jerrysun on 4/15/16.
 */
public class TrackingWebParserTest {

    @Test
    public void GetCorrectInfo() throws IOException {

        String url = "https://tools.usps.com/go/TrackConfirmAction?qtc_tLabels1=9200199999977453249942";
        Connection connect = Jsoup.connect(url);
        connect.header("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36");
        Document document = connect.followRedirects(true).get();

        String shortLocation = document.select("#tc-hits > tbody > tr:nth-child(1) > td.location > p").text().replace("\u00a0", "");
        System.out.println(shortLocation);

        shortLocation = shortLocation.replaceAll("\\s+","");

        System.out.println(shortLocation);

        Assert.assertEquals("TAPPAHANNOCK,VA22560",shortLocation);



    }
}
