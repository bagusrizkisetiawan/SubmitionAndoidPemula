package com.dicoding.submitionandoidpemula

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class About : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)


        val btnWebsite = findViewById<Button>(R.id.btn_website)
        btnWebsite.setOnClickListener(this)

        supportActionBar?.title = "About Me"
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.btn_website -> {
                val url = "https://www.bagusrizki.com"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        }
    }
}