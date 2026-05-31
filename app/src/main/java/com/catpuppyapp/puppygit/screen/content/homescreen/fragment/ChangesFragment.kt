package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import com.catpuppyapp.puppygit.constants.Cons

/** Full change list page, backed by the existing ChangeListInnerPage flow inside HomeScreen. */
class ChangesFragment : HomeScreenPageFragment() {
    override val initialHomeScreen: Int = Cons.selectedItem_ChangeList
}
