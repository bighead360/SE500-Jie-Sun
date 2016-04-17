import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 4/16/16.
 */
public class TrackingJsonAPITest {

    @Test
    public void parseFromJson() throws IOException, InterruptedException {

        PackageTracking packageTracking = new PackageTracking();
        PackageTracking.TrackingStatus trackingStatus = packageTracking.new TrackingStatus();
        trackingStatus = TrackingJsonAPI.getTrackingStatus("9200199999977453249942");

        Assert.assertNotNull(trackingStatus);
    }
}
