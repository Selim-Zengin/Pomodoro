package com.example.pomodoro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pomodoro.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var artList:ArrayList<Art>
    private lateinit var artAdaper:ArtAdaper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(R.layout.activity_main2)

            artList= ArrayList<Art>()
            artAdaper=ArtAdaper(artList)
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter=artAdaper

        try {
            val database=this.openOrCreateDatabase("Artsss", MODE_PRIVATE,null)

            val cursor=database.rawQuery("SELECT * FROM arts",null)
            val firsttTextIx=cursor.getColumnIndex("firsttext")
            val idIx=cursor.getColumnIndex("id")

            while (cursor.moveToNext()){
                val name = cursor.getString(firsttTextIx)
                val id = cursor.getInt(idIx)
                val art=Art(name, id)

                artAdaper.notifyDataSetChanged()
                artList.add(art)

            }
            cursor.close()
        }catch (e:Exception){
            e.printStackTrace()
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater=menuInflater
        menuInflater.inflate(R.menu.art_manu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.add_art_item){
            val intent= Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}