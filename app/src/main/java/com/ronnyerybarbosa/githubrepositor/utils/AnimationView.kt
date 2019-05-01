package com.ronnyerybarbosa.githubrepositor.utils

import android.view.View

/**
 * @author ronnyeybarbosa on 1,May,2019
 */

/**
 * Animation
 *
 * @param text View of animation
 * @param posicao Boolean postion
 * @param delay Int time delay
 */
fun startIntroAnimation(view: View, posicao: Boolean, delay: Int)
{

    //set view visible
    view.visibility = View.VISIBLE

    //set action animation
    val actionbarSize: Int

    //transition
    view.translationX = (2 * 50).toFloat()

    //set right left
    if (posicao)
    {
        actionbarSize = Utils().dpToPx(400)
    }
    else
    {
        actionbarSize = Utils().dpToPx(-400)
    }

    //set transition
    view.translationX = actionbarSize.toFloat()

    //animation
    view.animate()
            .translationX(0f)
            .setDuration(300).startDelay = delay.toLong()


}