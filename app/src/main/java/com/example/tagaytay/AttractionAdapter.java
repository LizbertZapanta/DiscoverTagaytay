package com.example.tagaytay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.ViewHolder> {

    //declare variables
    private final RecyclerViewInterface rvi;

    List<AttractionData> attractionDatas;
    Context context;


    // Constructor
    AttractionAdapter(RecyclerViewInterface rvi, List<AttractionData> attractionDatas, Context context) {
        this.rvi = rvi;
        this.attractionDatas = attractionDatas;
        this.context = context;

    }

    //Add unimplemented methods
    @NonNull
    @Override
    public AttractionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //set the layout for the view using my layoutinflater that will be then applied to the activity
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View view = layoutinflater.inflate(R.layout.attractions_list, parent, false);
        return new ViewHolder(view, rvi);
    }


    @Override
    public void onBindViewHolder(@NonNull AttractionAdapter.ViewHolder holder, int position) {
        //this is to set all widget resources
        holder.image.setImageResource(attractionDatas.get(position).getImage());
        holder.attraction.setText(attractionDatas.get(position).getAttraction());
       // holder.description.setText(attractionDatas.get(position).getDescription());
        // holder.address.setText(attractionDataList.getAdd());

    }

    @Override
    public int getItemCount() {
        return attractionDatas.size();
    }


    //ViewHolder that will be passed as parameter for the RecyclerView.Adapter
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //Declare variables
        ImageView image;
        TextView attraction;
        TextView description;
        TextView address;




        public ViewHolder(@NonNull View itemView, RecyclerViewInterface rvi) {
            super(itemView);
            image = itemView.findViewById(R.id.imageview);
            attraction = itemView.findViewById(R.id.attraction);
            //description = itemView.findViewById(R.id.description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rvi !=null){
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION){
                            rvi.onItemClick(position);
                        }
                    }
                }
            });
            itemView.setClickable(true);

        }



    }
}
