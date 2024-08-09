package com.kainzengaming.sport.ui

import android.content.Context
import android.os.CountDownTimer
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.kainzengaming.sport.R
import java.util.Locale

class CountdownTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleRes: Int = 0
) : AppCompatTextView(context, attrs, defStyleRes) {
    private var timer: CountDownTimer? = null

    /**
     * Start the timer count down to the given time.
     */
    fun setTimer(time: Long) {
        countdownTimer(
            calculateTimeUntilStart(time)
        )
    }

    private fun calculateTimeUntilStart(time: Long): Long {
        val now = System.currentTimeMillis() / 1000
        val diff = time - now
        return if (diff > 0) diff else 0
    }

    private fun countdownTimer(time: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(time, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                this@CountdownTextView.text = millisUntilFinished.formatTime()
            }

            override fun onFinish() {
                this@CountdownTextView.text = context.getString(R.string.countdowntime_placeholder)
            }
        }
        timer?.start()
    }

    private fun Long.formatTime(): String {
        val sec = (this / 1000) % 60
        val min = (this / (1000 * 60)) % 60
        val hr = (this / (1000 * 60 * 60)) % 24
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", hr, min, sec)
    }
}