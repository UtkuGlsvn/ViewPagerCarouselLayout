# ViewPagerCarouselLayout
Android ViewPaager 2 Carousel Layout Example. Kotlin


In this example, there is a custom carousel layout by customized the viewpager2 with the kotlin programming language.

```
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

```
Demo:

<img src="https://github.com/UtkuGlsvn/ViewPagerCarouselLayout/blob/master/gif/carousallayaout.gif" alt="Carousel Layout" width="312" height="562">

Tr blog: https://utkuglsvn.medium.com/viewpager-kullanarakcarousel-layaout-olu%C5%9Fturma-8bed78aeef6a
