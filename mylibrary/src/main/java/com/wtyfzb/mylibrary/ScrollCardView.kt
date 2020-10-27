package com.wtyfzb.mylibrary

import android.content.Context
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs


/**
 *可以滑动取消的cardview
 *
 * @author zhangshan
 * @Date 2020/10/27 9:21
 */
class ScrollCardView(context: Context, attrs: AttributeSet?) : CardView(context, attrs) {
    private var lastY = 0F
    private var nowOffsetY = 0F

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastY = event.rawY
            }
            MotionEvent.ACTION_MOVE -> {
                nowOffsetY = event.rawY - lastY
                if (nowOffsetY <= 0) {
                    translationY = nowOffsetY
                }
            }
            MotionEvent.ACTION_UP -> {
                if (abs(nowOffsetY) > (height / 2)) {
                    visibility = View.GONE
                } else {
                    translationY = 0F
                }
            }
        }

        return true
    }
}