package cs.upi.edu.mobdevkel2.lib.models;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import cs.upi.edu.mobdevkel2.R;

public class ViewHolderDataGuide extends RecyclerView.ViewHolder {
    public TextView tv_title, tv_desc;
    public ImageView iv_icon;
    public Button btn_detail;

    public ViewHolderDataGuide(View itemView) {
        super(itemView);
        tv_title = itemView.findViewById(R.id.tv_title);
        tv_desc = itemView.findViewById(R.id.tv_desc);
        iv_icon = itemView.findViewById(R.id.iv_icon);
        btn_detail = itemView.findViewById(R.id.btn_detail);
        btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pesan = "Elemen yg ditap:" + getAdapterPosition();
                Toast toast = Toast.makeText(v.getContext(),pesan,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
