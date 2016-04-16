import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

import static java.lang.Boolean.*;

/**
 * Created by jerrysun on 4/15/16.
 */
public class JsonReader {

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

    public static void main(String[] args) throws IOException, JSONException {
        try {
            JSONObject json = new JSONObject(readUrl("https://api.goshippo.com/v1/tracks/usps/9200199999977453249942"));

            String status = (String) json.get("status");
            System.out.println(status);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

