package com.example.crossingbook;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
//import com.squareup.picasso.Picasso;
import androidx.appcompat.app.AppCompatActivity;

//import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements NetworkingService.NetworkingListener {

    String title, description, publisher,authors,thumbnail;

  //  String publisher, publishedDate, description, thumbnail;
    TextView bookTitletext;
    TextView descriptionText;
    TextView publisherText;
    TextView authorsText;
    ImageView imageView;
  //  public static ArrayList<Book> booklist;

   // NetworkingService networkingService;
    //JsonService jsonService;
    //BooksAdapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        //initalizing our views

     //   networkingService.fetchDetailData(title);
        title = getIntent().getStringExtra("SelectedBook");
        description = getIntent().getStringExtra("SelectedDescription");
        publisher = getIntent().getStringExtra("SelectedPublisher");

        thumbnail = getIntent().getStringExtra("SelectedThumbnail");



        bookTitletext = findViewById(R.id.title);
        bookTitletext.setText(title);
        descriptionText = findViewById(R.id.description);
        descriptionText.setText(description);
        publisherText = findViewById(R.id.publisher);
        publisherText.setText(publisher);

        authorsText = findViewById(R.id.authors);
        authorsText.setText(authors);
        imageView = findViewById(R.id.image);
     //   Picasso.get().load(thumbnail).into(imageView);


     //Glide.with(this).load(thumbnail).into(imageView);

//
//        URL urlObj = new URL(thumbnail);
//        InputStream in = ((InputStream)urlObj.getContent());
//        Bitmap imageData = BitmapFactory.decodeStream(in);
//        networkingService = ( (myApp)getApplication()).getNetworkingService();
//        jsonService = ( (myApp)getApplication()).getJsonService();
//        networkingService.listener = this;



    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void APINetworkListener(String jsonString) {

//       DetailData detailData = jsonService.parseDetailAPIData(jsonString);
//
//      descriptionText.setText(detailData.description);
//      authorsText.setText(detailData.authors);

    }

//    @Override
//    public void APINetworkListner(String jsonString) {
//        WeatherData weatherData = jsonService.parseWeatherAPIData(jsonString);
//        weatherText.setText(weatherData.description + " : "+weatherData.temp );
//        networkingService.getImageData(weatherData.icon);
//    }
//
//    @Override
//    public void APINetworkingListerForImage(Bitmap image) {
//        imageView.setImageBitmap(image);
//    }
}


