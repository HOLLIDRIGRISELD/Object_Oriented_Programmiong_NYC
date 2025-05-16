package Assesment_2;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WordAPI {
    //get the word from the api
    public static String getWord() {
        //try exception for the chance the url does not work
        try {
            //get the api form the internet
            URL url = new URL("https://random-word-api.herokuapp.com/word?number=1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(new InputStreamReader(conn.getInputStream()));
            return array.get(0).toString();
        } catch (Exception e) {
            e.printStackTrace();
            //in order for the program to work even if the api does not work the word default will be used
            return "default";
        }
    }
}
