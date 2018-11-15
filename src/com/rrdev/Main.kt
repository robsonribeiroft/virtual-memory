package com.rrdev

import com.rrdev.time.Time
import com.rrdev.time.TimeListener
import com.rrdev.ui.UISwing

object Main: TimeListener.Update {

    private var processes = ArrayList<Process>()
    private var listener:  TimeListener.Finish? = null


    override fun updateTime(time: Int) {
        println("${System.currentTimeMillis()} - $time")
        if (time >3){
            println("10")
            listener?.finishCount()
        }
    }



    @JvmStatic
    fun main(args: Array<String>) {
        val n = 4

        UISwing()
        val time = Time(this)
        listener = time
    }
}
