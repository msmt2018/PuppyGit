package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Merge
import com.catpuppyapp.puppygit.constants.Cons

object ConflictsFragment : MainActivityFragmentPage {
    override val homeItemId = Cons.selectedItem_ChangeList
    override val title = "冲突"
    override val icon = Icons.Filled.Merge
}
