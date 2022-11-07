package com.happiestminds.testingdemo

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test

class MainActivityTestEspresso {

    @get:Rule
    val testRule = ActivityScenarioRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testLayout(){

        onView(withId(R.id.textView))
            .check(matches(isDisplayed()))

        onView(withText("Next"))
            .check(matches(allOf(isDisplayed(), isClickable())))

        onView(withId(R.id.nameE))
            .check(matches(allOf(isDisplayed(), isFocusable())))

    }

    @Test
    fun testButtonClick(){

        onView(withId(R.id.nameE))
            .perform(typeText("demo"))

        onView(withText("Next"))
            .perform(click())

        pressBack()

        onView(withId(R.id.textView))
            .check(matches(withText("Hello demo")))

        onView(withId(R.id.nameE))
            .check(matches(withText("")))
    }

    @Test
    fun testNextActivityStarted(){
        onView(withId(R.id.nameE))
            .perform(typeText("demo"))

        onView(withText("Next"))
            .perform(click())

        onView(withId(R.id.tv))
            .check(matches(withText("Welcome demo")))
    }
}