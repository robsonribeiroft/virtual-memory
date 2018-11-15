package com.rrdev.time

interface TimeListener {

    interface Update{
        fun updateTime(time: Int)
    }

    interface Finish{
        fun finishCount()
    }

}