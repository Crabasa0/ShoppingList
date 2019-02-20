package hu.ait.tictactoe.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View


class TicTacToeView(context: Context?, attrs: AttributeSet?) : View(context, attrs)
{

    private val paintBackground = Paint()
    private val paintLine = Paint()

    private var x: Int = -1
    private var y: Int = -1

    init {
        paintBackground.color = Color.BLACK
        paintBackground.style = Paint.Style.FILL

        paintLine.color = Color.WHITE
        paintLine.style = Paint.Style.STROKE
        paintLine.strokeWidth = 8f
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paintBackground)

        canvas?.drawLine(0f, 0f, width.toFloat(), height.toFloat(), paintLine)

        if (x != -1 && y != -1) {
            canvas?.drawCircle(x.toFloat(), y.toFloat(), 50f, paintLine)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if (event?.action == MotionEvent.ACTION_DOWN){
            x = event?.x.toInt()
            y = event?.y.toInt()

            invalidate()
        }


        return true
    }
}

