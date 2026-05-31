package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import com.catpuppyapp.puppygit.constants.Cons

/** Full settings/more page, backed by the existing SettingsInnerPage flow inside HomeScreen. */
class MoreFragment : HomeScreenPageFragment() {
    override val initialHomeScreen: Int = Cons.selectedItem_Settings
}
