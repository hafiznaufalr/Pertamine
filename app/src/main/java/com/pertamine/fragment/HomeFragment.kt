package com.pertamine.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.pertamine.R
import com.pertamine.activity.Belicvtivity
import com.pertamine.activity.FaqActivity
import com.pertamine.activity.NearbyActivity

class HomeFragment : Fragment() {

    lateinit var btn_belanja: ImageView
    lateinit var btn_nearby: ImageView
    lateinit var btn_faq: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        btn_belanja = view.findViewById(R.id.btn_belanja)
        btn_belanja.setOnClickListener {
            val a =  Intent(activity, Belicvtivity::class.java)
            startActivity(a)
        }
        btn_nearby = view.findViewById(R.id.btn_nearby)
        btn_nearby.setOnClickListener {
           val a =  Intent(activity, NearbyActivity::class.java)
            startActivity(a)
        }

        btn_faq = view.findViewById(R.id.btn_faq)
        btn_faq.setOnClickListener {
            val a =  Intent(activity, FaqActivity::class.java)
            startActivity(a)
        }

        return view

    }

    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}