package id.slametriyadi.wisataindonesia.AdapterActivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import id.slametriyadi.wisataindonesia.ApiRetrofit.InstanceRetrofit;
import id.slametriyadi.wisataindonesia.Fragment.AirTerjunFragment;
import id.slametriyadi.wisataindonesia.Fragment.KolamRenangFragment;
import id.slametriyadi.wisataindonesia.Fragment.KulinerFragment;
import id.slametriyadi.wisataindonesia.Fragment.PantaiFragment;
import id.slametriyadi.wisataindonesia.R;
import id.slametriyadi.wisataindonesia.Response.ListKategori;

public class RvHomeListKategori extends RecyclerView.Adapter<RvHomeListKategori.MyViewHolder> {

    Context context;
    List<ListKategori> kategori;
    int kategorifinal;
    Fragment fragment;

    public RvHomeListKategori(Context context, List<ListKategori> kategori) {
        this.context = context;
        this.kategori = kategori;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(parent.getContext(), R.layout.listkategori, null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final AppCompatActivity activity = (AppCompatActivity) context;
        final String url_image = InstanceRetrofit.WebUrl + "logo/" + kategori.get(position).getLogo();
        holder.judulKategori.setText(kategori.get(position).getNamaKategori());
        Glide.with(context)
                .load(url_image)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.logoKategori);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kategori Activity SOON
            }
        });
    }

    @Override
    public int getItemCount() {
        return kategori.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView logoKategori;
        TextView judulKategori;

        public MyViewHolder(View itemView) {
            super(itemView);
            logoKategori = itemView.findViewById(R.id.logokategori);
            judulKategori = itemView.findViewById(R.id.judulkategori);
        }
    }
}


