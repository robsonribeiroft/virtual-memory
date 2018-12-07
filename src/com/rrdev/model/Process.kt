package com.rrdev.model

import java.awt.Color

data class Process (
        var id: String?=null,
        var startPage: Int=0,
        var endPage: Int = 0,
        var size: Int=0,
        var creationTime: Int=0,
        var duration: Int=0,
        var wait: Int = 0,
        var osType: Boolean = false,
        var color: Color?=null){


    init {
        this.color = com.rrdev.ui.Color.randomColor()
        if (size==0) size = endPage - startPage
    }

    fun defineStartPage(startPage: Int){
        this.startPage = startPage
        size = endPage - startPage
    }

    fun increaseWaitTime(){
        wait++
    }

    fun decreaseTime(){
        duration--
    }
}

