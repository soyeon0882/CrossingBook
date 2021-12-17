package com.example.crossingbook;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonService {



    //
    public ArrayList<Book> parseBooksAPIJson(String jsonBooks) {

        ArrayList<Book> allBooksFromAPI = new ArrayList<>(0);
       // DetailData detailData = new DetailData();

        try {

           // JSONArray jsonArray = new JSONArray(jsonBooks);
            JSONObject jsonObject = new JSONObject(jsonBooks);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            DetailData detailData = new DetailData();

       for(int i = 0; i<itemsArray.length(); i++) {

          // JSONObject itemsObj = itemsArray.getJSONObject(i);
          // JSONObject volumeObj = itemsObj.getJSONObject("volumeInfo");

           JSONObject itemsObj = itemsArray.getJSONObject(i).getJSONObject("volumeInfo");
           String title = itemsObj.getString("title");
           String description = itemsObj.getString("description");
           JSONObject imageLinks = itemsObj.optJSONObject("imageLinks");
           String thumbnail = imageLinks.getString("thumbnail");
           String publisher = itemsObj.getString("publisher");

//             String publishedDate = itemsObj.getString("publishedDate");
//            String description = itemsObj.getString("description");
//            JSONObject imageLinks = itemsObj.optJSONObject("imageLinks");
//            String thumbnail = imageLinks.getString("thumbnail");
//            detailData = new DetailData(title, publisher,publishedDate,description,thumbnail);

            Book book = new Book(title,description,thumbnail,publisher);
            allBooksFromAPI.add(book);

         }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return allBooksFromAPI;
    }

//
//
//    public DetailData parseDetailAPIData(String jsonBooks){
//        DetailData detailData = new DetailData();
//        try {
//
//            JSONObject jsonObject = new JSONObject(jsonBooks); //root
//            JSONArray itemsArray = jsonObject.getJSONArray("items");
//            JSONObject volumeObj = itemsArray.getJSONObject(0).getJSONObject("volumeInfo");
//
//             String title = volumeObj.getString("title");
//             String publisher = volumeObj.getString("publisher");
//             String publishedDate = volumeObj.getString("publishedDate");
//            String description = volumeObj.getString("description");
//            JSONObject imageLinks = volumeObj.optJSONObject("imageLinks");
//            String thumbnail = imageLinks.getString("thumbnail");
//            detailData = new DetailData(title, publisher,publishedDate,description,thumbnail);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return  detailData;
//    }

    //
}

