package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import com.catpuppyapp.puppygit.constants.Cons

/** Full file tree/page, backed by the existing FilesInnerPage flow inside HomeScreen. */
class FilesFragment : HomeScreenPageFragment() {
    override val initialHomeScreen: Int = Cons.selectedItem_Files
}
