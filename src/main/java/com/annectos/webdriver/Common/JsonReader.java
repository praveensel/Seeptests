package com.Annectos.Webdriver.Common;

/**
 * Created with IntelliJ IDEA.
 * User: praveen
 * Date: 3/29/14
 * Time: 10:25 AM
 * To change this template use File | Settings | File Templates.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

public class JsonReader  {



    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            //System.out.println(jsonText);
            String  myJsonString = jsonText.replaceAll("\\\\","");

            String Finalstring;
            System.out.println(myJsonString);
            Finalstring = myJsonString.replace( "\"{","{");
            System.out.println(Finalstring);
            String FinalString1= Finalstring.replace( "}\"","}");
            System.out.println(FinalString1);
            JSONArray json1 = new JSONArray(FinalString1);

            return json1;
        } finally {
            is.close();
        }
    }

    public static void main(String[] args) throws IOException, JSONException {
      JSONArray json = readJsonFromUrl("http://app.annectos.net/ecomm.api/store/prod_list_by_cat_short?cat_id=3.2.6&min=0&max=0&json=true");
       // JSONArray json = readJsonFromUrl("http://app.annectos.net/ecomm.api/store/level1menu?json=true");
        int si;
        for(si=0; si<json.length();si++)
        {
            JSONObject js= (JSONObject) json.get(si);
            System.out.println( js.get("id")) ;

        }

    }

    public void Products_page_api_reader(String URl) throws IOException, JSONException {
        JSONArray json = readJsonFromUrl(URl);
        // JSONArray json = readJsonFromUrl("http://app.annectos.net/ecomm.api/store/level1menu?json=true");
        int si;
        for(si=0; si<json.length();si++)
        {
            JSONObject js= (JSONObject) json.get(si);
            System.out.println( js.get("id")) ;

        }
    }
}
