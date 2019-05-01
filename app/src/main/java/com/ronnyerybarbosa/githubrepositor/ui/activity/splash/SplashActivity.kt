package com.ronnyerybarbosa.githubrepositor.ui.activity.splash

import android.animation.Animator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ronnyerybarbosa.githubrepositor.R
import com.ronnyerybarbosa.githubrepositor.utils.Utils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity: AppCompatActivity(), SplashView {


    /* ****************************
   *          ATTRIBUTES
   ******************************/
    lateinit var splashPresenter: SplashPresenter




    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashPresenter = getPresenter()

        splashPresenter.animation(splash_descript, cont)

        splashPresenter.handler()



    }

    fun getPresenter(): SplashPresenter
    {
        return SplashPresenterImpl(this)
    }

    override fun startIntroAnimation(text: View, posicao: Boolean, delay: Int)
    {

        //set action animation
        val actionbarSize: Int = if (posicao)
        {
            Utils().dpToPx(100)
        }
        else
        {
            Utils().dpToPx(0)
        }

        //transition
        text.translationX = (2 * 50).toFloat()

        //set right left

        //set transition
        text.translationX = actionbarSize.toFloat()

        //animation
        text.animate()
            .translationX(0f)
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {
                }

                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {

                    //set view visible
                    text.visibility = View.VISIBLE
                }

                override fun onAnimationCancel(animation: Animator?) {
                }
            })
            .setDuration(300).startDelay = delay.toLong()

    }

}