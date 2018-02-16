package com.client.shop.ui.view

import android.content.Context
import com.client.MockInstantiator
import com.client.shop.R
import com.domain.formatter.DateFormatter
import junit.framework.Assert.assertEquals
import kotlinx.android.synthetic.main.view_order_title.view.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class OrderTitleViewTest {

    private lateinit var context: Context
    private lateinit var itemView: OrderTitleView

    @Before
    fun setUpTest() {
        context = RuntimeEnvironment.application.baseContext
        itemView = OrderTitleView(context)
    }

    @Test
    fun shouldDisplayOrderTitle() {
        val order = MockInstantiator.newOrder()
        val dateFormatter = DateFormatter()
        itemView.setOrder(order, dateFormatter)
        assertEquals(context.getString(R.string.order_number_pattern,
            order.orderNumber).toUpperCase(), itemView.orderNumberTextView.text)
        assertEquals(context.getString(R.string.order_date_pattern,
            dateFormatter.format(order.processedAt)), itemView.orderDateTextView.text)
    }
}