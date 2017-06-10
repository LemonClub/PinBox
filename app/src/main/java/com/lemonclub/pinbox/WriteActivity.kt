package com.lemonclub.pinbox

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.lemonclub.pinbox.editor.EditorComponentAdapter
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : AppCompatActivity() {
    lateinit var editorAdapter: EditorComponentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
        setSupportActionBar(write_toolbar)
        supportActionBar!!.title = "글쓰기"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        editorAdapter = EditorComponentAdapter()

        write_container.layoutManager = LinearLayoutManager(applicationContext)
        write_container.adapter = editorAdapter
        write_container.setItemViewCacheSize(100)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                return true
            }
        }
        return false
    }
}