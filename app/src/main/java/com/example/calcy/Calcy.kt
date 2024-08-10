package com.example.calcy

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calcy(
    state: CalcyState,
    modifier: Modifier = Modifier,
    onAction: (Actions) -> Unit
    )
{
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(7.dp),
        ) {
            Log.d("Calcy", "Input1: ${state.input1}, Operation: ${state.Operation}, Input2: ${state.input2}")
            Text(
                text = state.input1 + (state.Operation?.Symbol?:"") + state.input2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 40.sp,
                color = Color.White,
                maxLines = 2
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                CalcyButton(
                    Symbol = "AC",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    onClick={
                        onAction(Actions.All_clear)
                    }
                )
                CalcyButton(
                    Symbol = "%",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    onClick={
                        onAction(Actions.Operation(CalcyOperations.Percentage))
                    }
                )
                CalcyButton(
                    Symbol = "Del",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    onClick={
                        onAction(Actions.Delete)
                    }
                )
                CalcyButton(
                    Symbol = "/",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Green),
                    onClick={
                        onAction(Actions.Operation(CalcyOperations.Divide))
                    }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                CalcyButton(
                    Symbol = "7",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    onClick={
                        Log.d("CalcyButton", "Button 7 clicked")
                        onAction(Actions.Number(7))
                    }
                )
                CalcyButton(
                    Symbol = "8",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    onClick={
                        onAction(Actions.Number(8))
                    }
                )
                CalcyButton(
                    Symbol = "9",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    onClick={
                        onAction(Actions.Number(9))
                    }
                )
                CalcyButton(
                    Symbol = "x",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Green),
                    onClick={
                        onAction(Actions.Operation(CalcyOperations.Multiply))
                    }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                CalcyButton(
                    Symbol = "4",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    onClick={
                        onAction(Actions.Number(4))
                    }
                )
                CalcyButton(
                    Symbol = "5",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    onClick={
                        onAction(Actions.Number(5))
                    }
                )
                CalcyButton(
                    Symbol = "6",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    onClick={
                        onAction(Actions.Number(6))
                    }
                )
                CalcyButton(
                    Symbol = "-",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Green),
                    onClick={
                        onAction(Actions.Operation(CalcyOperations.Subtract))
                    }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                CalcyButton(
                    Symbol = "1",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    onClick={
                        onAction(Actions.Number(1))
                    }
                )
                CalcyButton(
                    Symbol = "2",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    onClick={
                        onAction(Actions.Number(2))
                    }
                )
                CalcyButton(
                    Symbol = "3",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    onClick={
                        onAction(Actions.Number(3))
                    }
                )
                CalcyButton(
                    Symbol = "+",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Green),
                    onClick={
                        onAction(Actions.Operation(CalcyOperations.Add))
                    }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                CalcyButton(
                    Symbol = "0",

                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                        .background(LightGray),
                    onClick={
                        onAction(Actions.Number(0))
                    }
                )
                CalcyButton(
                    Symbol = ".",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    onClick={
                        onAction(Actions.Decimal)
                    }
                )
                CalcyButton(
                    Symbol = "=",

                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Green),
                    onClick={
                        onAction(Actions.Calculate)
                    }
                )
            }
        }
    }
    }
