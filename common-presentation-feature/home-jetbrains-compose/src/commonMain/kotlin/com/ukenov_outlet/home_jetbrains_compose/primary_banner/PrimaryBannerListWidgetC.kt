package com.ukenov_outlet.home_jetbrains_compose.primary_banner

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ukenov_outlet.pojo_poko.primary_banner.PokoPrimaryBanner

@Composable
fun PrimaryBannerListWidgetC(
    itemsList: List<PokoPrimaryBanner>,
    itemClickable: (id: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .height(510.dp)
    ) {
        items(
            items = itemsList,
            key = {
                it.idPosition
            }
        ) {

        }
    }
}