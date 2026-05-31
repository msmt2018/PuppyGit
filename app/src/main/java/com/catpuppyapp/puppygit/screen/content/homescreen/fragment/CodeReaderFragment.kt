package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import com.catpuppyapp.puppygit.constants.Cons

/** Full code reader/editor page, backed by the existing EditorInnerPage flow inside HomeScreen. */
class CodeReaderFragment : HomeScreenPageFragment() {
    override val initialHomeScreen: Int = Cons.selectedItem_Editor
}
