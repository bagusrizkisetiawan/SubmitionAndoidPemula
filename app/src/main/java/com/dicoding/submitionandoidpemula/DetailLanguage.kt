package com.dicoding.submitionandoidpemula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailLanguage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_language)

        val photo = intent.getIntExtra("EXTRA_PHOTO", 0)
        val name = intent.getStringExtra("EXTRA_NAME")
        val description = intent.getStringExtra("EXTRA_DESCRIPTION")

        val ivPhoto = findViewById<ImageView>(R.id.ivPhoto)
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvDescription = findViewById<TextView>(R.id.tvdescription)

        ivPhoto.setImageResource(photo)
        tvName.text = name
        tvDescription.text = description

        supportActionBar?.title = "Detail Language"
    }
}