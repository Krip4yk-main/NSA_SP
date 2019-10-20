package data;

import com.google.gson.Gson;
import data.enities.People;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.net.URI;

public class Peoples
{
    private String sUrl;
    private String sUri;

    public Peoples()
    {
        this.sUrl = "https://solarsystem.nasa.gov/api/v1/people/?per_page=1000";
        this.sUrl = "https://solarsystem.nasa.gov/api/v1/people/?per_page=1000";
    }

    public People[] get()
    {
        try {
            URI uri = new URI(this.sUrl);
            JSONTokener tokenizer = new JSONTokener(uri.toURL().openStream());
            JSONArray jsonObjects = (new JSONObject(tokenizer).getJSONArray("items"));

            Gson gson = new Gson();

            return gson.fromJson(jsonObjects.toString(), People[].class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new People[0];
    }

    public String getsUrl() {
        return sUrl;
    }
}
