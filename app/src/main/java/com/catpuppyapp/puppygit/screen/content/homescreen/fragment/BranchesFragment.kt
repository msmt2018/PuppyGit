package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import android.os.Bundle
import androidx.compose.runtime.Composable
import com.catpuppyapp.puppygit.screen.BranchListScreen

/** Full branch list page, using the same BranchListScreen implementation as navigation. */
class BranchesFragment : BaseMainActivityComposeFragment() {
    @Composable
    protected override fun FragmentContent() {
        BranchListScreen(
            repoId = requireArguments().getString(ARG_REPO_ID).orEmpty(),
            naviUp = ::closeFragment,
        )
    }

    companion object {
        private const val ARG_REPO_ID = "repoId"

        fun newInstance(repoId: String) = BranchesFragment().apply {
            arguments = Bundle().apply { putString(ARG_REPO_ID, repoId) }
        }
    }
}
