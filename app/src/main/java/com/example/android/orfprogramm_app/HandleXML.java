package com.example.android.orfprogramm_app;

import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.view.View.X;

/**
 * Created by Birkmaster on 14.03.2017.
 */

public class HandleXML {
    public String title = "title";
    public String link = "link";
    public String description = "description";
    private String urlString = null;
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;

    public HandleXML(String url) {
        this.urlString = url;
    }

    public String getTitle ()

    {
        return title;
    }

    public String getLink ()

    {
        return link;
    }

    public String getDescription ()

    {
        return description;
    }

    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;
        String text = null;
        try {
            event = myParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT)
            {
                String name = myParser.getName();
                switch (event) {
                    case XmlPullParser.START_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (name.equals("title")) {
                            title = text;
                        } else if (name.equals("link")) {
                            link = text;
                        } else if (name.equals("description")) {
                            description = text;
                        } else {
                            break;
                        }
                        event = myParser.next();
                            }
                parsingComplete = false;
            }
            }catch(Exception e){
            e.printStackTrace();
        }
    }
        public void fetchXML() {
            Thread thread = new Thread (new Runnable(){
                @Override
                public void run (){
                    try {
                    URL url = new URL (urlString);
                        HttpURLConnection connect= (HttpURLConnection)url.openConnection();
                        connect.setReadTimeout(10000);
                        connect.setConnectTimeout(15000);
                        connect.setRequestMethod("GET");
                        connect.setDoInput(true);
                        connect.connect();
                        InputStream stream = connect.getInputStream ();
                        xmlFactoryObject = XmlPullParserFactory.newInstance();
                        XmlPullParser myparser = xmlFactoryObject.newPullParser();
                        myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                        myparser.setInput(stream, null);
                        parseXMLAndStoreIt (myparser);
                        stream.close();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
    thread.start();
    }
}

