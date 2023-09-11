package com.cabret.projetoler.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.cabret.projetoler.R

class UserFragment : Fragment() {

    lateinit var userFragment: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        userFragment = inflater.inflate(R.layout.fragment_user, container, false)

        var userImage = userFragment.findViewById<ImageView>(R.id.userFragmentUserImage);
        var base64String = "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"
        val imageBytes = Base64.decode(base64String, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
        userImage.setImageBitmap(decodedImage)
        return userFragment
    }
}