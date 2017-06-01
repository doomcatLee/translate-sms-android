package com.doomcat.twilioapp;

import android.support.test.rule.ActivityTestRule;

import com.doomcat.twilioapp.Activities.AdminActivity;

import org.junit.Rule;

public class AdminActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<AdminActivity> activityTestRule =
            new ActivityTestRule<>(AdminActivity.class);

}