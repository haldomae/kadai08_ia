package com.hal_domae.kadai08_ia

import android.os.Bundle
import android.widget.SimpleAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hal_domae.kadai08_ia.databinding.ActivityMainBinding
import com.hal_domae.kadai08_ia.recyclerview.ListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dbHelper: DatabaseHelper
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

        // データベースからデータ取得
        // データベースから取り出したデータを入れる変数
        val data = mutableListOf<Map<String, String>>()
        // データベースを用意
        dbHelper = DatabaseHelper(this@MainActivity)
        dbHelper.readableDatabase.use { db -> }

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
//        binding.diaryList.adapter = SimpleAdapter(
//            this,
//            sampleData,
//            R.layout.list_item,
//            arrayOf("date", "text"),
//            intArrayOf(R.id.date, R.id.text)
//        )
        // RecyclerViewの設定
        binding.diaryList.layoutManager = LinearLayoutManager(this)
        binding.diaryList.adapter = ListAdapter(sampleData)

        // 区切り線を付ける
        val dividerItemDecoration = DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
        binding.diaryList.addItemDecoration(dividerItemDecoration)
    }
}