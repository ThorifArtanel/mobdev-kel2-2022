package cs.upi.edu.mobdevkel2.lib.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import cs.upi.edu.mobdevkel2.R;

public class AdapterHomeGuide extends RecyclerView.Adapter<AdapterHomeGuide.ViewHolderHomeGuide> {
    List<Guide> guideList;

    public AdapterHomeGuide(List<Guide> guideList) {
        this.guideList = guideList;
    }

    @NonNull
    @Override
    public ViewHolderHomeGuide onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_home_guide,parent,false);
        return new ViewHolderHomeGuide(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderHomeGuide holder, int position) {
        Guide g = guideList.get(position);
        holder.tvTitle.setText(g.getTitle());
        holder.tvDesc.setText(g.getDesc());
        new ImageLoadTask(g.getLogo(), holder.ivIcon).execute();
    }

    @Override
    public int getItemCount() {
        if (guideList != null) {
            Log.d("FetchGuide", "Size:"+guideList.size());
            return guideList.size();
        } else {
            Log.d("FetchGuide", "Size: 0");
            return 0;
        }

    }

    public class ViewHolderHomeGuide extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvDesc;
        ImageView ivIcon;
//        Button btnDetail;
        public ViewHolderHomeGuide(@NonNull View itemView){
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            ivIcon = itemView.findViewById(R.id.iv_icon);
//            btnDetail = itemView.findViewById(R.id.btn_detail);

        }
    }

    public class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {

        private String url;
        private ImageView imageView;

        public ImageLoadTask(String url, ImageView imageView) {
            this.url = url;
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                URL urlConnection = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) urlConnection
                        .openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            imageView.setImageBitmap(result);
        }

    }
}
