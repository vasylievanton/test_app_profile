package com.test.test_app.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.squareup.picasso.Picasso
import com.test.test_app.adapter.ListAdapter
import com.test.test_app.R
import com.test.test_app.model.Tags
import jp.wasabeef.picasso.transformations.BlurTransformation
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var listAdapter: ListAdapter? = null

    private val tags = listOf(
        Tags("Hiking", "\uD83D\uDE06"),
        Tags("Dog owner", "\uD83D\uDE06"),
        Tags("Candle light dinner", "\uD83D\uDE06"),
        Tags("Gone in 60 Seconds", "\uD83D\uDE06"),
        Tags("Knowing", "\uD83D\uDE06"),
        Tags("National Treasure", "\uD83D\uDE06"),
        Tags("The Wicker Man", "\uD83D\uDE06"),
        Tags("Ghost Rider", "\uD83D\uDE06")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setData()
    }


    private fun init() {
        recyclerView = findViewById(R.id.tags_rv)
        val layoutManager = FlexboxLayoutManager(this)
        listAdapter = ListAdapter(ArrayList())
        layoutManager.flexDirection = FlexDirection.ROW_REVERSE
        layoutManager.justifyContent = JustifyContent.CENTER
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = listAdapter
        get_premium_btn.setOnClickListener { setData() }
    }


    private fun setData() {
        listAdapter?.setData(getTags())
        Picasso.get()
            .load("https://picsum.photos/400")
            .transform(BlurTransformation(this, 50, 1))
            .into(profile_back_iv)
        Picasso.get()
            .load("https://picsum.photos/400")
            .transform(CropCircleTransformation())
            .into(profile_iv)
        name_tv.text = getString(R.string.john_doe) +" " + getRandom(1, 100)
        profile_pb.setProgress(getRandom(1, 100).toFloat())
    }

    private fun getTags(): List<Tags> {
        return tags.subList(0, getRandom(1, 8))
    }

    private fun getRandom(min: Int, max: Int): Int {
        return Random().nextInt(max - min + 1) + min
    }

}
