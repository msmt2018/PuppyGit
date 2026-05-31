package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import android.os.Bundle
import androidx.compose.runtime.Composable
import com.catpuppyapp.puppygit.screen.DiffScreen
import com.catpuppyapp.puppygit.screen.shared.DiffFromScreen

/** Full diff viewer page, using the same DiffScreen implementation as navigation. */
class DiffFragment : BaseMainActivityComposeFragment() {
    @Composable
    protected override fun FragmentContent() {
        val args = requireArguments()
        DiffScreen(
            repoId = args.getString(ARG_REPO_ID).orEmpty(),
            fromTo = args.getString(ARG_FROM_TO).orEmpty(),
            treeOid1Str = args.getString(ARG_TREE_OID_1).orEmpty(),
            treeOid2Str = args.getString(ARG_TREE_OID_2).orEmpty(),
            isDiffToLocal = args.getBoolean(ARG_IS_DIFF_TO_LOCAL),
            curItemIndexAtDiffableItemList = args.getInt(ARG_CUR_ITEM_INDEX),
            localAtDiffRight = args.getBoolean(ARG_LOCAL_AT_DIFF_RIGHT),
            fromScreen = DiffFromScreen.fromCode(args.getString(ARG_FROM_SCREEN).orEmpty()) ?: DiffFromScreen.HOME_CHANGELIST,
            diffableListCacheKey = args.getString(ARG_DIFFABLE_LIST_CACHE_KEY).orEmpty(),
            isMultiMode = args.getBoolean(ARG_IS_MULTI_MODE),
            naviUp = ::closeFragment,
        )
    }

    companion object {
        private const val ARG_REPO_ID = "repoId"
        private const val ARG_FROM_TO = "fromTo"
        private const val ARG_TREE_OID_1 = "treeOid1"
        private const val ARG_TREE_OID_2 = "treeOid2"
        private const val ARG_IS_DIFF_TO_LOCAL = "isDiffToLocal"
        private const val ARG_CUR_ITEM_INDEX = "curItemIndex"
        private const val ARG_LOCAL_AT_DIFF_RIGHT = "localAtDiffRight"
        private const val ARG_FROM_SCREEN = "fromScreen"
        private const val ARG_DIFFABLE_LIST_CACHE_KEY = "diffableListCacheKey"
        private const val ARG_IS_MULTI_MODE = "isMultiMode"

        fun newInstance(
            repoId: String,
            fromTo: String,
            treeOid1Str: String,
            treeOid2Str: String,
            isDiffToLocal: Boolean,
            curItemIndexAtDiffableItemList: Int,
            localAtDiffRight: Boolean,
            fromScreen: DiffFromScreen,
            diffableListCacheKey: String,
            isMultiMode: Boolean,
        ) = DiffFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_REPO_ID, repoId)
                putString(ARG_FROM_TO, fromTo)
                putString(ARG_TREE_OID_1, treeOid1Str)
                putString(ARG_TREE_OID_2, treeOid2Str)
                putBoolean(ARG_IS_DIFF_TO_LOCAL, isDiffToLocal)
                putInt(ARG_CUR_ITEM_INDEX, curItemIndexAtDiffableItemList)
                putBoolean(ARG_LOCAL_AT_DIFF_RIGHT, localAtDiffRight)
                putString(ARG_FROM_SCREEN, fromScreen.code)
                putString(ARG_DIFFABLE_LIST_CACHE_KEY, diffableListCacheKey)
                putBoolean(ARG_IS_MULTI_MODE, isMultiMode)
            }
        }
    }
}
