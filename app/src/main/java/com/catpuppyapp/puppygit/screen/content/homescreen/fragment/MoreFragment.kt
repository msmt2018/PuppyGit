package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import com.catpuppyapp.puppygit.constants.Cons

object MoreFragment : MainActivityFragmentPage {
    override val homeItemId = Cons.selectedItem_Settings
    override val title = "更多"
    override val icon = Icons.Filled.MoreHoriz
}
