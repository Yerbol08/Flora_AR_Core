package com.enu.flora.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enu.flora.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root



        binding.recyclerViewVideo.setHasFixedSize(true)

        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        binding.recyclerViewVideo.layoutManager = mLayoutManager

        val videoIds = arrayOf(
            "88zXkWt_PZA",
            "88zXkWt_PZA",
            "88zXkWt_PZA",
            "88zXkWt_PZA",
            "88zXkWt_PZA",
            "88zXkWt_PZA",
            "88zXkWt_PZA",
            "88zXkWt_PZA",
            "88zXkWt_PZA",
            "88zXkWt_PZA",
            "88zXkWt_PZA",
            "88zXkWt_PZA"
        )

        val recyclerViewAdapter: RecyclerView.Adapter<*> = VideoAdapter(videoIds, this.lifecycle)
        binding.recyclerViewVideo.adapter = recyclerViewAdapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}