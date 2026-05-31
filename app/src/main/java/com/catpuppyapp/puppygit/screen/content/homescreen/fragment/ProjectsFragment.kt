package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import com.catpuppyapp.puppygit.constants.Cons

/** Full repository/project list page, backed by the existing RepoInnerPage flow inside HomeScreen. */
class ProjectsFragment : HomeScreenPageFragment() {
    override val initialHomeScreen: Int = Cons.selectedItem_Repos
}
