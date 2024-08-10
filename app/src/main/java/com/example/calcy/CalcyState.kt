package com.example.calcy

import kotlinx.coroutines.flow.MutableStateFlow

data class CalcyState(
    var input1: String = "",
    var input2: String = "",
    var Operation: CalcyOperations? = null

)