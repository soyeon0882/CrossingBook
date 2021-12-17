package com.example.crossingbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BooksAdapter.bookClickListner, NetworkingService.NetworkingListener {

    ArrayList<Book> books = new ArrayList<Book>();

    RecyclerView recyclerView;
    BooksAdapter adapter;
    NetworkingService networkingService;
    JsonService jsonService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.booksList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
      // books.add(new Book("Android));
        adapter = new BooksAdapter(this,books);
        recyclerView.setAdapter(adapter);
        setTitle("Search for new books..");

        networkingService = ( (myApp)getApplication()).getNetworkingService();
        jsonService = ( (myApp)getApplication()).getJsonService();

      //  adapter.listner = this;


        networkingService.listener = this;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchViewMenuItem = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) searchViewMenuItem.getActionView();
        String searchFor = searchView.getQuery().toString();
        if (!searchFor.isEmpty()) {
            searchView.setIconified(false);  //remove the search icon
            searchView.setQuery(searchFor, false);  //set querry, before submit no action happends
        }
        searchView.setQueryHint("Search for books");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("query", query);//add

                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("query change", newText);
                if (newText.length() >= 3) {
                    // seach for books
                    networkingService.fetchBookTitle(newText);
                }
                else {
                    adapter.bookList = new ArrayList<>(0); //if empty list no result show
                    adapter.notifyDataSetChanged();

                }
                return false;
            }
        });
        return true;
    }

    @Override
   public void bookClicked(Book selectedBook) {
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("SelectedBook",selectedBook.getTitle());
        intent.putExtra("SelectedDescription",selectedBook.getDescription());
        intent.putExtra("SelectedPublisher",selectedBook.getPublisher());
       // intent.getStringExtra("SelectedThumnail",selectedBook.getThumbnail());
        intent.putExtra("SelectedThumbnail",selectedBook.getThumbnail());
       // intent.

        startActivity(intent);
    }

    @Override
    public void APINetworkListener(String jsonString) {
       Log.d("tag",jsonString);
       books =  jsonService.parseBooksAPIJson(jsonString);
       adapter.bookList = books;
       adapter.notifyDataSetChanged(); // we should see the list the book

    }

//    @Override
//    public void APINetworkingListerForImage(Bitmap image) {
//
//    }
}
