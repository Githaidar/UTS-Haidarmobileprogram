package pnj.uts.ti.haidar_aditya_baran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pnj.uts.ti.haidar_aditya_baran.model.Alumni

class AlumniAdapter(private val onActionClick: (Alumni, String) -> Unit) :
    RecyclerView.Adapter<AlumniAdapter.AlumniViewHolder>() {

    private var alumniList = mutableListOf<Alumni>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumniViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alumni, parent, false)
        return AlumniViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlumniViewHolder, position: Int) {
        holder.bind(alumniList[position])
    }

    override fun getItemCount(): Int = alumniList.size

    fun submitList(list: List<Alumni>) {
        alumniList = list.toMutableList()
        notifyDataSetChanged()
    }

    inner class AlumniViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNama: TextView = itemView.findViewById(R.id.tvNama)
        private val tvNim: TextView = itemView.findViewById(R.id.tvNim)
        private val btnEdit: Button = itemView.findViewById(R.id.btnEdit)
        private val btnDelete: Button = itemView.findViewById(R.id.btnDelete)

        fun bind(alumni: Alumni) {
            tvNama.text = alumni.nama
            tvNim.text = alumni.nim

            btnEdit.setOnClickListener {
                onActionClick(alumni, "edit")
            }

            btnDelete.setOnClickListener {
                onActionClick(alumni, "delete")
            }
        }
    }
}