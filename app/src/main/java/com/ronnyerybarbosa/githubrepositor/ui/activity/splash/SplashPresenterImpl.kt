package com.ronnyerybarbosa.githubrepositor.ui.activity.splash

import android.app.ListActivity
import android.content.Intent
import android.os.Handler
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.view.View
import com.ronnyerybarbosa.githubrepositor.ui.activity.list.ListRepositoriesActivity

class SplashPresenterImpl(val splashView: SplashView): SplashPresenter
{

    /* ****************************
   *          ATTRIBUTES
   ******************************/


    private val SPLASH_DELAY: Long = 3000 //3 seconds
    private var mDelayHandler: Handler? = null

    private val metrics = DisplayMetrics()


    init
    {
        (splashView as AppCompatActivity).windowManager.defaultDisplay.getMetrics(metrics)
    }

    /**
     * Delay
     */
    internal val mRunnable: Runnable = Runnable{

        if (!(splashView as AppCompatActivity).isFinishing)
        {
            splashView.startActivity(Intent(splashView, ListRepositoriesActivity::class.java))
            splashView.finish()
        }
    }


    /**
     * Animation view
     *
     * @param view text animation
     * @param viewanimation content
     */
    override fun animation(view: View, viewanimation: View)
    {

        val position = metrics.ydpi +(metrics.ydpi/2)

        val anim = SpringAnimation(viewanimation, SpringAnimation.TRANSLATION_Y,position)

        anim.spring.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY

        anim.spring.stiffness = SpringForce.STIFFNESS_LOW

        anim.start()

        splashView.startIntroAnimation(view,true, 900)

    }


    /**
     * Set delay
     */
    override fun handler()
    {

        //Initialize the Handler
        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
    }

}