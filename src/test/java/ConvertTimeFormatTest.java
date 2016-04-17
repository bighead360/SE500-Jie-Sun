import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jerrysun on 4/16/16.
 */
public class ConvertTimeFormatTest {

    @Test
    public void TimeJSONtoParserTest(){

        String dateStr = "2016-04-04T08:20:00Z";
        String dateStrb = "April 4, 2016 , 8:20 am";


        Assert.assertEquals(dateStrb,ConvertTimeFormat.TimeJSONtoParser(dateStr));
        Assert.assertEquals(dateStrb,ConvertTimeFormat.TimeJSONtoParser(dateStr));


    }

    public void TimeParsertoJSONTest(){

        String dateStr = "2016-04-04T08:20:00Z";
        String dateStrb = "April 4, 2016 , 8:20 am";

        Assert.assertEquals(dateStr,ConvertTimeFormat.TimeParsertoJSON(dateStrb));

    }
}
