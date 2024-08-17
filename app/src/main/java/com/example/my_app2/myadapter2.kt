import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.my_app2.ItemModel
import com.example.my_app2.R

class MyAdapter2(private var items: List<ItemModel>) : RecyclerView.Adapter<MyAdapter2.MyViewHolder>() {


    private  lateinit var mListener : onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun onItemClickListener(listener: onItemClickListener){
        mListener = listener
    }


    class MyViewHolder(itemView: View,listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titletxt2)
        val scoreTextView: TextView = itemView.findViewById(R.id.scoretxt)
        val img:ImageView = itemView.findViewById(R.id.pic1)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_book, parent, false)
        return MyViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: MyAdapter2.MyViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleTextView.text = currentItem.title
        holder.scoreTextView.text = currentItem.score
        holder.img.setImageResource(currentItem.img)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private var itemsFull: List<ItemModel> = items.toList()

    fun filter(text: String) {
        items = if (text.isEmpty()) {
            itemsFull
        } else {
            itemsFull.filter { it.title.contains(text, ignoreCase = true) }
        }
        notifyDataSetChanged()
    }
}