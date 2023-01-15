package com.triankyy.jetcalculator.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.triankyy.jetcalculator.model.CalculatorAction
import com.triankyy.jetcalculator.model.CalculatorOperation
import com.triankyy.jetcalculator.model.CalculatorState
import com.triankyy.jetcalculator.ui.component.CalculatorButton


@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = "Jet Calculator",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 5.dp,
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = CutCornerShape(topStart = 60.dp)
                    )
                    .clip(CutCornerShape(topStart = 60.dp))
                    .padding(horizontal = 12.dp)
                    .aspectRatio(2f)
            ) {
                Text(
                    text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Light,
                    fontSize = 40.sp,
                    color = MaterialTheme
                        .colorScheme
                        .onBackground,
                    maxLines = 2
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "CLEAR",
                    symbolColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Clear)
                    }
                )
                CalculatorButton(
                    symbol = "Del",
                    symbolColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Delete)
                    }
                )
                CalculatorButton(
                    symbol = "/",
                    symbolColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                listOf(7, 8, 9).forEach {
                    CalculatorButton(
                        symbol = it.toString(),
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(it))
                        }
                    )
                }
                CalculatorButton(
                    symbol = "X",
                    symbolColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                listOf(4, 5, 6).forEach {
                    CalculatorButton(
                        symbol = it.toString(),
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(it))
                        }
                    )
                }
                CalculatorButton(
                    symbol = "-",
                    symbolColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                listOf(1, 2, 3).forEach {
                    CalculatorButton(
                        symbol = it.toString(),
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(it))
                        }
                    )
                }
                CalculatorButton(
                    symbol = "+",
                    symbolColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Number(0))
                    }
                )
                CalculatorButton(
                    symbol = ".",
                    symbolColor = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Decimal)
                    }
                )
                CalculatorButton(
                    symbol = "=",
                    symbolColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Calculate)
                    }
                )
            }

        }
    }
}