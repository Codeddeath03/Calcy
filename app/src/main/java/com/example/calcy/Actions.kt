package com.example.calcy

sealed class Actions {
    data class Number(val number:Int):Actions()
    object All_clear: Actions()
    object Delete: Actions()
    object Decimal:Actions()
    object Calculate: Actions()
    data class Operation(val Operation: CalcyOperations): Actions()
}