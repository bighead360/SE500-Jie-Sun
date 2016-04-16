import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by jerrysun on 4/13/16.
 */
public class TrackingWebParser {
    public static void main(String[] args) throws IOException, InterruptedException {
        PackageTracking packageTracking = new PackageTracking();
        PackageTracking.TrackingStatus trackingStatus = packageTracking.new TrackingStatus();
        trackingStatus = getTrackingStatus("9200199999977453249942");
        if (packageTracking == null) {
            System.out.println("wrong");
        }else
        {
            System.out.println(trackingStatus.status_details);
        }


    }
    public static PackageTracking.TrackingStatus getTrackingStatus(String trackingNum) throws InterruptedException, IOException {
        int repeat_times = 0;
        PackageTracking packageTracking = new PackageTracking();
        PackageTracking.TrackingStatus trackingStatus = packageTracking.new TrackingStatus();


        while(true) {
            try {
                String urlroot = "https://tools.usps.com/go/TrackConfirmAction?qtc_tLabels1=";
                String url = urlroot + trackingNum;
                Connection connect = Jsoup.connect(url);
                connect.header("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36");
                Document document = connect.followRedirects(true).get();

                packageTracking.carrier = document.select("#results-multi > div.panel.tracking-result.result-delivered.result-open > div > div.tracking-summary > div.tracking-progress.status-delivered > div.progress-indicator > h2").text().replace("\u00a0", "");
                trackingStatus.status=document.select("#results-multi > div.panel.tracking-result.result-delivered.result-open > div > div.tracking-summary > div.tracking-progress.status-delivered > div.progress-indicator > h2").text();

                String shortLocation = document.select("#tc-hits > tbody > tr:nth-child(1) > td.location > p").text().replace("\u00a0", "");

                Location locationc = ConvertLocationFormat.LocationParserConvertToObj(shortLocation);


                trackingStatus.location = new Location();
                trackingStatus.location.state = locationc.state;
                trackingStatus.location.city = locationc.city;
                trackingStatus.location.zip = locationc.zip;

                String shortDateTime = document.select("#tc-hits > tbody > tr:nth-child(1)  > td.date-time > p").text().replace("\u00a0", "");
                trackingStatus.status_date = ConvertTimeFormat.TimeParsertoJSON(shortDateTime);


                String shortStatueDetail = document.select("#tc-hits > tbody > tr.detail-wrapper.latest-detail > td.status > p.info-text.first").text().replace("\u00a0", " ");
                trackingStatus.status_details = shortStatueDetail;
                return trackingStatus;
            } catch (Exception e) {
                Thread.sleep(1000);
                repeat_times++;
                if (repeat_times>=3) {
                    break;
                }
            }
        }
        return trackingStatus;





    }









}
