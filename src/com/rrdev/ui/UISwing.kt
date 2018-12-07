package com.rrdev.ui

import com.rrdev.extension.isIntegerNotValid
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.Frame
import java.awt.event.WindowEvent
import javax.swing.*


class UISwing: JFrame(){

    private val panelContent = JPanel()

    private val inputMemorySize = JTextField()
    private val inputOSSize = JTextField()
    private val inputProcessSizeStart = JTextField()
    private val inputProcessCreationTimeStart = JTextField()
    private val inputProcessDurationTimeStart = JTextField()

    private val labelMemorySize = JLabel("Memory Size Range")
    private val labelOSSize = JLabel("OS Size Range")
    private val labelProcessSizeRange = JLabel("Process Size Range")
    private val labelProcessCreationTimeRange = JLabel("Process Creation Size Range")
    private val labelProcessDurationTimeRange = JLabel("Process Duration Size Range")
    private val buttonContinue = JButton("Ok")
    private val buttonCancel = JButton("Cancel")


    init {
        title = "Virtual Memory"
        size = Dimension(1000, 600)
        isVisible = true
        layout = BorderLayout()
        defaultCloseOperation = EXIT_ON_CLOSE

        panelContent.run {
            layout = BoxLayout(this, BoxLayout.PAGE_AXIS)

            add(labelMemorySize)
            add(inputMemorySize)
            add(labelOSSize)
            add(inputOSSize)
            add(labelProcessSizeRange)
            add(inputProcessSizeStart)
            add(labelProcessCreationTimeRange)
            add(inputProcessCreationTimeStart)
            add(labelProcessDurationTimeRange)
            add(inputProcessDurationTimeStart)
            size = Dimension(1000, 600)

            add(buttonContinue)
            add(buttonCancel)

            return@run

        }

        add(panelContent)

        buttonCancel.addActionListener {
            dispatchEvent(WindowEvent(this, WindowEvent.WINDOW_CLOSING))
        }

        buttonContinue.addActionListener {
            when{
                inputMemorySize.isIntegerNotValid()->{
                    showMessage("Tamanho da memória")
                }
                inputOSSize.isIntegerNotValid()->{
                    showMessage("Tamanho do SO")
                }
                inputProcessSizeStart.isIntegerNotValid()->{
                    showMessage("Tamanho do processo")
                }
                inputProcessCreationTimeStart.isIntegerNotValid()->{
                    showMessage("Tamanho do processo criação")
                }
                inputProcessDurationTimeStart.isIntegerNotValid()->{
                    showMessage("Tamanho do processo duração")
                }
                else ->{

                }
            }

        }




    }

    private fun showMessage(message: String){
        JOptionPane.showMessageDialog(Frame(), "Entrada inválida: $message")
    }
}