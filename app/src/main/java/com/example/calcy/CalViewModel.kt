package com.example.calcy
import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalViewModel: ViewModel() {
    private val _state = MutableStateFlow(CalcyState())
    val state = _state.asStateFlow()
    fun onAction(action:Actions){
        Log.d("CalViewModel", "Action received: $action")
        when(action){
            is Actions.Number -> {
                Log.d("CalViewModel", "State before: ${_state.value}")
                EnterNumber(action.number)
                Log.d("CalViewModel", "State after: ${_state.value}")
            }
            is Actions.Operation -> addOperation(action.Operation)
            is Actions.Delete -> Del()
            is Actions.All_clear -> _state.value= CalcyState()
            is Actions.Decimal -> addDecimal()
            is Actions.Calculate -> PerformCalculation()

        }
    }

    private fun PerformCalculation() {
        val input1 =_state.value.input1.toDoubleOrNull()
        val input2 =_state.value.input2.toDoubleOrNull()
        if(input1 !=null && input2!=null){
            val result = when (_state.value.Operation) {
                is CalcyOperations.Add -> input1 + input2
                CalcyOperations.Divide -> input1 / input2
                CalcyOperations.Multiply -> input1 * input2
                CalcyOperations.Percentage -> (input1+input2) / 100
                CalcyOperations.Subtract -> input1 - input2
                null -> return
            }
            _state.value =
                _state.value.copy(input1 = result.toString().take(10),
                                 input2 = "",
                                 Operation = null
                    )
        }

    }

    private fun addDecimal() {
        if(_state.value.Operation==null && !_state.value.input1.contains('.') && _state.value.input1.isNotBlank()){
            _state.value = _state.value.copy(input1 = _state.value.input1+ '.')
            return
        }
        if(_state.value.Operation!=null && !_state.value.input2.contains('.') && _state.value.input2.isNotBlank()){
            _state.value = _state.value.copy(input2 = _state.value.input2+ '.')
            return
        }

    }

    private fun Del() {

        when{
            _state.value.input1.isNotBlank() -> _state.value =

                    _state.value.copy(input1 = _state.value.input1.dropLast(1))

            _state.value.Operation != null -> _state.value =
                    _state.value.copy(Operation = null)

            _state.value.input2.isNotBlank() -> _state.value =

                    _state.value.copy(input2 = _state.value.input2.dropLast(1))


        }
    }

    private fun addOperation(operation: CalcyOperations) {
        if(_state.value.input1.isNotBlank()){
            Log.d("Percentage","isequal${_state.value.Operation},${operation}")
            if(operation == CalcyOperations.Percentage ){
                Log.d("Percentage","isequal${_state.value.Operation}")
                if(_state.value.Operation == null){
                    if (_state.value.input2.length>=8) return
                    val input1=_state.value.input1.toDoubleOrNull()
                    val update = input1!! /100
                    _state.value =
                        _state.value.copy(input1 = update.toString())
                    return
                }
                //Using percentage on second variable when there is already an operation present
                //perfom the specified operation first
                PerformCalculation()
                //then do percentage on first value / maybe do recursion?
                //yea works
                addOperation(CalcyOperations.Percentage)
                return

            }
            _state.value =
                    _state.value.copy(Operation = operation)
        }
    }

    private fun EnterNumber(number: Int) {
        if(_state.value.Operation == null){
            if(_state.value.input1.length >= 8){
                return
            }

            _state.value = _state.value.copy(input1 = _state.value.input1+ number)
            return
        }
        if (_state.value.input2.length>=8) return
        _state.value = _state.value.copy(input2 = _state.value.input2 + number)
    }
}