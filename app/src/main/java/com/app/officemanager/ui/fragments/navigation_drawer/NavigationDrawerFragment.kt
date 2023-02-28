package com.app.officemanager.ui.fragments.navigation_drawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.officemanager.R
import com.app.officemanager.data.model.NavigationDrawerModel
import com.app.officemanager.databinding.FragmentNavigationDrawerBinding
import com.app.officemanager.ui.adapters.NavigationDrawerAdapter
import com.app.officemanager.ui.fragments.BaseFragment
import com.app.officemanager.ui.interfaces.OnRecyclerItemClick


class NavigationDrawerFragment : BaseFragment(), OnRecyclerItemClick {
    private lateinit var binding: FragmentNavigationDrawerBinding
    private val navigationDrawerModelList: ArrayList<NavigationDrawerModel> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNavigationDrawerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    override fun initView() {
        with(navigationDrawerModelList) {
            clear()
            add(NavigationDrawerModel(R.drawable.ic_ticket_tracker, R.string.ticket_tracker))
            add(NavigationDrawerModel(R.drawable.ic_contact_us, R.string.contact_us))
            add(NavigationDrawerModel(R.drawable.ic_privacy_policy, R.string.privacy_policy))
            add(NavigationDrawerModel(R.drawable.ic_settings, R.string.settings))
            add(NavigationDrawerModel(R.drawable.ic_logout, R.string.logout))
        }
        binding.apply {
            rvNavigationDrawer.adapter = NavigationDrawerAdapter(navigationDrawerModelList, this@NavigationDrawerFragment)
        }


    }

    override fun initListener() {
        TODO("Not yet implemented")
    }

    override fun initObserver() {
        TODO("Not yet implemented")
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    override fun onRecyclerItemClick(position: Int) {
        when(position) {

        }
    }

}