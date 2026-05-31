package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.catpuppyapp.puppygit.screen.HomeScreen

/**
 * Hosts the real HomeScreen implementation and opens it on a specific full
 * functional inner page (repositories, files, change list, editor, etc.).
 */
abstract class HomeScreenPageFragment : BaseMainActivityComposeFragment() {
    protected abstract val initialHomeScreen: Int

    @Composable
    protected final override fun FragmentContent() {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val currentHomeScreen = rememberSaveable { mutableIntStateOf(initialHomeScreen) }
        val repoPageListState = rememberLazyListState()
        val editorPageLastFilePath = rememberSaveable { mutableStateOf("") }

        HomeScreen(
            drawerState = drawerState,
            currentHomeScreen = currentHomeScreen,
            repoPageListState = repoPageListState,
            editorPageLastFilePath = editorPageLastFilePath,
        )
    }
}
