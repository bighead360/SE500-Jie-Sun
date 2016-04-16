import java.util.List;

/**
 * Created by jerrysun on 4/11/16.
 */
public class PackageTracking {



    public class TrackingStatus
    {


        public String status_details;
        public String status_date;
        public Location location;
    }




    public String carrier;
    public String tracking_number;
    public TrackingStatus tracking_status;
    public List<TrackingStatus> tracking_history;


}
