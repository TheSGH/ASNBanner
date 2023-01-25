package com.theloneguy.plugins.asnbanner.apiRequest;

import kong.unirest.Unirest;
import org.json.JSONObject;

public class Request {

    public static String doRequest(String ip) {

        String rsp = Unirest.get("https://thesgh-ipdb.onrender.com/asnb?ip=" + ip).asString().getBody();

        JSONObject jso = new JSONObject(rsp);


        try {

            JSONObject jsasn = jso.getJSONObject("data");

            return jsasn.get("asn").toString();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }

}
