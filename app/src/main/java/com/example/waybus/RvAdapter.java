package com.example.waybus;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.Viewholder> {

    private Context context;

    private static final String Tag = "Hari";
    ArrayList<String> mylist ;

    public RvAdapter(Context context, ArrayList<String> mylist) {
        this.mylist = mylist;
        this.context = context;


    }

    @NonNull
    @Override
    public RvAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.Viewholder holder, int position) {

        holder.courseNameTV.setText(mylist.get(position));
        holder.on.setVisibility(View.VISIBLE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, MapsActivity2.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {


        private TextView courseNameTV;
        ImageView on;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            on = itemView.findViewById((R.id.onoff));

        }
    }
}