package com.rrdev

import com.rrdev.time.TimeListener
import com.rrdev.ui.UIPanelInputDouble
import com.rrdev.ui.UISwing
import java.awt.BorderLayout
import javax.swing.JFrame

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

        UISwing()

    }
}
