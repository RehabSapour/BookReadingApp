
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my_app2.R
import com.example.my_app2.inter_item
import com.google.android.material.imageview.ShapeableImageView



class detail_adapter(private val items: List<inter_item>) : RecyclerView.Adapter<detail_adapter.MyViewHolder>() {

    class MyViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView) {
        val img_writer: ShapeableImageView = itemView.findViewById(R.id.itemImges)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_detail_imges, parent, false)
        return MyViewHolder(view,)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = items[position]
        holder.img_writer.setImageResource(currentItem.img)

    }
    override fun getItemCount(): Int {
        return items.size
    }
}