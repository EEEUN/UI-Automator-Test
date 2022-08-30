package com.example.uiautomatortest;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Intent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import androidx.test.filters.SdkSuppress;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;
import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import androidx.test.filters.SdkSuppress;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.Until;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;



/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class ExampleInstrumentedTest {
    private UiDevice mDevice;
    private Context context;
    private static final String MY_PACKAGE = "com.example.uiautomatortest";

    @Before
    public void startMainActivityFromHomeScreen() throws UiObjectNotFoundException {
        // Initialize UiDevice instance : 디바이스(안드로이드 기기) 객체 가져오기
        mDevice = UiDevice.getInstance(getInstrumentation());

        // Start from the home screen : 홈 화면으로 나가기
        mDevice.pressHome();

        // Wait for launcher : 안드로이드 런처가 구동될때까지 3초간 대기 (3초 이후 실패)
        final String launcherPackage = mDevice.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), 3000);

        // Launch my app : 앱 구동하기
        context = getApplicationContext();
        // Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        final Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);   // Clear out any previous instances : 이전에 호출된 인스턴스 초기화
        context.startActivity(intent);

        // Wait for the app to appear : 앱이 구동될 때까지 3초간 대기 (3초 이후 테스트 실패)
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), 3000);
    }

    @Test
    public void checkPreconditions() {
        assertThat(mDevice, notNullValue());
    }

    /**
     * ResourceId를 사용해서 위젯을 가져오고 클릭
     */
    @Test
    public void testButtonClick() {
        mDevice.findObject(By.res(MY_PACKAGE, "button1")).click();
        mDevice.findObject(By.res(MY_PACKAGE, "button2")).click();
        mDevice.findObject(By.res(MY_PACKAGE, "button3")).click();
        mDevice.findObject(By.res(MY_PACKAGE, "button4")).click();
        mDevice.findObject(By.res(MY_PACKAGE, "button5")).click();
        mDevice.findObject(By.res(MY_PACKAGE, "init_button")).click();
    }

    /**
     * 화면의 절대좌표를 클릭 (컨텐츠뷰는 클릭되나, 상하단바는 클릭하면 강종됨)
     */
    @Test
    public void testCoordinateClick() {
        mDevice.click(525, 944);    // 화면 좌표값을 통해 클릭 가능
        mDevice.click(527, 1674);
        mDevice.click(116, 320);
        mDevice.click(860, 360);
        mDevice.click(121, 439);
        mDevice.click(550, 1415);
    }
}