package com.rrdev.time

import java.util.concurrent.TimeUnit

class Time(private val listener: TimeListener.Update?=null): Thread(), TimeListener.Finish {

    private var count = 0
    private var keepCount = true

    init {
//        Thread(this).start()
    }

    override fun run() {
        super.run()

        while (keepCount){
            TimeUnit.SECONDS.sleep(1)

            count++
            listener?.updateTime(count)
        }
    }

    override fun finishCount() {
        keepCount = false
        println("finishCount")
    }
}