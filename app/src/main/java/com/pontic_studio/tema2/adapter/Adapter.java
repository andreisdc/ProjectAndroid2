package com.pontic_studio.tema2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pontic_studio.tema2.R;
import com.pontic_studio.tema2.model.AnimalModel;

import java.util.ArrayList;
import java.util.Locale;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    public Adapter(ArrayList<AnimalModel> arrayList) {
        this.arrayList = arrayList;
    }

    public interface OnItemClickListener
    {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener)
    {
        listener = clickListener;
    }

    ArrayList<AnimalModel> arrayList;
    private Context context;
    private OnItemClickListener listener;



    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View v = layoutInflater.inflate(R.layout.animal_model, parent, false);

        return new MyViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        holder.textView.setText(arrayList.get(position).getName().toString());
        holder.textViewContinent.setText(arrayList.get(position).getContinent().toString());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private TextView textViewContinent;
        private ImageView deleteButton;
        public MyViewHolder(@NonNull View itemView, OnItemClickListener clickListener) {
            super(itemView);
            textView = itemView.findViewById(R.id.Animal);
            textViewContinent = itemView.findViewById(R.id.Continent);
            deleteButton = itemView.findViewById(R.id.ButtonDelete);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });

        }
    }

}
