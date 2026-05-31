package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import com.catpuppyapp.puppygit.constants.Cons

object SearchFragment : MainActivityFragmentPage {
    override val homeItemId = Cons.selectedItem_Repos
    override val title = "搜索"
    override val icon = Icons.Filled.Search
}
