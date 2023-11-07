package com.example.regisrationonkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.regisrationonkotlin.adapter.ItemsAdapter
import com.example.regisrationonkotlin.entity.Items

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items: MutableList<Items> = mutableListOf()

        val item1 = Items(1, "stol", "Стол", "Прекрасный стол для рабочего кабинета", "Этот стол идеально подходит для вашего домашнего офиса.", 500)
        val item2 = Items(2, "creslo", "Кресло", "Удобное кресло с мягкой подушкой", "Это кресло обеспечит вам комфорт во время работы или отдыха.", 300)
        val item3 = Items(3, "schkaf", "Шкаф", "Просторный шкаф для одежды", "С этим шкафом вы легко организуете свою одежду.", 700)
        val item4 = Items(4, "lampa", "Лампа", "Современная настольная лампа", "Эта лампа добавит стиль в ваш интерьер.", 100)
        val item5 = Items(5, "komod", "Комод", "Компактный комод для хранения вещей", "Идеальное решение для небольших помещений.", 250)

        items.add(item1)
        items.add(item2)
        items.add(item3)
        items.add(item4)
        items.add(item5)

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)

    }
}