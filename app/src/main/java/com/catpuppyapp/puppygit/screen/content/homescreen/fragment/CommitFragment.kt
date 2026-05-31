package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Commit
import com.catpuppyapp.puppygit.constants.Cons

object CommitFragment : MainActivityFragmentPage {
    override val homeItemId = Cons.selectedItem_ChangeList
    override val title = "提交"
    override val icon = Icons.Filled.Commit
}
