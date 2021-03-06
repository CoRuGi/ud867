package com.example.android.clickcounter;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.widget.TextViewCompat;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ClickButtonTest {

    @Rule
    public ActivityTestRule<ClickActivity> mActivityRule =
            new ActivityTestRule<>(ClickActivity.class);

    @Test
    public void initialNumber_sameActivity() {
        onView(withId(R.id.click_count_text_view))
                .check(matches(withText("0")));
    }

    @Test
    public void increaseNumber_sameActivity() {
        onView(withId(R.id.click_button))
                .perform(click());
        onView(withId(R.id.click_count_text_view))
                .check(matches(withText("" + 1)));
    }

}
