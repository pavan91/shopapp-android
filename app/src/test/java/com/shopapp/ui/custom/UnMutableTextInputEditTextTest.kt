package com.shopapp.ui.custom

import android.view.ContextThemeWrapper
import com.shopapp.R
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class UnMutableTextInputEditTextTest {

    private lateinit var view: UnMutableTextInputEditText

    @Before
    fun setUpTest() {
        val contextWrapper = ContextThemeWrapper(RuntimeEnvironment.application.baseContext, R.style.AppTheme)
        view = UnMutableTextInputEditText(contextWrapper, null)
    }

    @Test
    fun shouldSetTextProgrammatically() {
        val testText = "testText"
        view.setText(testText)
        Assert.assertEquals(testText, view.text.toString())
    }

    @Test
    fun shouldNotSetFocus() {
        view.performClick()
        Assert.assertEquals(false, view.isFocused)
    }
}