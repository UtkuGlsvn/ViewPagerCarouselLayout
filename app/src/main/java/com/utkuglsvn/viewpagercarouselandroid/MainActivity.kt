package com.utkuglsvn.viewpagercarouselandroid

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.utkuglsvn.viewpagercarouselandroid.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val list = mutableListOf(
        ItemData("https://avatars.githubusercontent.com/u/24415314?v=4.png", "1"),
        ItemData("https://avatars.githubusercontent.com/u/24415314?v=4.png", "2"),
        ItemData("https://avatars.githubusercontent.com/u/24415314?v=4.png", "3"),
        ItemData("https://avatars.githubusercontent.com/u/24415314?v=4", "4")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViewPager()
    }

    //initViewpager
    private fun initViewPager() {
        binding.apply {
            viewPager.apply {
                clipChildren = false  // No clipping the left and right items
                clipToPadding =
                    false  // Show the viewpager in full width without clipping the padding
                offscreenPageLimit = 3  // Render the left and right items

                viewPager.setPageTransformer(customPageTransformer())

                adapter = ItemAdapter(list)
                indicator.setViewPager(this)
                currentItem = 1 // start element
            }
        }
    }

    //Viewpager custom page transformer
    private fun customPageTransformer(): CompositePageTransformer {
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((40 * Resources.getSystem().displayMetrics.density).toInt()))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }
        return compositePageTransformer
    }
}