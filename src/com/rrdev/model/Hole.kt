package com.rrdev.model

data class Hole(var startPage:Int=0,
                var endPage:Int=0,
                var size:Int=0) {

    init {
        this.size = endPage - startPage
    }
}