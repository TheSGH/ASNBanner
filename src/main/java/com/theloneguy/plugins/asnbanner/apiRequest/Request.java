package com.theloneguy.plugins.asnbanner.apiRequest;

import com.theloneguy.plugins.asnbanner.AsnBanner;
import kong.unirest.Unirest;
import org.json.JSONObject;

import java.util.logging.Level;

public class Request {

    public static String doRequest(String ip) {

        String rsp = Unirest.get("https://thesgh-ipdb.onrender.com/asnb?ip=" + ip).asString().getBody();

        JSONObject jso = new JSONObject(rsp);


        try {

            JSONObject jsasn = new JSONObject(jso.get("data"));
            return jsasn.get("asn").toString();
        } catch (Exception e) {
            AsnBanner.logger.log(Level.SEVERE, "Error !");
            e.printStackTrace();
        }

        return null;
    }

}
