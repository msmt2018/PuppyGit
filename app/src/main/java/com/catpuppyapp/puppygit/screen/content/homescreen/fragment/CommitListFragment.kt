package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import android.os.Bundle
import androidx.compose.runtime.Composable
import com.catpuppyapp.puppygit.screen.CommitListScreen
import com.catpuppyapp.puppygit.screen.shared.CommitListFrom

/** Full commit history page, using the same CommitListScreen implementation as navigation. */
class CommitListFragment : BaseMainActivityComposeFragment() {
    @Composable
    protected override fun FragmentContent() {
        val args = requireArguments()
        CommitListScreen(
            repoId = args.getString(ARG_REPO_ID).orEmpty(),
            from = CommitListFrom.fromCode(args.getString(ARG_FROM).orEmpty()) ?: CommitListFrom.FOLLOW_HEAD,
            isHEAD = args.getBoolean(ARG_IS_HEAD, true),
            fullOidCacheKey = args.getString(ARG_FULL_OID_CACHE_KEY).orEmpty(),
            shortBranchNameCacheKey = args.getString(ARG_SHORT_BRANCH_NAME_CACHE_KEY).orEmpty(),
            naviUp = ::closeFragment,
        )
    }

    companion object {
        private const val ARG_REPO_ID = "repoId"
        private const val ARG_FROM = "from"
        private const val ARG_IS_HEAD = "isHead"
        private const val ARG_FULL_OID_CACHE_KEY = "fullOidCacheKey"
        private const val ARG_SHORT_BRANCH_NAME_CACHE_KEY = "shortBranchNameCacheKey"

        fun newInstance(
            repoId: String,
            from: CommitListFrom = CommitListFrom.FOLLOW_HEAD,
            isHEAD: Boolean = true,
            fullOidCacheKey: String = "",
            shortBranchNameCacheKey: String = "",
        ) = CommitListFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_REPO_ID, repoId)
                putString(ARG_FROM, from.code)
                putBoolean(ARG_IS_HEAD, isHEAD)
                putString(ARG_FULL_OID_CACHE_KEY, fullOidCacheKey)
                putString(ARG_SHORT_BRANCH_NAME_CACHE_KEY, shortBranchNameCacheKey)
            }
        }
    }
}
