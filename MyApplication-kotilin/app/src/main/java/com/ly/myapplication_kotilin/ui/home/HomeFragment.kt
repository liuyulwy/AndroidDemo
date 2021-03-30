package com.ly.myapplication_kotilin.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ly.myapplication_kotilin.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val list: RecyclerView = root.findViewById(R.id.rv_list)
//        val layoutManager = LinearLayoutManager(this.context)
//        layoutManager.orientation = LinearLayoutManager.VERTICAL
        var layoutManager = GridLayoutManager(context, 4, RecyclerView.VERTICAL, false)
        list.layoutManager = layoutManager
        val data = arrayOf("1", "2", "3","1", "2", "3")
        val adapter = TypeItemAdapter(data)
        list.adapter = adapter
        adapter.onItemClick = {
            Log.d("11111","111")
        }

        return root
    }


    public class TypeItemAdapter(private val items: Array<String>): RecyclerView.Adapter<TypeItemAdapter.ViewHolder>(){
        var onItemClick:((Int)->Unit)?= null
        class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            var textView: TextView = view.findViewById(R.id.tv_item)

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.type_item, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = items[position]
            holder.itemView.setOnClickListener {
                onItemClick?.let { it1 -> it1(position) }
            }
        }

    }


}