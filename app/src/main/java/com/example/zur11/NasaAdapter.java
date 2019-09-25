package com.example.zur11;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

public class NasaAdapter extends RecyclerView.Adapter<NasaAdapter.ViewHolder> {

    private List<EpicNasa> data;


    public NasaAdapter(List<EpicNasa> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nasa_item,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        EpicNasa epicNasa=data.get(position);
        holder.tv.setText(epicNasa.getDate());



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //Create new Holder
    // 2) what do we

     static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv;  //date
        ImageView iv;  //epicImage
        //

       //
        public ViewHolder(@NonNull View v) {
            super(v);

            tv= v.findViewById(R.id.textView);
            iv= v.findViewById(R.id.iv);
        }
    }
}
