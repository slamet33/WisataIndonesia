package id.slametriyadi.wisataindonesia.AdapterActivity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import id.slametriyadi.wisataindonesia.Activity.ProvinsiActivity;
import id.slametriyadi.wisataindonesia.ApiRetrofit.InstanceRetrofit;
import id.slametriyadi.wisataindonesia.Interface.ILoadMore;
import id.slametriyadi.wisataindonesia.R;
import id.slametriyadi.wisataindonesia.Response.ListDataDaerah;


//class LoadingMyViewHolder extends RecyclerView.ViewHolder {
//
//    public ProgressBar progressBar;
//
//    public LoadingMyViewHolder(View itemView) {
//        super(itemView);
//
//        progressBar = itemView.findViewById(R.id.progressBar);
//    }
//}
//
//class ItemViewHolder extends RecyclerView.ViewHolder {
//
//    public ImageView imageWisata;
//    public TextView namaWisata;
//
//    public ItemViewHolder(View itemView) {
//        super(itemView);
//
//        imageWisata = itemView.findViewById(R.id.img);
//        namaWisata = itemView.findViewById(R.id.nama);
//    }
//}

public class RvHomeListAdapter extends RecyclerView.Adapter<RvHomeListAdapter.MyViewHolder> {

    private final int VIEW_TYPE_ITEM = 0, VIEW_TYPE_LOADING = 0;
    ILoadMore iLoadMore;
    boolean isLoading;
    int visibleThreshold = 5;
    int lastVisibleItem, totalItemCount;
    Context context;
    List<ListDataDaerah> dataItems = new ArrayList<>();

    public RvHomeListAdapter(RecyclerView recyclerView, Context context, List<ListDataDaerah> dataItems) {
        this.context = context;
        this.dataItems = dataItems;
    }

//    @Override
//    public int getItemViewType(int position) {
//        return dataItems.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
//    }

//    public void setiLoadMore(ILoadMore iLoadMore) {
//        this.iLoadMore = iLoadMore;
//    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final String url_image = InstanceRetrofit.WebUrl + "image/" + dataItems.get(position).getImageDaerah();
        Log.d("TAG", "" + InstanceRetrofit.WebUrl + "image/" + dataItems.get(position).getImageDaerah());
        holder.nama.setText(dataItems.get(position).getNamaDaerah());
        Glide.with(context)
                .load(url_image)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ProvinsiActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView nama;

        public MyViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            nama = itemView.findViewById(R.id.nama);
        }
    }
}



