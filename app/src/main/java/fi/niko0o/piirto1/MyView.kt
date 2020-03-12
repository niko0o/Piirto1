package fi.niko0o.piirto1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    var my_x = 0.0f
    var my_y = 0.0f
    var paint = Paint()
    var viewHeight = 0
    var viewWidth = 0

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.GREEN
        canvas.drawOval(my_x, my_y, my_x + 100.0f, my_y + 100.0f, paint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        viewWidth = w
        viewHeight = h
    }

    fun setXY(_x: Float, _y: Float) {
        my_x += _x
        my_y += _y

        if (my_x <= 0.0f) {
            my_x = 0.0f
        }
        if (my_x > viewWidth - 100.0f) {
            my_x = viewWidth.toFloat() - 100.0f
        }
        if (my_y <= 0.0f) {
            my_y = 0.0f
        }
        if (my_y > viewHeight - 100.0f) {
            my_y = viewHeight.toFloat() - 100.0f
        }
        invalidate()
    }
}