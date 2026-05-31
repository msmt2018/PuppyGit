package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Source
import com.catpuppyapp.puppygit.constants.Cons

object DiffFragment : MainActivityFragmentPage {
    override val homeItemId = Cons.selectedItem_ChangeList
    override val title = "对比"
    override val icon = Icons.Filled.Source
}
