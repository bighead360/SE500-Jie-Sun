import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jerrysun on 4/13/16.
 */
public class PackageTrackingTest {

    @Test
    public void parseFromJson(){
        PackageTracking tracking = JSON.parseObject("{\n" +
                "  \"carrier\": \"usps\",\n" +
                "  \"tracking_number\": \"9200199999977453249942\",\n" +
                "  \"tracking_status\": {\n" +
                "    \"object_created\": \"2016-04-06T23:13:22.365Z\",\n" +
                "    \"object_updated\": \"2016-04-06T23:13:22.365Z\",\n" +
                "    \"object_id\": \"71001fd4e0e341f694ad5485623ef0f5\",\n" +
                "    \"status\": \"DELIVERED\",\n" +
                "    \"status_details\": \"Your shipment has been delivered to a PO box.\",\n" +
                "    \"status_date\": \"2016-04-04T08:20:00Z\",\n" +
                "    \"location\": {\n" +
                "      \"city\": \"Tappahannock\",\n" +
                "      \"state\": \"VA\",\n" +
                "      \"zip\": \"22560\",\n" +
                "      \"country\": \"US\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"tracking_history\": [\n" +
                "    {\n" +
                "      \"object_created\": \"2016-04-06T23:13:22.365Z\",\n" +
                "      \"object_id\": \"992ce28bea6348959144c5b53bf061d1\",\n" +
                "      \"status\": \"TRANSIT\",\n" +
                "      \"status_details\": \"Your shipment has been accepted at the USPS origin facility.\",\n" +
                "      \"status_date\": \"2016-04-01T16:28:00Z\",\n" +
                "      \"location\": {\n" +
                "        \"city\": \"Moreno Valley\",\n" +
                "        \"state\": \"CA\",\n" +
                "        \"zip\": \"92551\",\n" +
                "        \"country\": \"US\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"object_created\": \"2016-04-06T23:13:22.365Z\",\n" +
                "      \"object_id\": \"6ce6ecb579504a4bb7430b1e29379216\",\n" +
                "      \"status\": \"TRANSIT\",\n" +
                "      \"status_details\": \"Your shipment has arrived at the USPS origin facility.\",\n" +
                "      \"status_date\": \"2016-04-01T17:43:00Z\",\n" +
                "      \"location\": {\n" +
                "        \"city\": \"Moreno Valley\",\n" +
                "        \"state\": \"CA\",\n" +
                "        \"zip\": \"92553\",\n" +
                "        \"country\": \"US\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"object_created\": \"2016-04-06T23:13:22.365Z\",\n" +
                "      \"object_id\": \"86ab9e8cbae548cdafd0613eaad9bad7\",\n" +
                "      \"status\": \"TRANSIT\",\n" +
                "      \"status_details\": \"Your shipment has arrived at the USPS destination facility.\",\n" +
                "      \"status_date\": \"2016-04-03T22:06:00Z\",\n" +
                "      \"location\": {\n" +
                "        \"city\": \"Sandston\",\n" +
                "        \"state\": \"VA\",\n" +
                "        \"zip\": \"23150\",\n" +
                "        \"country\": \"US\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"object_created\": \"2016-04-06T23:13:22.365Z\",\n" +
                "      \"object_id\": \"a4853640053c4b15b299d636d5fda250\",\n" +
                "      \"status\": \"TRANSIT\",\n" +
                "      \"status_details\": \"Your shipment has departed the USPS facility.\",\n" +
                "      \"status_date\": \"2016-04-04T04:10:00Z\",\n" +
                "      \"location\": {\n" +
                "        \"city\": \"Sandston\",\n" +
                "        \"state\": \"VA\",\n" +
                "        \"zip\": \"23150\",\n" +
                "        \"country\": \"US\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"object_created\": \"2016-04-06T23:13:22.365Z\",\n" +
                "      \"object_id\": \"23ad2616467846d3a08572957aeda76e\",\n" +
                "      \"status\": \"TRANSIT\",\n" +
                "      \"status_details\": \"Your shipment has arrived at the post office.\",\n" +
                "      \"status_date\": \"2016-04-04T06:32:00Z\",\n" +
                "      \"location\": {\n" +
                "        \"city\": \"Tappahannock\",\n" +
                "        \"state\": \"VA\",\n" +
                "        \"zip\": \"22560\",\n" +
                "        \"country\": \"US\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"object_created\": \"2016-04-06T23:13:22.365Z\",\n" +
                "      \"object_id\": \"2e14f095c9a94be5b81ad843de310f56\",\n" +
                "      \"status\": \"DELIVERED\",\n" +
                "      \"status_details\": \"Your shipment has been delivered to a PO box.\",\n" +
                "      \"status_date\": \"2016-04-04T08:20:00Z\",\n" +
                "      \"location\": {\n" +
                "        \"city\": \"Tappahannock\",\n" +
                "        \"state\": \"VA\",\n" +
                "        \"zip\": \"22560\",\n" +
                "        \"country\": \"US\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}", PackageTracking.class);


        Assert.assertEquals(tracking.tracking_number,"9200199999977453249942");
    }
//    public static void main(String[] args){
//        PackageTracking packageTraking = new PackageTracking();
//        packageTraking.setCarrier("usps");
//        String jsonString = JSON.toJSONString(packageTraking,true);
//
//    }

}
