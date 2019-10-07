package com.dev.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ProgrammingViewHolder> {

    private String[] data;
    private int[] data2;

    List list;


    public ProgrammingAdapter(List<DataModel> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_view_layout,parent,false);
        return new ProgrammingViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {
        String title =  ((DataModel) list.get(position)).name.toString();
        holder.txtTitle.setText(title);

        int img =   ((DataModel)list.get(position)).img;
        holder.imgIcon.setBackgroundResource(img);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }





    public void updateList(ArrayList<DataModel> newList){
        list = new ArrayList<>();
        list.addAll(newList);
        notifyDataSetChanged();
    }



    public class ProgrammingViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView txtTitle;

        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);

            imgIcon = (ImageView) itemView.findViewById(R.id.imageView);
            txtTitle = (TextView) itemView.findViewById(R.id.textView2);
        }
    }


}
