package com.example.zur11;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class IO {

    private  IO(){};


    public static String get(String  http) throws IOException{

  //url(http)
    URL url=new URL(http);
  //  HttpsURLConnection  extend   HttpUriConction  extend URLConnection extend objct

    // url openConction
     HttpURLConnection con = (HttpURLConnection)url.openConnection();

  // get InputStream
     InputStream in=con.getInputStream();

     return read(in);
}




    public static String read(InputStream in) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
         return sb.toString();
        }

    }
    public static String read(AssetManager am, String filename)throws IOException{

        InputStream in = am.open(filename);
        return  read(in);
    }
}
