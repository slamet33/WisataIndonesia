package id.slametriyadi.wisataindonesia.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import id.slametriyadi.wisataindonesia.AdapterActivity.RvListKategori;
import id.slametriyadi.wisataindonesia.ApiRetrofit.ApiService;
import id.slametriyadi.wisataindonesia.ApiRetrofit.InstanceRetrofit;
import id.slametriyadi.wisataindonesia.R;
import id.slametriyadi.wisataindonesia.Response.ListAirTerjun;
import id.slametriyadi.wisataindonesia.Response.ListKategori;
import id.slametriyadi.wisataindonesia.Response.ResponseReadLogo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProvinsiSecondActivity extends AppCompatActivity {

    RecyclerView listKategori;
    RvListKategori rvListKategori;
    List<ListKategori> kategori = new ArrayList<>();
    List<ListAirTerjun> listAirTerjun = new ArrayList<>();
    ImageView imgCollapsing;
    final String url_image = InstanceRetrofit.WebUrl + "image/";
    ApiService api = InstanceRetrofit.getInstance();
    Boolean status;
    String idDaerah;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listKategori = findViewById(R.id.listkategori);
        imgCollapsing = findViewById(R.id.CollapsingImage);

        idDaerah = getIntent().getStringExtra("idDaerah");

        setTitle(getIntent().getStringExtra("nama"));
        Glide.with(this)
                .load(url_image + getIntent().getStringExtra("gambar"))
                .placeholder(R.mipmap.ic_launcher)
                .into(imgCollapsing);


        listKategori.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        listKategori.setAdapter(rvListKategori);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getKategori();
    }

    private void getKategori() {
        Call<ResponseReadLogo> call = api.response_read_logo();
        call.enqueue(new Callback<ResponseReadLogo>() {
            @Override
            public void onResponse(Call<ResponseReadLogo> call, Response<ResponseReadLogo> response) {
                status = response.body().isSuccess();
                if (status) {
                    Log.d("TAG", ""+response.body().getData());
                    kategori = response.body().getData();
                    rvListKategori = new RvListKategori(ProvinsiSecondActivity.this, kategori, idDaerah);
                    listKategori.setAdapter(rvListKategori);
                }
            }

            @Override
            public void onFailure(Call<ResponseReadLogo> call, Throwable t) {

            }
        });


    }
}