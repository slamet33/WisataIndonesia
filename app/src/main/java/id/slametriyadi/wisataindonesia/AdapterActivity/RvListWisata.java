package id.slametriyadi.wisataindonesia.AdapterActivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import id.slametriyadi.wisataindonesia.Activity.ProvinsiSecondActivity;
import id.slametriyadi.wisataindonesia.ApiRetrofit.InstanceRetrofit;
import id.slametriyadi.wisataindonesia.R;
import id.slametriyadi.wisataindonesia.Response.ListAirTerjun;

public class RvListWisata extends RecyclerView.Adapter<RvListWisata.MyViewHolder> {

    Context context;
    List<ListAirTerjun> listAirTerjun = new ArrayList<>();

    public RvListWisata(ProvinsiSecondActivity provinsiSecondActivity, List<ListAirTerjun> listAirTerjun) {
        this.context = provinsiSecondActivity;
        this.listAirTerjun = listAirTerjun;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(parent.getContext(), R.layout.listairterjun, null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d("TAF", ""+listAirTerjun.get(position).getImgAirterjun());
        final String url_image = InstanceRetrofit.WebUrl + "image/airterjun/" + listAirTerjun.get(position).getImgAirterjun();
        holder.namaAirTerjun.setText(listAirTerjun.get(position).getNamaAirterjun());
        Glide.with(context)
                .load(url_image)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageAirTerjun);
    }

    @Override
    public int getItemCount() {
        return listAirTerjun.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageAirTerjun;
        TextView namaAirTerjun;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageAirTerjun = itemView.findViewById(R.id.imgAirTerjun);
            namaAirTerjun = itemView.findViewById(R.id.txtAirTerjun);
        }
    }
}
