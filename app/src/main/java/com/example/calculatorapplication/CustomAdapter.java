package com.example.calculatorapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
   // private ArrayList<String> id;
    private ArrayList<String> input,output;
    public CustomAdapter(Context context,ArrayList<String> input,ArrayList<String> output){
       this.context = context;
       this.input = input;
       //this.id = id;
       this.output = output;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       //  holder.id1.setText(String.valueOf(id.get(position))); remove id
        holder.input1.setText(String.valueOf(input.get(position)));
        holder.output1.setText(String.valueOf(output.get(position)));
    }

    @Override
    public int getItemCount() {
        return input.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView id1,input1,output1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
          //  id1 = itemView.findViewById(R.id.id);  //remove id
            input1 = itemView.findViewById(R.id.input);
            output1 = itemView.findViewById(R.id.output);
        }
    }
}
