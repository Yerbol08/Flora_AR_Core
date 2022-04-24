package com.enu.flora.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.enu.flora.R

class InfoActivity : AppCompatActivity() {
    var name:String =" "
    var image: Int = 0
    var text: String =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val nameTV = findViewById<TextView>(R.id.title)
        var imageView = findViewById<ImageView>(R.id.imageView)
        val infoTV = findViewById<TextView>(R.id.info)
        val position = getIntent().getIntExtra("position", 0)
        val title = getIntent().getStringExtra("name")
        val image = getIntent().getIntExtra("image", R.drawable.flower1)
        nameTV.setText(title)
        imageView.setImageResource(image)
        when(position){
            0-> infoTV.setText(R.string.info)
            1-> infoTV.setText(R.string.info2)
            2-> infoTV.setText(R.string.info3)
            3-> infoTV.setText(R.string.info4)
            4-> infoTV.setText(R.string.info5)
            5-> infoTV.setText(R.string.info6)
            6-> infoTV.setText(R.string.info7)
            7-> infoTV.setText(R.string.info8)
            8-> infoTV.setText(R.string.info9)
            9-> infoTV.setText(R.string.info10)
        }
    }
}