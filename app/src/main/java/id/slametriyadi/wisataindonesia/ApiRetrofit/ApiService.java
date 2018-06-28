package id.slametriyadi.wisataindonesia.ApiRetrofit;

import id.slametriyadi.wisataindonesia.Response.ResponseKolamRenang;
import id.slametriyadi.wisataindonesia.Response.ResponseReadAirTerjun;
import id.slametriyadi.wisataindonesia.Response.ResponseReadDataDaerah;
import id.slametriyadi.wisataindonesia.Response.ResponseReadLogo;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hp on 3/27/2018.
 */
// TODO This is EndPoint

public interface ApiService {
    //Api
    @GET("read_data.php")
    Call<ResponseReadDataDaerah> response_read_data();

    @GET("read_kategori.php")
    Call<ResponseReadLogo> response_read_logo();

    @GET("read_tbAirTerjun.php")
    Call<ResponseReadAirTerjun> response_read_airterjun();

    @GET("read_tbKolamRenang.php")
    Call<ResponseKolamRenang> response_read_kolamrenang();

}