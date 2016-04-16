import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Created by jerrysun on 4/13/16.
 */
public class Location {
    public String city;
    public String state;
    public String zip;

    public static void main(String[] args) throws IOException {
        System.out.println(Jsoup.connect("https://api.goshippo.com/v1/tracks/usps/9200199999977453249942").ignoreContentType(true).execute().body());
    }
}
