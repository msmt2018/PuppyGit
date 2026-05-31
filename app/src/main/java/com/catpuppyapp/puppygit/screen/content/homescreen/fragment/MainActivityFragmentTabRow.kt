package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainActivityFragmentTabRow(
    currentHomeItemId: Int,
    onPageSelected: (MainActivityFragmentPage) -> Unit,
    modifier: Modifier = Modifier,
) {
    val selectedIndex = MainActivityFragmentPage.selectedIndexFor(currentHomeItemId)

    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        edgePadding = 8.dp,
        modifier = modifier.fillMaxWidth(),
    ) {
        MainActivityFragmentPage.visibleTabs.forEachIndexed { index, page ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onPageSelected(page) },
                text = {
                    Text(
                        text = page.title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                icon = {
                    Icon(imageVector = page.icon, contentDescription = page.title)
                },
            )
        }
    }
}
