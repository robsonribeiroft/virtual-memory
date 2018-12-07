package com.rrdev

import com.rrdev.model.Memory
import com.rrdev.time.Time
import com.rrdev.time.TimeListener
import com.rrdev.util.Generator

object Main: TimeListener.Update, TimeListener.Finish {
    override fun finishCount() {
        memory.getAverageWaitTime()
    }

    private lateinit var generator: Generator
    private lateinit var memory: Memory


    override fun updateTime(time: Int) {
        memory.verifyRunningProcess()
        generator.elapsedSecond(time)

    }



    @JvmStatic
    fun main(args: Array<String>) {
        val scan = System.`in`
        val soSize = scan.read()
        val sizeMemo = scan.read()
        memory.setListener(this)
        memory = Memory(sizeMemo, soSize)

        generator = Generator(memory)
        generator.generateProcesses()

        Time(this)



    }
}
