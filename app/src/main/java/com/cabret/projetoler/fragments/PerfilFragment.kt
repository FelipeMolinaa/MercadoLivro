package com.cabret.projetoler.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.cabret.projetoler.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class PerfilFragment : Fragment() {

    lateinit var perfilFragment: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        perfilFragment = inflater.inflate(R.layout.fragment_perfil, container, false)
        perfilFragment.findViewById<Button>(R.id.fragmentPerfilConnetButton).setOnClickListener{
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, UserFragment())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }

        return perfilFragment;
    }
}