package com.ronnyerybarbosa.githubrepositor

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.ronnyerybarbosa.githubrepositor.ui.activity.list.ListRepositoriesActivity
import com.ronnyerybarbosa.githubrepositor.ui.activity.profile.ProfileActivity
import com.ronnyerybarbosa.githubrepositor.ui.activity.show.ShowRepositoryActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



/**
 * Test the API Request
 *
 * @author [Ronnyery Barbosa](ronnyerybarbosa@gmail.com)
 *
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class InterfaceTest
{

    @Rule
    @JvmField
    val rule = IntentsTestRule(ListRepositoriesActivity::class.java)

    @Test
    fun openProfile()
    {

//        onView(withId(R.id.list_repo)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
//
//        intended(hasComponent(ShowRepositoryActivity::class.java!!.getName()))



            onView(withId(R.id.profile)).perform(click())
            intended(hasComponent(ProfileActivity::class.java.name))

//        activityRule.launchActivity(Intent())
//        intended(hasComponent(HomeActivity::class.java!!.getName()))



    }








}
