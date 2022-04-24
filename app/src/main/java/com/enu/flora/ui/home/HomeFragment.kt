package com.enu.flora.ui.home

import ItemsHome
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.enu.flora.R
import com.enu.flora.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        val data = arrayListOf<ItemsHome>()
        data.add(ItemsHome(R.drawable.flower1, "Қалқан асаймұса, қалқанды асаймұса" ))
        data.add(ItemsHome(R.drawable.flora1, "Шолпаншаш сүмбілі" ))
        data.add(ItemsHome(R.drawable.flora3, "Линчевский кемпіршөбі" ))
        data.add(ItemsHome(R.drawable.flora4, "Жұмыр бозтүк" ))
        data.add(ItemsHome(R.drawable.flora5, "Корольков шаяноты" ))
        data.add(ItemsHome(R.drawable.flora6, "Мияжапырақ таспа" ))
        data.add(ItemsHome(R.drawable.flora7, "Ірі гүлді шолпанкебіс"))
        data.add(ItemsHome(R.drawable.flora8, "Секпіл шолпанкебіс"))
        data.add(ItemsHome(R.drawable.flora9, "Сары лапыз"))
        data.add(ItemsHome(R.drawable.flora10, "Кессельринг лапызы"))

        val adapter = context?.let { AdapterHome(data, it) }
        binding.recyclerView.adapter = adapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}