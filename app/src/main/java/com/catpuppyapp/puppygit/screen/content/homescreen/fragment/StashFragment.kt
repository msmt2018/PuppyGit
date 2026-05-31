package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import android.os.Bundle
import androidx.compose.runtime.Composable
import com.catpuppyapp.puppygit.screen.StashListScreen

/** Full stash page, using the same StashListScreen implementation as navigation. */
class StashFragment : BaseMainActivityComposeFragment() {
    @Composable
    protected override fun FragmentContent() {
        StashListScreen(
            repoId = requireArguments().getString(ARG_REPO_ID).orEmpty(),
            naviUp = ::closeFragment,
        )
    }

    companion object {
        private const val ARG_REPO_ID = "repoId"

        fun newInstance(repoId: String) = StashFragment().apply {
            arguments = Bundle().apply { putString(ARG_REPO_ID, repoId) }
        }
    }
}
