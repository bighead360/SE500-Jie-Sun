import com.alibaba.fastjson.JSONException;

import java.io.IOException;

/**
 * Created by jerrysun on 4/16/16.
 */
public class App {
    public static void main(String[] args) throws IOException, JSONException, InterruptedException{


        CompareStatus("9200199999977453249942");


        CompareStatus("9400110200881976430106");


    }

    public static String CompareStatus(String trackingNum) throws IOException, InterruptedException {

        PackageTracking packageTrackingWebParser = new PackageTracking();
        PackageTracking.TrackingStatus trackingStatusWebParser = packageTrackingWebParser.new TrackingStatus();

        PackageTracking packageTrackingJson = new PackageTracking();
        PackageTracking.TrackingStatus trackingStatusJson= packageTrackingJson.new TrackingStatus();

        trackingStatusWebParser = TrackingWebParser.getTrackingStatus(trackingNum);
        trackingStatusJson = TrackingJsonAPI.getTrackingStatus(trackingNum);

        System.out.println(trackingStatusWebParser.status.toLowerCase());
        System.out.println(trackingStatusJson.status.toLowerCase());

        if(CheckStatusSame(trackingStatusWebParser,trackingStatusJson)){

            System.out.println("The shipping status are synchronous. ");

        }else{
            System.out.println("The shipping status are not synchronous. ");

        }

        String statusCompare = ("From Web parser, the status is " + trackingStatusWebParser.status + ", " +
                trackingStatusWebParser.status_date + ", " + trackingStatusWebParser.status_details + "\n"
                + "From Json API, the status is " + trackingStatusJson.status + ", " +
                trackingStatusJson.status_date + ", " + trackingStatusJson.status_details);

        System.out.println(statusCompare);

        if(CheckStatustotalSame(trackingStatusWebParser,trackingStatusJson)){

            System.out.println("The shipping status are totally synchronous. ");

        }else{
            System.out.println("The shipping status are not totally synchronous. ");

        }



        return statusCompare;

    }

    public static boolean CheckStatusSame(PackageTracking.TrackingStatus trackingStatusWebParser , PackageTracking.TrackingStatus trackingStatusJson){

        if (trackingStatusWebParser.status.toLowerCase().equals(trackingStatusJson.status.toLowerCase())){
            return true;
        }

        return false;
    }

    public static boolean CheckStatustotalSame(PackageTracking.TrackingStatus trackingStatusWebParser , PackageTracking.TrackingStatus trackingStatusJson){

        if (trackingStatusWebParser.status_date.equals(trackingStatusJson.status_date)){
            System.out.println("status data is synchronous");
            return true;
        }

        return false;
    }


}
