package com.example.homeworkweek3day4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecyclerVewAdapter extends RecyclerView.Adapter<MyRecyclerVewAdapter.ViewHolder> {

    //List of User that will be populated into the recycler view
    ArrayList<User> userArrayList;


    //Constructor for the Adapter
    public MyRecyclerVewAdapter(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerVewAdapter.ViewHolder viewHolder, final int position) {
        //Get the item's information which we wish to populate for that viewholder
        User currentUserBeingPopulated = userArrayList.get(position);
        //use the passed viewholder to access the items view and populate
        viewHolder.tvUserName.setText(currentUserBeingPopulated.getName());
        viewHolder.tvUserEmail.setText(currentUserBeingPopulated.getEmail());
        viewHolder.tvUserPassword.setText(currentUserBeingPopulated.getPassword());

        Log.d("TAG", "onBindViewHolder: item being rendered = " + position);
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }
    //Inner class view container.  This container holds the views that we will use for each item.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserName;
        TextView tvUserEmail;
        TextView tvUserPassword;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvUserEmail = itemView.findViewById(R.id.tvUsetImail);
            tvUserPassword = itemView.findViewById(R.id.tvUsetPassword);
        }
    }
}
