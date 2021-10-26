package com.softradix.templis.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.softradix.templis.adapter.HorizontalSlidingAdapter
import com.softradix.templis.adapter.RecyclerAdapter
import com.softradix.templis.adapter.SlidingAdapter
import com.softradix.templis.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var binding: HomeFragmentBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.list.set3DItem(true)
        binding.list.setLoop()
        binding.list.setGreyItem(true)
        binding.list.setIntervalRatio(.25f)

        binding.list.adapter = HorizontalSlidingAdapter {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
            findNavController().navigate(action)
        }

        binding.list.setOnItemSelectedListener {
//            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
//            findNavController().navigate(action)
        }


        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = RecyclerAdapter(requireActivity()) {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
                findNavController().navigate(action)
            }
        }


//        binding.tabLayout.setViewPager(binding.pager,
//            TITLE_NAME_LIST.toTypedArray(),
//            requireActivity(),
//            arrayListOf(HomeFragment(),MoviesFragment(),TvFragment(),SportsFragment())
//            )


    }


}