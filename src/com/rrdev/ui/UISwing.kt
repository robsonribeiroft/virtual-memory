package com.rrdev.ui

import com.rrdev.extension.isIntegerValid
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.Frame
import java.awt.Rectangle
import java.awt.event.ActionListener
import javax.swing.*
import javax.swing.BoxLayout


class UISwing: JFrame(){

    private val panelContent = JPanel()
    private val labelMemorySizeRange = JLabel("Memory Size Range")
    private val inputMemorySizeRange = JTextField()
    private val labelMemoryOSSizeRange = JLabel("OS Size Range")
    private val inputMemoryOSSizeRange = JTextField()
    private val labelMemoryProcessSizeRange = JLabel("Process Size Range")
    private val inputMemoryProcessSizeRange = JTextField()
    private val labelProcessCreationTimeRange = JLabel("Process Creation Size Range")
    private val inputProcessCreationTimeRange = JTextField()
    private val labelProcessDurationTimeRange = JLabel("Process Duration Size Range")
    private val inputProcessDurationTimeRange = JTextField()
    private val buttonContinue = JButton("Ok")
    private val buttonCancel = JButton("Cancel")

    init {
        size = Dimension(600, 400)
        title = "Virtual Memory"
        layout = BorderLayout()

        panelContent.run {
            bounds = Rectangle(50, 50)
//            size = Dimension(800, 800)
            layout = BoxLayout(this, BoxLayout.Y_AXIS)
            add(labelMemorySizeRange)
            add(inputMemorySizeRange)
            add(labelMemoryOSSizeRange)
            add(inputMemoryOSSizeRange)
            add(labelMemoryProcessSizeRange)
            add(inputMemoryProcessSizeRange)
            add(labelProcessCreationTimeRange)
            add(inputProcessCreationTimeRange)
            add(labelProcessDurationTimeRange)
            add(inputProcessDurationTimeRange)

            add(buttonContinue)
            add(buttonCancel)
            return@run

        }

        buttonContinue.addActionListener {
            if (inputMemorySizeRange.isIntegerValid()){
                println("is valid")
            } else{
                println("not valid")
            }

        }


        add(panelContent)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        isVisible = true

    }

    fun showMessage(message: String){
        JOptionPane.showMessageDialog(Frame(), message)
    }
}