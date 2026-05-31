package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import com.catpuppyapp.puppygit.constants.Cons

/** Full conflict-resolution entry page, backed by the existing ChangeListInnerPage conflict flow. */
class ConflictsFragment : HomeScreenPageFragment() {
    override val initialHomeScreen: Int = Cons.selectedItem_ChangeList
}
