package id.slametriyadi.wisataindonesia.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.slametriyadi.wisataindonesia.AdapterActivity.RvHomeListAdapter;
import id.slametriyadi.wisataindonesia.AdapterActivity.RvHomeListKategori;
import id.slametriyadi.wisataindonesia.ApiRetrofit.ApiService;
import id.slametriyadi.wisataindonesia.ApiRetrofit.InstanceRetrofit;
import id.slametriyadi.wisataindonesia.R;
import id.slametriyadi.wisataindonesia.Response.ListDataDaerah;
import id.slametriyadi.wisataindonesia.Response.ListKategori;
import id.slametriyadi.wisataindonesia.Response.ResponseReadDataDaerah;
import id.slametriyadi.wisataindonesia.Response.ResponseReadLogo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RvHomeListAdapter adapter;
    RvHomeListKategori adapterKategori;

    RecyclerView rvList, listKategori;
    List<ListDataDaerah> dataItems = new ArrayList<>();
    List<ListKategori> kategori = new ArrayList<>();
    SwipeRefreshLayout refreshLayout;
    ApiService api = InstanceRetrofit.getInstance();
    CardView cvProvinsi;
    Boolean status;

    private Toast toast;
    private long lastBackPressTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // NEW
        rvList = findViewById(R.id.rvHomeProvinsi);
        listKategori = findViewById(R.id.rvHomeKategori);
        cvProvinsi = findViewById(R.id.cvHomeProvinsi);
        setTitle(getIntent().getStringExtra("nama"));

        rvList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        getData();

        cvProvinsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeHomeActivity.this, ProvinsiActivity.class));
            }
        });

        listKategori.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        listKategori.setAdapter(adapterKategori);
        getKategori();

    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        if (this.lastBackPressTime < System.currentTimeMillis() - 4000) {
            toast = Toast.makeText(this, "Press back again to close this app", 4000);
            toast.show();
            this.lastBackPressTime = System.currentTimeMillis();
        } else {
            if (toast != null) {
                toast.cancel();
            }
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_terkenal) {
            // Handle the camera action
        } else if (id == R.id.nav_provinsi) {
            startActivity(new Intent(this, ProvinsiActivity.class));
        } else if (id == R.id.nav_kategori) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_rate) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // NEW

    private void getData() {
        ApiService api = InstanceRetrofit.getInstance();
        Call<ResponseReadDataDaerah> call = api.response_read_data();
        call.enqueue(new Callback<ResponseReadDataDaerah>() {
            @Override
            public void onResponse(Call<ResponseReadDataDaerah> call, Response<ResponseReadDataDaerah> response) {
                Boolean status = response.body().isSuccess();
                if (status) {
                    Log.d("TAG", "" + response.body().getData());
                    dataItems = response.body().getData();
                    adapter = new RvHomeListAdapter(rvList, HomeHomeActivity.this, dataItems);
                    rvList.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseReadDataDaerah> call, Throwable t) {

            }
        });
    }
    private void getKategori() {
        Call<ResponseReadLogo> call = api.response_read_logo();
        call.enqueue(new Callback<ResponseReadLogo>() {
            @Override
            public void onResponse(Call<ResponseReadLogo> call, Response<ResponseReadLogo> response) {
                status = response.body().isSuccess();
                if (status) {
                    Log.d("TAG", "" + response.body().getData());
                    kategori = response.body().getData();
                    adapterKategori = new RvHomeListKategori(HomeHomeActivity.this, kategori);
                    listKategori.setAdapter(adapterKategori);
                }
            }

            @Override
            public void onFailure(Call<ResponseReadLogo> call, Throwable t) {

            }
        });


    }
}
