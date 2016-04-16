import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by jerrysun on 4/15/16.
 */
public class TrackingJsonAPI {

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
    public static PackageTracking.TrackingStatus getTrackingStatus(String trackingNum)  throws InterruptedException, IOException {

        PackageTracking packageTracking = new PackageTracking();
        PackageTracking.TrackingStatus trackingStatus = packageTracking.new TrackingStatus();

        try {
            String rootUrl = "https://api.goshippo.com/v1/tracks/usps/";
            packageTracking = JSON.parseObject(readUrl(rootUrl + trackingNum), PackageTracking.class);
            trackingStatus = packageTracking.tracking_status;

            return trackingStatus;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trackingStatus;
    }

    public static void main(String[] args) throws IOException, JSONException, InterruptedException {
        PackageTracking packageTracking = new PackageTracking();
        PackageTracking.TrackingStatus trackingStatus = packageTracking.new TrackingStatus();
        trackingStatus = getTrackingStatus("9200199999977453249942");
        System.out.println(trackingStatus.status);


    }
}

