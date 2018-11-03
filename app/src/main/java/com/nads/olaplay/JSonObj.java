package com.nads.olaplay;

import java.util.jar.Attributes;

/**
 * Created by Admin on 12/21/2017.
 */

public class JSonObj {
    private String Name;
    private String Url1;
    private String Artists;
    private String Image;
    public JSonObj(String name, String url1, String artists, String image) {
        Name = name;
        Url1 = url1;
        Artists = artists;
        Image = image;
    }
    public String getName() {
        return Name;
    }

    public String getUrl1() {
        return Url1;
    }

    public String getArtists() {
        return Artists;
    }

    public String getImage() {
        return Image;
    }
}