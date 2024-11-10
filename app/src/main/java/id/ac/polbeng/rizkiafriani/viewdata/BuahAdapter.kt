package id.ac.polbeng.rizkiafriani.viewdata


import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.polbeng.rizkiafriani.viewdata.databinding.ListItemBinding

class BuahAdapter(
    private var context: Activity,
    private val dataBuah: List<String>,
    private val dataGambar: List<Int>
) : RecyclerView.Adapter<BuahAdapter.BuahHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            BuahHolder {
        val binding =
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent,
                false)
        return BuahHolder(binding)
    }

    //set data ke recylerview
    override fun onBindViewHolder(holder: BuahHolder, position: Int) {
        //manggil dan set data
        holder.binding.tvNamaBuah.text = dataBuah.get(position)
        holder.binding.imgBuah.setImageResource(dataGambar[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailBuahActivity::class.java)
            intent.putExtra("nama", dataBuah.get(position))
            intent.putExtra("gambar", dataGambar.get(position))
            context.startActivity(intent)
        }

    }

    //tampilkan data
    override fun getItemCount(): Int = dataBuah.size

    //deklarasi id pada customAdapter, id yang ada pada list_item
    inner class BuahHolder(val binding: ListItemBinding):
        RecyclerView.ViewHolder(binding.root)
}