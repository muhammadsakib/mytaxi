package com.mytaxi.android_demo;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase;
import android.test.ActivityInstrumentationTestCase2;

import com.mytaxi.android_demo.activities.AuthenticationActivity;
import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsAnything.anything;

@RunWith(AndroidJUnit4.class)
public class AuthenticationActivityTest {

    @Rule
    public ActivityTestRule<AuthenticationActivity> mActivityRule = new ActivityTestRule<>
            (AuthenticationActivity.class, true, true);

    @Before
    public void init() {
        mActivityRule.getActivity();
    }


    @Test
    public void perfomSuccessfulLoginTestWithCredentials() {
        onView(withId(R.id.edt_username)).perform(typeText(mActivityRule.getActivity().getResources().getString(R.string.username)), click());

        onView(withId(R.id.edt_password)).perform(typeText(mActivityRule.getActivity().getResources().getString(R.string.password)), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).perform(click());
    }
}
