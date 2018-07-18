package burakekmen.com.youtubeplaylist

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/****************************
 * Created by Burak EKMEN   |
 * 17.07.2018               |
 * ekmen.burak@hotmail.com  |
 ***************************/
object ApiClient {

    val BASE_URL = "https://www.googleapis.com/youtube/v3/"
    private var retrofit:Retrofit? = null

    val client:Retrofit?
        get() {
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }

            return retrofit
        }

}