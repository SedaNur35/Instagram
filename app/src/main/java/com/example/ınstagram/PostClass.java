package com.example.ınstagram;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PostClass extends ArrayAdapter<String> {
   private final ArrayList<String> username;
   private final ArrayList<String> userComment;
   private final ArrayList<Bitmap> userImage;
   private final Activity context;

   public PostClass( ArrayList<String> username,ArrayList<String> userComment,ArrayList<Bitmap> userImage,Activity context){

      super(context,R.layout.custom_view,username);
       this.username = username;
       this.userComment = userComment;
       this.userImage = userImage;
       this.context = context;
   }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        @SuppressLint("ViewHolder") View customView = layoutInflater.inflate(R.layout.custom_view,null,true);
        TextView usernameText = customView.findViewById(R.id.username_text);
        TextView commentText = customView.findViewById(R.id.comment_text);
        ImageView  imageViewText= customView.findViewById(R.id.imageView_text);

        usernameText.setText(username.get(position));
        commentText.setText(userComment.get(position));
        imageViewText.setImageBitmap(userImage.get(position));

        return customView;
    }
}
