package com.cscorner.universe.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.cscorner.universe.adapters.UgGridRV
import com.cscorner.universe.R
import com.cscorner.universe.viewmodel.UgModelViewModel
import com.cscorner.universe.model.UGYearModel

private lateinit var recyclerView: RecyclerView
private lateinit var adp:UgGridRV
private lateinit var viewModel: UgModelViewModel

class UggridFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
val view = inflater.inflate(R.layout.fragment_uggrid,container,false)






        val animation = view?.findViewById<LottieAnimationView>(R.id.animationuggrid)
        animation?.playAnimation()
        viewModel = ViewModelProvider(this).get(UgModelViewModel::class.java)
        recyclerView = view.findViewById(R.id.recyclerViewug)
recyclerView.layoutManager = GridLayoutManager(context,2)
        adp = UgGridRV { selectedUGyear ->
            onUGYearSelected(selectedUGyear)
        }

        recyclerView.adapter = adp

        viewModel.ugList.observe(viewLifecycleOwner, Observer { ugList -> adp.list(ugList) })


        return view
    }
     private fun onUGYearSelected(ugYear:UGYearModel){
         val action = UggridFragmentDirections.actionUggridFragmentToSemGridFragment(ugYearName = ugYear.name)
         findNavController().navigate(action)
     }


}