package com.ukenov_outlet.home_jetbrains_compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BonusSystemWidgetC(
    bonusSum: String,
    infoBonusBet: String,
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 90.dp, start = 20.dp, end = 20.dp, bottom = 220.dp)

    ) {

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
        }

    }
}