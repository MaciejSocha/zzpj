package razdwatrzy.zzpj.youtube;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YouTubeService {

//    AIzaSyDRmYcV4AhmuIHPI_c0b3ESokONHj1c4O0
    public int getViewsCountForVideo(String id){

        String sUrl = "https://www.googleapis.com/youtube/v3/videos?id="+ id + "&key=AIzaSyDRmYcV4AhmuIHPI_c0b3ESokONHj1c4O0&part=statistics";

        // Connect to the URL using java's native library
        URL url = null;
        try {
            url = new URL(sUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection request = null;
        try {
            request = url.openConnection();
            request.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = null; //Convert the input stream to a json element
        try {
            root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json = root.getAsJsonObject().toString(); //May be an array, may be an objec

        return Integer.parseInt(getJsonAttributeValue(json, "viewCount"));

    }

    private static String getJsonAttributeValue(String json, String attribute) {

        Pattern TAG_REGEX = Pattern.compile("\"" + attribute + "\":\"" + "(.+?)" + "\",", Pattern.DOTALL);
        String p = TAG_REGEX.pattern();
        List<String> tagValues = new ArrayList<String>();
        Matcher matcher = TAG_REGEX.matcher(json);
        while (matcher.find()) {
            tagValues.add(matcher.group(1));
        }
        return tagValues.get(0);
    }
}
