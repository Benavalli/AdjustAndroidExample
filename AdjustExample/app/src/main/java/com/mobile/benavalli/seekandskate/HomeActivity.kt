package com.mobile.benavalli.seekandskate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustEvent
import java.util.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setButtonListener()
        onCreateTrack()
    }

    private fun onCreateTrack() {
        val event = AdjustEvent("event_token")
        event.addCallbackParameter("name", "Pedro")
        event.addCallbackParameter("city", "Campinas")
        Adjust.trackEvent(event)
    }

    private fun setButtonListener() {
        val textView: TextView = findViewById(R.id.button_pay)
        textView.setOnClickListener {
            buttonClickedTrack()
        }
    }

    private fun buttonClickedTrack() {
        val event = AdjustEvent("event_token")
        event.addCallbackParameter("name", "Pedro")
        event.addCallbackParameter("type", "street")
        event.setRevenue(50.0, "BRL")
        event.setOrderId((0..10).random().toString())
        Adjust.trackEvent(event)
    }

    fun ClosedRange<Int>.random() =
            Random().nextInt(endInclusive - start) +  start
}
