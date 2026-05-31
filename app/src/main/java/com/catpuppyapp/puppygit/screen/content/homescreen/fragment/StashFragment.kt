package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import com.catpuppyapp.puppygit.constants.Cons

object StashFragment : MainActivityFragmentPage {
    override val homeItemId = Cons.selectedItem_ChangeList
    override val title = "暂存"
    override val icon = Icons.Filled.Save
}
