package com.rrdev.extension

import javax.swing.JTextField

fun JTextField.isIntegerValid(): Boolean {
    return text.isNullOrEmpty().not() and text.matches(Regex("""^[\d]*$"""))
}

fun JTextField.isIntegerNotValid() = isIntegerValid().not()