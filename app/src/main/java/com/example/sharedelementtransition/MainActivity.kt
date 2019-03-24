package com.example.sharedelementtransition

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Pair
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        imageView.setOnClickListener { view ->


            if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP) {
                val pairIv = Pair.create<View, String>(imageView, "image_view")
                val pairTv = Pair.create<View, String>(textView, "text_view")
                val pairv = Pair.create<View, String>(view, "view")

                val pairs = ArrayList<Pair<View, String>>()
                pairs.add(pairIv)
                pairs.add(pairTv)
                pairs.add(pairv)


                val pairsArray: Array<Pair<View, String>> = pairs.toTypedArray()
                val option: ActivityOptions =
                    ActivityOptions.makeSceneTransitionAnimation(this@MainActivity, *pairsArray);
                val intent = Intent(this@MainActivity,SecondActivity::class.java)
                startActivity(intent, option.toBundle())
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
