package com.example.regisrationonkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.regisrationonkotlin.entity.Items

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val title:TextView = findViewById(R.id.item_list_title_detail)
        val text:TextView = findViewById(R.id.item_list_text)
        val image:ImageView = findViewById(R.id.item_list_image_detail)

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
        val itemImageName = intent.getStringExtra("itemImage")
        var items:List<Items>

        var userId = this.resources.getIdentifier(
            itemImageName,
            "drawable",
            this.packageName
        )

        image.setImageResource(userId)

        println(itemImageName)

    }
}