package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountTree
import com.catpuppyapp.puppygit.constants.Cons

object BranchesFragment : MainActivityFragmentPage {
    override val homeItemId = Cons.selectedItem_Repos
    override val title = "分支"
    override val icon = Icons.Filled.AccountTree
}
