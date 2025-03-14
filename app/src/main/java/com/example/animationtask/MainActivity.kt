package com.example.animationtask

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = listOf(
            Item("Item 1"),
            Item("Item 2"),
            Item("Item 3"),
            Item("Item 4"),
            Item("Item 5"),
            Item("Item 6"),
            Item("Item 7"),
            Item("Item 8"),
            Item("Item 9"),
            Item("Item 10"),
            Item("Item 11"),
            Item("Item 12"),
            Item("Item 13"),
            Item("Item 14"),
            Item("Item 15"),
            Item("Item 16"),
            Item("Item 17"),
            Item("Item 18"),
        )

        val adapter = ItemAdapter(items)
        recyclerView.adapter = adapter
    }
}