package data;

import com.google.gson.Gson;
import data.enities.People;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.net.URI;

public class JsonParser
{
    String sUrl;
    String sUri;

    JsonParser()
    {
        this.sUrl = "https://solarsystem.nasa.gov";
    }

    public String getUrl() {
        return this.sUrl;
    }

    public String getUri() {
        return sUri;
    }

}
