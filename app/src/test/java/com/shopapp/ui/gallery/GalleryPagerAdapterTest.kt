package com.shopapp.ui.gallery

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.shopapp.TestShopApplication
import com.shopapp.gateway.entity.Product
import com.shopapp.test.MockInstantiator
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE, application = TestShopApplication::class)
class GalleryPagerAdapterTest {

    private lateinit var activity: AppCompatActivity
    private lateinit var context: Context
    private lateinit var product: Product
    private lateinit var adapter: GalleryPagerAdapter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        activity = Robolectric.setupActivity(AppCompatActivity::class.java)
        context = RuntimeEnvironment.application.baseContext
        product = MockInstantiator.newProduct()
        adapter = GalleryPagerAdapter(activity.supportFragmentManager)
        adapter.product = product
        adapter.notifyDataSetChanged()
    }

    @Test
    fun shouldReturnCorrectItemCount() {
        assertEquals(MockInstantiator.DEFAULT_LIST_SIZE, adapter.count)
    }

    @Test
    fun shouldReturnImageFragment() {
        assertTrue(adapter.getItem(0) is ImageFragment)
    }

}