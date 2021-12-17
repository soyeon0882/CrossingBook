package com.example.crossingbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.TasksViewHolder> {

    interface bookClickListner {
        public void bookClicked(Book selectedBook);
    }
    private Context mBtx;
    public List<Book> bookList;
    bookClickListner listner;
    public BooksAdapter(Context mBtx, List<Book> bookList) {
        this.mBtx = mBtx;
        this.bookList = bookList;
        listner = (bookClickListner)mBtx;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mBtx).inflate(R.layout.recyclerview_books, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        Book b = bookList.get(position);
        holder.bookTextView.setText(b.getTitle());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView bookTextView;
        public TasksViewHolder(View itemView) {
            super(itemView);
            bookTextView = itemView.findViewById(R.id.book);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Book book = bookList.get(getAdapterPosition());
            listner.bookClicked(book);
        }
    }
}