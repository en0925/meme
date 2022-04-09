package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    View.OnClickListener,
    GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener,
    View.OnTouchListener{
    lateinit var gDetector: GestureDetector
    var PictureNo:Int = 0  //目前顯示第幾張圖
    var TotalPictures:Int = 7 //總共幾張圖片
    fun ShowPicture()
    {
        /*
        when (PictureNo)
        {
            0 -> img.setImageResource(R.drawable.pic1)
            1 -> img.setImageResource(R.drawable.pic2)
            2 -> img.setImageResource(R.drawable.pic3)
            3 -> img.setImageResource(R.drawable.pic4)
            4 -> img.setImageResource(R.drawable.pic5)
            5 -> img.setImageResource(R.drawable.pic6)
            6 -> img.setImageResource(R.drawable.pic7)
        }
        */
        txv.text = PictureNo.toString()
        var res:Int = getResources().getIdentifier("pic" + PictureNo.toString(),
            "drawable", getPackageName())
        img.setImageResource(res)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gDetector = GestureDetector(this, this)
        img.setOnTouchListener(this)
        var res:Int = -1
        var countDrawables:Int = -1
        while (res != 0)
        {
            countDrawables++;
            res = getResources().getIdentifier("pic" + countDrawables.toString(),
                "drawable", getPackageName());
        }
        TotalPictures = countDrawables
    }
    /*
    override fun onTouchEvent(event: MotionEvent?): Boolean
    {
        gDetector.onTouchEvent(event)
        return true
    }
    */
    override fun onTouch(p0: View?, event: MotionEvent?): Boolean
    {
        gDetector.onTouchEvent(event)
        return true
    }

    override fun onDown(p0: MotionEvent?): Boolean
    {

        return true
    }
    override fun onSingleTapUp(p0: MotionEvent?): Boolean
    {
        PictureNo = 0
        ShowPicture()
        return true
    }
    override fun onLongPress(p0: MotionEvent?)
    {
        PictureNo = TotalPictures - 1
        ShowPicture()
    }
    override fun onShowPress(p0: MotionEvent?)
    {

    }
    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean
    {

        return true
    }
    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean
    {
        if (e1!!.getX() < e2!!.getX())
        {
            //向右快滑
            PictureNo++
            if (PictureNo == TotalPictures)
            {
                PictureNo = 0
            }
        }
        else
        {
            //向左快滑
            PictureNo--;
            if (PictureNo < 0)
            {
                PictureNo = TotalPictures - 1
            }
        }
        ShowPicture()
        return true
    }
    override fun onDoubleTap(p0: MotionEvent?): Boolean
    {
        return true
    }
    override fun onDoubleTapEvent(p0: MotionEvent?): Boolean
    {

        return true
    }
    override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean
    {
        return true
    }

    override fun onClick(p0: View?) {

    }


}