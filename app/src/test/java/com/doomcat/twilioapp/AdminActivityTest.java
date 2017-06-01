package com.doomcat.twilioapp;


import android.os.Build;
import android.widget.ListView;

import com.doomcat.twilioapp.Activities.AdminActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class AdminActivityTest {
    private AdminActivity activity;
    private ListView mContentListView;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(AdminActivity.class);
        mContentListView = (ListView) activity.findViewById(R.id.contentListView);
    }

    @Test
    public void CheckCountInListView() {
        assertNotNull(mContentListView.getAdapter());
        assertEquals(mContentListView.getAdapter().getCount(), 6);
    }


}