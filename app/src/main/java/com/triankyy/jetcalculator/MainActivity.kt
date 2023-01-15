package com.triankyy.jetcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.triankyy.jetcalculator.model.CalculatorViewModel
import com.triankyy.jetcalculator.screen.Calculator
import com.triankyy.jetcalculator.ui.theme.JetCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 15.dp
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator(
                        state = state,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(15.dp),
                        onAction = viewModel::onAction,
                        buttonSpacing = buttonSpacing
                    )
                }
            }
        }
    }
}