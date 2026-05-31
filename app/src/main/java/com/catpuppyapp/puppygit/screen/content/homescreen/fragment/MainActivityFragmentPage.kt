package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * A top-level, MainActivity-managed page fragment.
 *
 * PuppyGit currently renders these pages with Compose instead of AndroidX Fragment
 * classes, so this interface is the fragment contract used by HomeScreen: every
 * functional page owns one small file, a title/icon for the tab bar, and the
 * existing HomeScreen page id it opens.
 */
interface MainActivityFragmentPage {
    val homeItemId: Int
    val title: String
    val icon: ImageVector

    companion object {
        val Projects: MainActivityFragmentPage = ProjectsFragment
        val Files: MainActivityFragmentPage = FilesFragment
        val Changes: MainActivityFragmentPage = ChangesFragment
        val Commit: MainActivityFragmentPage = CommitFragment
        val Stash: MainActivityFragmentPage = StashFragment
        val Conflicts: MainActivityFragmentPage = ConflictsFragment
        val Branches: MainActivityFragmentPage = BranchesFragment
        val Diff: MainActivityFragmentPage = DiffFragment
        val Code: MainActivityFragmentPage = CodeReaderFragment
        val Search: MainActivityFragmentPage = SearchFragment
        val More: MainActivityFragmentPage = MoreFragment

        val visibleTabs = listOf(Projects, Files, Changes, Commit, Stash, Conflicts, Branches, Diff, Code, Search)

        fun selectedIndexFor(homeItemId: Int): Int {
            val index = visibleTabs.indexOfFirst { it.homeItemId == homeItemId }
            return if(index >= 0) index else 0
        }
    }
}
