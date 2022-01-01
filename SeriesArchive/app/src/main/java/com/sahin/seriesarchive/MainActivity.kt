package com.sahin.seriesarchive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.sahin.seriesarchive.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var seriesList:ArrayList<Series>
    private lateinit var seriesAdapter: SeriesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        seriesList= ArrayList<Series>()


        seriesAdapter= SeriesAdapter(seriesList)
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter=seriesAdapter


        try {
            val database=this.openOrCreateDatabase("Series", MODE_PRIVATE,null)

            val cursor = database.rawQuery("SELECT * FROM series",null)
            val seriesNameIx=cursor.getColumnIndex("seriesname")
            val idIx=cursor.getColumnIndex("id")

            while (cursor.moveToNext()){
                val name=cursor.getString(seriesNameIx)
                val id = cursor.getInt(idIx)
                val series=Series(name,id)
                seriesList.add(series)
            }

            seriesAdapter.notifyDataSetChanged()

            cursor.close()
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater= menuInflater
        menuInflater.inflate(R.menu.series_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         if(item.itemId==R.id.add_series_item){
             val intent=Intent(this@MainActivity,AddSeries::class.java)
             intent.putExtra("control",1)
             startActivity(intent)
         }
        return super.onOptionsItemSelected(item)
    }
    
}