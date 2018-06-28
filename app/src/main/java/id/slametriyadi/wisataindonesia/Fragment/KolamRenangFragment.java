package id.slametriyadi.wisataindonesia.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.slametriyadi.wisataindonesia.ApiRetrofit.ApiService;
import id.slametriyadi.wisataindonesia.ApiRetrofit.InstanceRetrofit;
import id.slametriyadi.wisataindonesia.R;
import id.slametriyadi.wisataindonesia.Response.ListKolamRenang;
import id.slametriyadi.wisataindonesia.Response.ResponseKolamRenang;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class KolamRenangFragment extends Fragment {


    public KolamRenangFragment() {
        // Required empty public constructor
    }

    List<ListKolamRenang> kolamRenang;
    ApiService api = InstanceRetrofit.getInstance();
    KolamRenangAdapter kolamRenangAdapter;
    Boolean status;
    RecyclerView view;
    int idDaerah;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = new RecyclerView(getContext());
        view.setLayoutManager(new LinearLayoutManager(getContext()));
        getDataKolamRenang();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            idDaerah = bundle.getInt("idDaerah", 1);
        }
    }

    private void getDataKolamRenang() {
        Call<ResponseKolamRenang> call = api.response_read_kolamrenang();
        call.enqueue(new Callback<ResponseKolamRenang>() {
            @Override
            public void onResponse(Call<ResponseKolamRenang> call, Response<ResponseKolamRenang> response) {
                status = response.body().isSuccess();
                if (status) {
                    kolamRenang = response.body().getData();
                    kolamRenangAdapter = new KolamRenangAdapter(kolamRenang, getContext());
                    view.setAdapter(kolamRenangAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseKolamRenang> call, Throwable t) {

            }
        });
    }

    private class KolamRenangAdapter extends RecyclerView.Adapter<KolamRenangAdapter.MyViewHolder> {

        List<ListKolamRenang> kolamRenang;
        Context context;

        public KolamRenangAdapter(List<ListKolamRenang> kolamRenang, Context context) {
            this.kolamRenang = kolamRenang;
            this.context = context;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listkolamrenang, null, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            final String url_image = InstanceRetrofit.WebUrl + "image/kolamrenang/" + kolamRenang.get(position).getImgKolamrenang();

            int idDaerah =  Integer.valueOf(kolamRenang.get(position).getIdDaerah());

            if (idDaerah != 1)

            holder.judulKR.setText(kolamRenang.get(position).getNamaKolamrenang());
            holder.hargaKR.setText("Rp. "+ kolamRenang.get(position).getTiketKolamrenang());
            Glide.with(getContext())
                    .load(url_image)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.imageKR);
        }

        @Override
        public int getItemCount() {
            return kolamRenang.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView hargaKR, judulKR;
            ImageView imageKR;

            public MyViewHolder(View itemView) {
                super(itemView);
                hargaKR = itemView.findViewById(R.id.txtTiketKolamRenang);
                judulKR = itemView.findViewById(R.id.txtNamaKolamRenang);
                imageKR = itemView.findViewById(R.id.imgKolamRenang);
            }
        }
    }
}
