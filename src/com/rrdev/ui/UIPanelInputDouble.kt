package com.rrdev.ui

import java.awt.Dimension
import java.awt.GridLayout
import java.awt.Rectangle
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField

class UIPanelInputDouble(labelContent: String): JPanel() {

    private val label = JLabel()


    init {
        layout = GridLayout(2,1)
        size = Dimension(800, 200)
        label.text = labelContent
//        label.bounds = Rectangle(20,0, 800, 30)
        val inputs = addInputs()
//        inputs.bounds =  Rectangle(0,30, 800, 30)
        add(label)
        add(inputs)
        isVisible = true
    }

    private fun addInputs(): JPanel {
        val panel = JPanel()
        panel.run {
            layout = GridLayout(1,2)
//            size = Dimension(800, 400)
            inputFirst.preferredSize = Dimension(100, 30)
//            inputFirst.bounds = Rectangle(20,0, 200, 30)
            inputSecond.preferredSize = Dimension(100, 30)
//            inputSecond.bounds = Rectangle(250,0, 200, 30)
            add(inputFirst)
            add(inputSecond)
            isVisible = true
            return@run
        }
        return panel
    }

    companion object {
        val inputFirst = JTextField()
        val inputSecond = JTextField()
    }

}