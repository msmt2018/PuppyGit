package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import com.catpuppyapp.puppygit.constants.Cons

object FilesFragment : MainActivityFragmentPage {
    override val homeItemId = Cons.selectedItem_Files
    override val title = "文件"
    override val icon = Icons.Filled.Folder
}
