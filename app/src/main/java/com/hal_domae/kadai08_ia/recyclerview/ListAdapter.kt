package com.hal_domae.kadai08_ia.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hal_domae.kadai08_ia.EditActivity
import com.hal_domae.kadai08_ia.R

class ListAdapter(private val data: MutableList<Map<String, String>>): RecyclerView.Adapter<ViewHolder>() {
    // ViewHolderを作成する
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false))
    }

    // 表示するデータの件数を調べる
    override fun getItemCount(): Int {
        return data.size
    }

    // ViewHolderの中身を変更
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val date = data[position]["date"]
        val text = data[position]["text"]

        holder.itemDate.text = date
        holder.itemText.text = text

        // 日記の項目を押した時の処理
        holder.itemView.setOnClickListener {
            it.context.startActivity(
                Intent(it.context, EditActivity::class.java).apply {
                    putExtra("DIARY_DATE", date)
                    putExtra("DIARY_TEXT", text)
                }
            )
        }
    }

}