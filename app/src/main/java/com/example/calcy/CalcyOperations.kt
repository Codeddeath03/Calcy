package com.example.calcy

sealed class CalcyOperations(val Symbol: String) {


    object Add:CalcyOperations("+")
    object Subtract:CalcyOperations("-")
    object Divide:CalcyOperations("/")
    object Percentage:CalcyOperations("%")
    object Multiply:CalcyOperations("x")
}
