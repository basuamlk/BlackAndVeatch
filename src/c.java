import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class c {



        public static void main(String[] args) {
            try {
                getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static String getConnection() throws Exception {
            StringBuffer content = new StringBuffer();
            Gson gson = new Gson();
            URL url = new URL("https://tupleschallenge.blob.core.windows.net/interview/age_data.json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            try {
                BufferedReader reader = new BufferedReader( new InputStreamReader(con.getInputStream()));

                for(String inputLine; (inputLine = reader.readLine()) != null; ) {
                    content.append(inputLine);
                }
//            ArrayList<String> arrayList = gson.fromJson(content.toString(),ArrayList.class );
                JsonObject obj = gson.fromJson(content.toString(), JsonObject.class);
                int id = obj.get("user").getAsJsonObject().get("id").getAsInt();
                int age = obj.get("user").getAsJsonObject().get("age").getAsInt();
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();

        }

}
