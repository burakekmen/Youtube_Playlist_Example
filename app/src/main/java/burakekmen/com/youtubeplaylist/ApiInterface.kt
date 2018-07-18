package burakekmen.com.youtubeplaylist

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/****************************
 * Created by Burak EKMEN   |
 * 17.07.2018               |
 * ekmen.burak@hotmail.com  |
 ***************************/
interface ApiInterface {

    //https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UCN_V791tLlk1DwJhV0_5tLQ&maxResults=50&key={YOUR_API_KEY}

    @GET("playlists?part=snippet")
    fun tumListeyiGetir(@Query("channelId") channelId:String, @Query("key") apiKey:String):Call<PlaylistData>
}