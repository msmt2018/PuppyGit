package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Commit
import androidx.compose.material.icons.filled.Difference
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.FolderCopy
import androidx.compose.material.icons.filled.Merge
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Source
import androidx.compose.material3.AssistChip
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.catpuppyapp.puppygit.constants.Cons
import com.catpuppyapp.puppygit.data.entity.RepoEntity

/**
 * Home-level pages managed by MainActivity.
 *
 * PuppyGit is a Compose app, so these entries are "fragments" in the UI/state sense:
 * each page is declared once, owns its page intent, and is rendered by HomeScreen's
 * existing page composables.  Keeping this registry separate from MainActivity makes
 * it possible to add real Android Fragment wrappers later without changing navigation
 * semantics.
 */
enum class MainActivityFragmentPage(
    val homeItemId: Int,
    val title: String,
    val icon: ImageVector,
) {
    Projects(Cons.selectedItem_Repos, "项目", Icons.Filled.FolderCopy),
    Files(Cons.selectedItem_Files, "文件", Icons.Filled.Folder),
    Changes(Cons.selectedItem_ChangeList, "修改", Icons.Filled.Difference),
    Commit(Cons.selectedItem_ChangeList, "提交", Icons.Filled.Commit),
    Stash(Cons.selectedItem_ChangeList, "暂存", Icons.Filled.Save),
    Conflicts(Cons.selectedItem_ChangeList, "冲突", Icons.Filled.Merge),
    Branches(Cons.selectedItem_Repos, "分支", Icons.Filled.AccountTree),
    Diff(Cons.selectedItem_ChangeList, "对比", Icons.Filled.Source),
    Code(Cons.selectedItem_Editor, "代码", Icons.Filled.Code),
    Search(Cons.selectedItem_Repos, "搜索", Icons.Filled.Search),
    More(Cons.selectedItem_Settings, "更多", Icons.Filled.MoreHoriz);

    companion object {
        val visibleTabs = listOf(Projects, Files, Changes, Commit, Stash, Conflicts, Branches, Diff, Code, Search)

        fun selectedIndexFor(homeItemId: Int): Int {
            val index = visibleTabs.indexOfFirst { it.homeItemId == homeItemId }
            return if(index >= 0) index else 0
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainActivityFragmentTabRow(
    currentHomeItemId: Int,
    onPageSelected: (MainActivityFragmentPage) -> Unit,
    modifier: Modifier = Modifier,
) {
    val selectedIndex = MainActivityFragmentPage.selectedIndexFor(currentHomeItemId)

    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        edgePadding = 8.dp,
        modifier = modifier.fillMaxWidth(),
    ) {
        MainActivityFragmentPage.visibleTabs.forEachIndexed { index, page ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onPageSelected(page) },
                text = {
                    Text(
                        text = page.title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                icon = {
                    Icon(imageVector = page.icon, contentDescription = page.title)
                },
            )
        }
    }
}

@Composable
fun MainProjectQuickToolbar(
    repos: List<RepoEntity>,
    activeRepo: RepoEntity?,
    onProjectSelected: (RepoEntity) -> Unit,
    onBranches: (RepoEntity) -> Unit,
    onCommit: (RepoEntity) -> Unit,
    onPush: (RepoEntity) -> Unit,
    modifier: Modifier = Modifier,
) {
    if(repos.isEmpty()) {
        return
    }

    var expanded by remember { mutableStateOf(false) }
    val repo = activeRepo?.takeIf { it.id.isNotBlank() } ?: repos.firstOrNull()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 8.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AssistChip(
            onClick = { expanded = true },
            label = {
                Text(
                    text = repo?.repoName ?: "选择项目",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            },
            leadingIcon = { Icon(Icons.Filled.FolderCopy, contentDescription = null) },
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            repos.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = item.repoName,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    },
                    onClick = {
                        expanded = false
                        onProjectSelected(item)
                    },
                )
            }
        }

        if(repo != null) {
            AssistChip(
                onClick = { onBranches(repo) },
                label = {
                    Text(
                        text = repo.branch.ifBlank { "分支" },
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                leadingIcon = { Icon(Icons.Filled.AccountTree, contentDescription = null) },
            )
            AssistChip(
                onClick = { onCommit(repo) },
                label = { Text("Commit") },
                leadingIcon = { Icon(Icons.Filled.Commit, contentDescription = null) },
            )
            AssistChip(
                onClick = { onPush(repo) },
                label = { Text("Push") },
                leadingIcon = { Icon(Icons.Filled.Source, contentDescription = null) },
            )
        } else {
            Text(
                text = "没有可切换项目",
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}
