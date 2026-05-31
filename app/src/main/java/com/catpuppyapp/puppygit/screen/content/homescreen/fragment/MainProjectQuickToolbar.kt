package com.catpuppyapp.puppygit.screen.content.homescreen.fragment

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.Commit
import androidx.compose.material.icons.filled.FolderCopy
import androidx.compose.material.icons.filled.Source
import androidx.compose.material3.AssistChip
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.catpuppyapp.puppygit.data.entity.RepoEntity

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
