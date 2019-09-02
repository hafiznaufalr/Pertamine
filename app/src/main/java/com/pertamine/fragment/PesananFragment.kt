package com.pertamine.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.pertamine.R
import com.pertamine.activity.DetailStatus

class PesananFragment : Fragment() {

lateinit var pesanan: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pesanan, container, false)
pesanan = view.findViewById(R.id.pesanan)
        pesanan.setOnClickListener {
            val a = Intent(activity, DetailStatus::class.java)
            startActivity(a)

        }


        return view

    }

    companion object {
        fun newInstance(): PesananFragment {
            val fragment = PesananFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}