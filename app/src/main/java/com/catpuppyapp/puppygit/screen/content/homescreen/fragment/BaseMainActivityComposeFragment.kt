package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.catpuppyapp.puppygit.ui.theme.InitContent
import com.catpuppyapp.puppygit.utils.AppModel

/**
 * Base Fragment for MainActivity pages that are already implemented as complete
 * Compose screens. Subclasses only choose which full screen/page to render; no
 * placeholder UI is introduced here.
 */
abstract class BaseMainActivityComposeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                InitContent(requireContext().applicationContext) {
                    AppModel.init_3()
                    FragmentContent()
                }
            }
        }
    }

    @Composable
    protected abstract fun FragmentContent()

    protected fun closeFragment() {
        if(!parentFragmentManager.popBackStackImmediate()) {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }
}
