package burakekmen.com.youtubeplaylist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var gelenVeri:PlaylistData?=null
    var oynatmaListeleri:MutableList<PlaylistData.Item>?=null
    var myAdapter:PlaylistAdapter?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var apiInterface = ApiClient.client?.create(ApiInterface::class.java)
        var apiCall = apiInterface?.tumListeyiGetir(getString(R.string.CHANNEL_ID) , getString(R.string.API_KEY))

        apiCall?.enqueue(object : Callback<PlaylistData>{
            override fun onFailure(call: Call<PlaylistData>?, t: Throwable?) {

                Log.e("BASARISIZ", t?.message)
            }

            override fun onResponse(call: Call<PlaylistData>?, response: Response<PlaylistData>?) {
                Log.e("BASARILI", response?.message())

                gelenVeri = response?.body()
                oynatmaListeleri = gelenVeri?.items!!


                myAdapter = PlaylistAdapter(applicationContext, oynatmaListeleri)
                recyclerView_PlayList.adapter = myAdapter

                var myLayoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                recyclerView_PlayList.layoutManager = myLayoutManager

                Log.e("BASARILI", "TOPLAM OYNATMA LİSTESİ " + oynatmaListeleri?.size)
            }

        })

    }
}
