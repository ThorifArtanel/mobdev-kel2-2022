package cs.upi.edu.mobdevkel2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDataGuide extends RecyclerView.Adapter<ViewHolderDataGuide>{

    ArrayList<DataGuide> dataGuide;

    public AdapterDataGuide(ArrayList<DataGuide> dataGuide) {
        this.dataGuide = dataGuide;
    }

    @NonNull
    @Override
    public ViewHolderDataGuide onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_home_guide, parent, false);
        // jangan sampai lupa return viewholder, akan menyebabkan bug yang susah ditrace
        return new ViewHolderDataGuide(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDataGuide holder, int position) {
        DataGuide dg = dataGuide.get(position);
        holder.tv_title.setText(dg.getTitle());
        holder.tv_desc.setText(dg.getDesc());
        holder.iv_icon.setImageResource(dg.getImageId());
    }

    @Override
    public int getItemCount() {
        return dataGuide.size();
    }

}

