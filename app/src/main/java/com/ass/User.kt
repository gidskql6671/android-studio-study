package com.ass

open class Super {
    open var someData = 10
    fun someFun() {
        println("$someData")
    }
}

class Sub: Super() {
    override var someData = 20
}