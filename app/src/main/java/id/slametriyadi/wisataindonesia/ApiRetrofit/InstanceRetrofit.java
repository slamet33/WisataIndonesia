package id.slametriyadi.wisataindonesia.ApiRetrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hp on 3/27/2018.
 */

public class InstanceRetrofit {

    public static final String WebUrl = "http://slametriyadi.id/WisataIndonesia/";
//    public static final String WebUrl = "http://192.168.31.35/WisataIndonesia/";

    public static Retrofit setInit() {
        return new Retrofit.Builder()
                .baseUrl(WebUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstance() {
        return setInit().create(ApiService.class);
    }
}
