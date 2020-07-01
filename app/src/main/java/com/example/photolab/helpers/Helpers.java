package com.example.photolab.helpers;

import androidx.appcompat.app.AlertDialog;

public class Helpers {
    public static String capitalize(String txt){
        return txt.substring(0, 1).toUpperCase() + txt.substring(1).toLowerCase();
    }
    public static AlertDialog information = null;
    public final static String API_URL = "https://pixabay.com/api/";
    public final static String API_KEY = "17077904-98a0e02560a8a75c66df39a6c";
    public final static int NETWORK_TIMEOUT = 3000;
    public final static String[] API_CATEGORIES = new String[] {
            "backgrounds",
            "fashion",
            "nature",
            "science",
            "education",
            "feelings",
            "health",
            "people",
            "religion",
            "places",
            "animals",
            "industry",
            "computer",
            "food",
            "sports",
            "transportation",
            "travel",
            "buildings",
            "business",
            "music"
    };
}
