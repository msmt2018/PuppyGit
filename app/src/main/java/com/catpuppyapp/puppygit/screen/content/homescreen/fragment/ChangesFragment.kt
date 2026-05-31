package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Difference
import com.catpuppyapp.puppygit.constants.Cons

object ChangesFragment : MainActivityFragmentPage {
    override val homeItemId = Cons.selectedItem_ChangeList
    override val title = "修改"
    override val icon = Icons.Filled.Difference
}
