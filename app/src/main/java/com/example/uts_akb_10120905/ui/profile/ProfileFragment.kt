package com.example.uts_akb_10120905.ui.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.uts_akb_10120905.R

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageButtonwa = view.findViewById<ImageButton>(R.id.waicon)
        imageButtonwa.setOnClickListener {
            val url = "https://wa.me/08111111111"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        val imageButtonig = view.findViewById<ImageButton>(R.id.igicon)
        imageButtonig.setOnClickListener {
            val url = "https://www.instagram.com/johndypanca/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)

        }
        val imageButtonmail = view.findViewById<ImageButton>(R.id.emailicon)
        imageButtonmail.setOnClickListener {
            val url = "mailto:johndypanca12345@gmail.com"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        val imageButtonmap = view.findViewById<ImageButton>(R.id.mapicon)
        imageButtonmap.setOnClickListener {
            val url = "https://goo.gl/maps/M9dDqvRQuGD7i3Wu9"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}