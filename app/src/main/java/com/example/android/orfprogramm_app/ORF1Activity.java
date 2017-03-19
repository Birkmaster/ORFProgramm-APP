package com.example.android.orfprogramm_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import android.app.Activity;



public class ORF1Activity extends AppCompatActivity {
    private EditText text1, text2, text3;
    private String url1 = "http://rss.orf.at/orfeins.xml";
    private String url2 = "&mode=xml";
    private HandleXML obj;



}





/**
    TextView tvRSS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orf1);
        tvRSS = (TextView) findViewById(R.id.RssFeed);
        loadRSS();
    }
    public void loadRSS() {

        //URL url = new URL("http://rss.orf.at/news.xml");

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://rss.orf.at/orfeins.xml";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        tvRSS.setText(response.substring(0,3000));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvRSS.setText("That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }


}