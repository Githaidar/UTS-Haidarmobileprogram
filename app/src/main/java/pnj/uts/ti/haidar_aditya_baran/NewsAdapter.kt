package pnj.uts.ti.haidar_aditya_baran
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import pnj.uts.ti.haidar_aditya_baran.NewsItem
import pnj.uts.ti.haidar_aditya_baran.R


class NewsAdapter (context: Context, private val newsList: List<NewsItem>) :
    ArrayAdapter<NewsItem>(context, 0, newsList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.fragment_berita, parent, false)
        }

        val currentItem = newsList[position]

        val imageNews = itemView?.findViewById<ImageView>(R.id.imageNews)
        val textTitle = itemView?.findViewById<TextView>(R.id.textTitle)
        val textDescription = itemView?.findViewById<TextView>(R.id.textDescription)

        imageNews?.setImageResource(currentItem.imageResId)
        textTitle?.text = currentItem.title
        textDescription?.text = currentItem.description

        return itemView!!
    }
}