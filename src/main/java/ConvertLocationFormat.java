import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 4/14/16.
 */
public class ConvertLocationFormat {
    public static void main(String[] args) throws IOException, ParseException {
        PackageTracking trackingb = JSON.parseObject("{\"carrier\": \"usps\", \"tracking_number\": \"9200199999977453249942\", \"tracking_status\": {\"object_created\": \"2016-04-06T23:13:22.365Z\", \"object_updated\": \"2016-04-06T23:13:22.365Z\", \"object_id\": \"bf3c8ea9c7fe41c1b97c701ee602b535\", \"status\": \"DELIVERED\", \"status_details\": \"Your shipment has been delivered to a PO box.\", \"status_date\": \"2016-04-04T08:20:00Z\", \"location\": {\"city\": \"Tappahannock\", \"state\": \"VA\", \"zip\": \"22560\", \"country\": \"US\"}}, \"tracking_history\": [{\"object_created\": \"2016-04-06T23:13:22.365Z\", \"object_id\": \"aa2394c557c8456aaa92e10a56a6c2f9\", \"status\": \"TRANSIT\", \"status_details\": \"Your shipment has been accepted at the USPS origin facility.\", \"status_date\": \"2016-04-01T16:28:00Z\", \"location\": {\"city\": \"Moreno Valley\", \"state\": \"CA\", \"zip\": \"92551\", \"country\": \"US\"}}, {\"object_created\": \"2016-04-06T23:13:22.365Z\", \"object_id\": \"a0d124d448f04ece9bced4e2f30b49eb\", \"status\": \"TRANSIT\", \"status_details\": \"Your shipment has arrived at the USPS origin facility.\", \"status_date\": \"2016-04-01T17:43:00Z\", \"location\": {\"city\": \"Moreno Valley\", \"state\": \"CA\", \"zip\": \"92553\", \"country\": \"US\"}}, {\"object_created\": \"2016-04-06T23:13:22.365Z\", \"object_id\": \"1d04091424834369bc965bb429dece48\", \"status\": \"TRANSIT\", \"status_details\": \"Your shipment has arrived at the USPS destination facility.\", \"status_date\": \"2016-04-03T22:06:00Z\", \"location\": {\"city\": \"Sandston\", \"state\": \"VA\", \"zip\": \"23150\", \"country\": \"US\"}}, {\"object_created\": \"2016-04-06T23:13:22.365Z\", \"object_id\": \"c64ef08e6be74a0886e872bb0ff6ab63\", \"status\": \"TRANSIT\", \"status_details\": \"Your shipment has departed the USPS facility.\", \"status_date\": \"2016-04-04T04:10:00Z\", \"location\": {\"city\": \"Sandston\", \"state\": \"VA\", \"zip\": \"23150\", \"country\": \"US\"}}, {\"object_created\": \"2016-04-06T23:13:22.365Z\", \"object_id\": \"e4be182a3e164af6853217fcbfeaf006\", \"status\": \"TRANSIT\", \"status_details\": \"Your shipment has arrived at the post office.\", \"status_date\": \"2016-04-04T06:32:00Z\", \"location\": {\"city\": \"Tappahannock\", \"state\": \"VA\", \"zip\": \"22560\", \"country\": \"US\"}}, {\"object_created\": \"2016-04-06T23:13:22.365Z\", \"object_id\": \"fefa27181ecc4d2ca857bed0ef7db4a5\", \"status\": \"DELIVERED\", \"status_details\": \"Your shipment has been delivered to a PO box.\", \"status_date\": \"2016-04-04T08:20:00Z\", \"location\": {\"city\": \"Tappahannock\", \"state\": \"VA\", \"zip\": \"22560\", \"country\": \"US\"}}]}", PackageTracking.class);
        Location locationb = trackingb.tracking_history.get(1).location;

        System.out.println(locationb.city);

        String address = "MORENO VALLEY, CA 92553";
        Location locationc = LocationParserConvertToObj(address);

        System.out.println(locationc.state);
        System.out.println(locationc.zip);
        System.out.println(locationc.city);

    }
    public static Location LocationParserConvertToObj(String address) {

        List<String> elephantList = Arrays.asList(address.split(","));
        String elephantListb = elephantList.get(1).replaceAll("\\s+","");
        Location locationc = new Location();
        locationc.state = elephantListb.substring(0,2);
        locationc.zip = elephantListb.substring(2,7);
        locationc.city = upperCaseAllFirst(elephantList.get(0));



        return locationc;

    }


    public static String upperCaseAllFirst(String sentence) {

        char[] array = sentence.toLowerCase().toCharArray();
        // Uppercase first letter.
        array[0] = Character.toUpperCase(array[0]);

        // Uppercase all letters that follow a whitespace character.
        for (int i = 1; i < array.length; i++) {
            if (Character.isWhitespace(array[i - 1])) {
                array[i] = Character.toUpperCase(array[i]);
            }
        }
        return new String(array);
    }




}
