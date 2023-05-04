package com.cabret.projetoler.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.cabret.projetoler.R
import com.cabret.projetoler.modals.GridViewModal

internal class GridViewAdapter (
    private val listaLivros: List<GridViewModal>,
    private val context: Context
) : BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var titulo: TextView
    private lateinit var autor: TextView
    private lateinit var image: ImageView

    override fun getCount(): Int {
        return listaLivros.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView

        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.gridview_item, null)
        }

        autor = convertView!!.findViewById(R.id.autor_textView)
        titulo = convertView!!.findViewById(R.id.titulo_textView)
        image = convertView!!.findViewById(R.id.capa_imageView)

        image.setImageResource(listaLivros.get(position).image)
        titulo.setText(listaLivros.get(position).titulo)
        autor.setText(listaLivros.get(position).autor)
        return convertView
    }
}