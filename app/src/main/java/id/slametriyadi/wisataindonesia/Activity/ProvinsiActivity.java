package id.slametriyadi.wisataindonesia.Activity;

import android.support.v4.app.NavUtils;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import id.slametriyadi.wisataindonesia.ApiRetrofit.ApiService;
import id.slametriyadi.wisataindonesia.ApiRetrofit.InstanceRetrofit;
import id.slametriyadi.wisataindonesia.R;
import id.slametriyadi.wisataindonesia.AdapterActivity.RvListAdapter;
import id.slametriyadi.wisataindonesia.Response.ListDataDaerah;
import id.slametriyadi.wisataindonesia.Response.ResponseReadDataDaerah;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProvinsiActivity extends AppCompatActivity {

    RvListAdapter adapter;
    RecyclerView rvList;
    List<ListDataDaerah> dataItems = new ArrayList<>();
    SwipeRefreshLayout refreshLayout;
    Boolean isScrooling = false;
    int currentItems, totalItems, scroolOutItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provinsi);

        rvList = findViewById(R.id.rvList);
        refreshLayout = findViewById(R.id.swipe);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshingLayout();
            }
        });

        rvList.setLayoutManager(new LinearLayoutManager(this));
        getData();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void refreshingLayout() {
        getData();
        onItemsLoadComplete();
    }

    private void onItemsLoadComplete() {
        adapter = new RvListAdapter(rvList, ProvinsiActivity.this, dataItems);
        rvList.setAdapter(adapter);
        refreshLayout.setRefreshing(false);
    }

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
                    adapter = new RvListAdapter(rvList, ProvinsiActivity.this, dataItems);
                    rvList.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseReadDataDaerah> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
