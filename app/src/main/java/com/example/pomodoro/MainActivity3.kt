package com.example.pomodoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pomodoro.databinding.ActivityMain3Binding
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain3Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(R.layout.activity_main3)


    }

        fun saveButton(view:View){
            val firstText=binding.editTextTextPersonName.text.toString()
            val titleText=binding.editTextTextPersonName2.text.toString()

            try {
                val database=this.openOrCreateDatabase("Artsss", MODE_PRIVATE,null)
                database.execSQL("CREATE TABLE IF NOT EXISTS arts (id INTEGER PRIMARY KEY,firsttext VARCHAR,titletext VARCHAR)")
                val sqlString="INSERT INTO arts (firsttext,titletext) VALUES(?,?)"
                val statment=database.compileStatement(sqlString)
                statment.bindString(1,firstText)
                statment.bindString(2,titleText)
                statment.execute()

            }catch (e:Exception){
                e.printStackTrace()
            }



    }
}