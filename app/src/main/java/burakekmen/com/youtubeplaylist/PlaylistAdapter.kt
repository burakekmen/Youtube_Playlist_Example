package burakekmen.com.youtubeplaylist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/****************************
 * Created by Burak EKMEN   |
 * 17.07.2018               |
 * ekmen.burak@hotmail.com  |
 ***************************/
class PlaylistAdapter(context:Context, list:MutableList<PlaylistData.Item>?) : RecyclerView.Adapter<PlayListViewHolder>() {

    var oynatmaListeleri = list
    var context = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListViewHolder {
       var inflater = LayoutInflater.from(parent?.context).inflate(R.layout.playlist_item, parent, false)

        return PlayListViewHolder(inflater)
    }


    override fun onBindViewHolder(holder: PlayListViewHolder, position: Int) {

        var list_item = getItem(position)

        holder.item_name?.text = list_item?.snippet?.title
        Picasso.with(context).load(list_item?.snippet?.thumbnails?.high?.url).into(holder.item_image)

    }


    private fun getItem(position: Int) : PlaylistData.Item?{
        return oynatmaListeleri?.get(position)
    }

    override fun getItemCount(): Int {
        return oynatmaListeleri!!.size
    }


}


class PlayListViewHolder(item:View?) :RecyclerView.ViewHolder(item){

    var item_image = item?.findViewById<ImageView>(R.id.img_List_item_image)
    var item_name = item?.findViewById<TextView>(R.id.tx_List_item_name)

}
