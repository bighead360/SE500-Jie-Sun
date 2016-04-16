import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jerrysun on 4/14/16.
 */
public class ConvertTimeFormat {
    public static void main(String[] args) throws IOException, ParseException {
        String dateStr = "2016-04-04T08:20:00Z";
        String dateStrb = "April 4, 2016 , 6:20 am";

        System.out.println(TimeJSONtoParser(dateStr));
        System.out.println(TimeParsertoJSON(dateStrb));

    }

    public static String TimeJSONtoParser(String dateStr){
        String readFormatString = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        String writeFormatString = "MMMMM d, yyyy , h:mm a";

        return TimeConvert(readFormatString,writeFormatString,dateStr);

    }

    public static String TimeParsertoJSON(String dateStr){
        String readFormatString = "MMMMM d, yyyy , h:mm a";
        String writeFormatString = "yyyy-MM-dd'T'HH:mm:ss'Z'";

        return TimeConvert(readFormatString,writeFormatString,dateStr);

    }

    public static String TimeConvert(String readFormatString,String writeFormatString, String dateStr){
        DateFormat readFormat = new SimpleDateFormat(readFormatString);
        DateFormat writeFormat = new SimpleDateFormat(writeFormatString);
        String formattedDate = null;
        Date date = null;
        try
        {
            date = readFormat.parse( dateStr );
        }
        catch ( ParseException e )
        {
            e.printStackTrace();
        }
        if( date != null )
        {
            String formattedDateTemp = writeFormat.format( date );
            formattedDate = formattedDateTemp.replace("AM", "am").replace("PM", "pm");
        }
        return formattedDate;



    }
}
