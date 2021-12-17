package com.example.crossingbook;

import android.location.GnssAntennaInfo;
import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkingService {

    public static final ExecutorService networkingExecutor = Executors.newFixedThreadPool(4);
    // with this executor you could run background thread.
    //For example if you have four threads and you need to assign a specific tasks to first thread and other tasks to another thread,
    // and so on, that mean, you have to pass something, you have to pass closure
    String  url = "https://www.googleapis.com/books/v1/volumes?q=";
    String api = "&appid=AIzaSyAQiJ-T9TrOnhRw951MhHJ3gA5b6ZaRoPM";


    static Handler networkHandler = new Handler(Looper.getMainLooper());

   // can sent main thread

    interface NetworkingListener{
       void APINetworkListener(String jsonString);

    }



   NetworkingListener listener;


    public void fetchBookTitle(String text){
        String completeURL = url+text+api;
        connect(completeURL);
    }


    public void fetchDetailData(String bookTitle){
        String completeURL = url+bookTitle+api;
        connect(completeURL);
    }


    private void connect(String url){
           // open connection
           // we ask Runable excutor to execute
         networkingExecutor.execute(new Runnable() {
             String jsonString = "";
             @Override
             public void run() {

                 HttpURLConnection httpURLConnection = null;

                 try {
                     URL urlObject = new URL(url);
                     httpURLConnection = (HttpURLConnection) urlObject.openConnection();
                     httpURLConnection.setRequestMethod("GET");
                     httpURLConnection.setRequestProperty("Content-Type", "application/json");

                     //check states
                     int staues = httpURLConnection.getResponseCode();

                     System.out.println("Staues" + staues);

                     if ((staues >= 200) && (staues <= 299)) {


                         InputStream in = httpURLConnection.getInputStream();
                         InputStreamReader inputStreamReader = new InputStreamReader(in); // easy to read a lot of stream
                         int read = 0;



                         while ((read = inputStreamReader.read()) != -1) { /// json intergers convert char ASCII
                             char c = (char) read;
                             jsonString += c;

                         }

                         final String finalJson = jsonString;
                         networkHandler.post(new Runnable() {
                             @Override
                             public void run() {

                                 // send data to main thread
                                 listener.APINetworkListener(finalJson);

                             }
                         });
                     }
                 } catch (MalformedURLException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                  // why finally? there is excption
                 finally {
                     httpURLConnection.disconnect();
                 }

             }
         });


         //


    }

}
