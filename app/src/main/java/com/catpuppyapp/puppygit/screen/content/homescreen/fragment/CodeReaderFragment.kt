package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import com.catpuppyapp.puppygit.constants.Cons

object CodeReaderFragment : MainActivityFragmentPage {
    override val homeItemId = Cons.selectedItem_Editor
    override val title = "代码"
    override val icon = Icons.Filled.Code
}
