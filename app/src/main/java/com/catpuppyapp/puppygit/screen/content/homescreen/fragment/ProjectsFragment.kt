package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FolderCopy
import com.catpuppyapp.puppygit.constants.Cons

object ProjectsFragment : MainActivityFragmentPage {
    override val homeItemId = Cons.selectedItem_Repos
    override val title = "项目"
    override val icon = Icons.Filled.FolderCopy
}
