import java.net.*;
import java.io.*;
import java.util.*;

public class HTTPExample {

    public static String getHttpContent(String string) {

        String content="";

        try {
            URL url = new URL(string);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line= reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            content = stringBuilder.toString();

        } catch (Exception e) {
            System.err.println(e.toString());
        }

        return content;
    }

    public static Map getHttpHeaders(String string) {
        Map hashmap = null;

        try {
            URL url = new URL(string);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();

            hashmap = http.getHeaderFields();

        } catch(Exception e) {
            System.err.println(e.toString());
        }

        return hashmap;

    }

    public static void main(String[] args) {
        System.out.println(HTTPExample.getHttpContent("http://www.google.com"));

        Map<Integer, List<String>> m = HTTPExample.getHttpHeaders("http://www.google.com");


        for (Map.Entry<Integer,List<String>> entry : m.entrySet()) {
            try {
                System.out.println("Key= " + entry.getKey() +   // The reason why getValue produced an error was because
                        entry.getValue()); // it contains a list of strings within each value.
                // Changing the type from <String> to List<String> you
                // can at least see the first entry in each value
            } catch(Exception e) {
                System.err.println(e.toString());
            }
        }
    }
}