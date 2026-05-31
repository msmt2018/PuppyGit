package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.runtime.Composable
import com.catpuppyapp.puppygit.screen.IndexScreen

/** Full index/staging page, using the same IndexScreen implementation as navigation. */
class IndexFragment : BaseMainActivityComposeFragment() {
    @Composable
    protected override fun FragmentContent() {
        IndexScreen(naviUp = ::closeFragment)
    }
}
