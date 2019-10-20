package data;

import data.enities.Mission;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.net.URI;

import com.google.gson.*;

public class Missions extends JsonParser
{
    public Missions()
    {
        this.sUri = this.sUrl + "/api/v1/missions/?per_page=1000";
    }

    public Mission[] get()
    {
        try {
            URI uri = new URI(this.sUri);
            JSONTokener tokenizer = new JSONTokener(uri.toURL().openStream());
            JSONArray jsonObjects = (new JSONObject(tokenizer).getJSONArray("items"));

            Gson gson = new Gson();

            return gson.fromJson(jsonObjects.toString(), Mission[].class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new Mission[0];
    }
}
