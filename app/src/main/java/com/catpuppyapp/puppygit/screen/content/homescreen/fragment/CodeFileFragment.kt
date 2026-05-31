package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.catpuppyapp.puppygit.constants.LineNum
import com.catpuppyapp.puppygit.screen.SubPageEditor

/** Full code/file reader page, using the same SubPageEditor implementation as navigation. */
class CodeFileFragment : BaseMainActivityComposeFragment() {
    @Composable
    protected override fun FragmentContent() {
        val args = requireArguments()
        val editorPageLastFilePath = rememberSaveable { mutableStateOf("") }
        SubPageEditor(
            goToLine = args.getInt(ARG_GO_TO_LINE, LineNum.lastPosition),
            initMergeMode = args.getBoolean(ARG_INIT_MERGE_MODE),
            initReadOnly = args.getBoolean(ARG_INIT_READ_ONLY, true),
            editorPageLastFilePath = editorPageLastFilePath,
            filePathKey = args.getString(ARG_FILE_PATH_KEY).orEmpty(),
            naviUp = ::closeFragment,
        )
    }

    companion object {
        private const val ARG_GO_TO_LINE = "goToLine"
        private const val ARG_INIT_MERGE_MODE = "initMergeMode"
        private const val ARG_INIT_READ_ONLY = "initReadOnly"
        private const val ARG_FILE_PATH_KEY = "filePathKey"

        fun newInstance(
            filePathKey: String,
            goToLine: Int = LineNum.lastPosition,
            initMergeMode: Boolean = false,
            initReadOnly: Boolean = true,
        ) = CodeFileFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_FILE_PATH_KEY, filePathKey)
                putInt(ARG_GO_TO_LINE, goToLine)
                putBoolean(ARG_INIT_MERGE_MODE, initMergeMode)
                putBoolean(ARG_INIT_READ_ONLY, initReadOnly)
            }
        }
    }
}
