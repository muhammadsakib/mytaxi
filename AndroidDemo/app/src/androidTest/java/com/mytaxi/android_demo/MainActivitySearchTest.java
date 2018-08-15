package com.mytaxi.android_demo;

import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withAlpha;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.internal.util.Checks.checkNotNull;
import static org.hamcrest.EasyMock2Matchers.equalTo;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringEndsWith.endsWith;

@RunWith(AndroidJUnit4.class)
public class MainActivitySearchTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>
            (MainActivity.class, true, true);

    @Before
    public void init() {
        mActivityRule.getActivity();
    }

    @Test
    public void useAppContext() {


        onView(withId(R.id.textSearch))
                .perform(typeText("sa"), closeSoftKeyboard());

        onView(withText(mActivityRule.getActivity().getResources().getString(R.string.searched_user)))
                .inRoot(withDecorView(not(Matchers.is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));

        onView(withText(mActivityRule.getActivity().getResources().getString(R.string.searched_user)))
                .inRoot(withDecorView(not(Matchers.is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .perform(click());

        onView(withId(R.id.fab))
                .perform(click());

    }
}

