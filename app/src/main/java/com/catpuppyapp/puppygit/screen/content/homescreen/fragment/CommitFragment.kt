package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import com.catpuppyapp.puppygit.constants.Cons

/** Full commit workflow page, backed by the existing ChangeListInnerPage commit actions. */
class CommitFragment : HomeScreenPageFragment() {
    override val initialHomeScreen: Int = Cons.selectedItem_ChangeList
}
