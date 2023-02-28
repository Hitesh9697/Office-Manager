package com.app.officemanager.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.officemanager.data.model.NavigationDrawerModel
import com.app.officemanager.databinding.RowNavigationDrawerListViewBinding
import com.app.officemanager.ui.interfaces.OnRecyclerItemClick

class NavigationDrawerAdapter(
    private val navigationDrawerModelList: ArrayList<NavigationDrawerModel>,
    private val onRecyclerItemClick: OnRecyclerItemClick
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        val TAG: String = Companion::class.java.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NavigationDrawerViewHolder(
            RowNavigationDrawerListViewBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return navigationDrawerModelList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        try {
            with(holder as NavigationDrawerViewHolder) {
                binding.apply {
                    itemView.setOnClickListener { onRecyclerItemClick.onRecyclerItemClick(position) }
                    menuIcon.setImageResource(navigationDrawerModelList[position].imageId)
                    tvMenuText.text = itemView.context.getText(navigationDrawerModelList[position].textId)
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }
    }

    class NavigationDrawerViewHolder(val binding: RowNavigationDrawerListViewBinding) :
        RecyclerView.ViewHolder(binding.root)
}