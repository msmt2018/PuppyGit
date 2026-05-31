package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import com.catpuppyapp.puppygit.constants.Cons

/** Full searchable repository entry page, backed by the existing HomeScreen repository search flow. */
class SearchFragment : HomeScreenPageFragment() {
    override val initialHomeScreen: Int = Cons.selectedItem_Repos
}
