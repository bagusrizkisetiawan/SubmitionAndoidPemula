package com.dicoding.submitionandoidpemula

import android.app.ActionBar
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvLanguage: RecyclerView

    private val list = ArrayList<Language>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvLanguage = findViewById(R.id.rv_language)
        rvLanguage.setHasFixedSize(true)

        list.addAll(getListLanguage())
        showRecyclerList()

        val actionBar: androidx.appcompat.app.ActionBar? = supportActionBar
        actionBar?.setBackgroundDrawable(resources.getDrawable(R.color.primary))

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, About::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }



    private fun getListLanguage(): ArrayList<Language> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listLanguage = ArrayList<Language>()
        for (i in dataName.indices) {
            val hero = Language(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listLanguage.add(hero)
        }
        return listLanguage
    }

    private fun showRecyclerList() {
        rvLanguage.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListLanguageAdapter(list)
        rvLanguage.adapter = listHeroAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}