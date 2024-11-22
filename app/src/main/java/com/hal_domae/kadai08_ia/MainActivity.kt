package com.hal_domae.kadai08_ia

import android.os.Bundle
import android.widget.SimpleAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hal_domae.kadai08_ia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sampleData = mutableListOf(
            mapOf("date" to "2024/01/01", "text" to "ここに日記のテキストが入ります"),
            mapOf("date" to "2024/02/01", "text" to "ここに日記のテキストが入ります"),
            mapOf("date" to "2024/03/01", "text" to "ここに日記のテキストが入ります"),
            mapOf("date" to "2024/04/01", "text" to "ここに日記のテキストが入ります"),
            mapOf("date" to "2024/05/01", "text" to "ここに日記のテキストが入ります"),
            mapOf("date" to "2024/06/01", "text" to "ここに日記のテキストが入ります"),
            mapOf("date" to "2024/07/01", "text" to "ここに日記のテキストが入ります"),
            mapOf("date" to "2024/08/01", "text" to "ここに日記のテキストが入ります"),
        )
        binding.diaryList.adapter = SimpleAdapter(
            this,
            sampleData,
            R.layout.list_item,
            arrayOf("date", "text"),
            intArrayOf(R.id.date, R.id.text)
        )
    }
}