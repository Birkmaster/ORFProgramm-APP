package com.example.android.orfprogramm_app;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import static android.view.View.X;

/**
 * Created by Birkmaster on 14.03.2017.
 */

public class HandleXML {
    private String title = "title";
    private String link = "link";
    private String description = "description";
    private String urlString = null;
    private XmlPullParserFactory,xmlFactoryObject;
    private volatile boolean parsingComplete = true;

    public HandleXML(String url) {
        this.urlString = url;
    }

    public String getTitle

    {
        return title;
    }

    public String getLink

    {
        return link;
    }

    public String getDescription

    {
        return description;
    }

    public void parsXMLandStorelt(XmlPullParser myParser) {
        int event;
        String text = null;
        try {
            event = myParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
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
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        public void fetchXML() {} /*TODO
    }
