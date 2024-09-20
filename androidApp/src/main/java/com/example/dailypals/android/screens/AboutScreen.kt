package com.example.dailypals.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.dailypals.Platform

@Composable
fun AboutScreen() {
    Column {
        Toolbar()
        ContentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar() {
    TopAppBar(
        title = { Text("About") },
    )
}

@Composable
private fun ContentView() {
    val list = makeItems()
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        //contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(list) { row ->
            RowView(
                title = row.first,
                subtitle = row.second
            )
        }
    }
}

@Composable
fun RowView(title: String, subtitle: String) {
    Column(
        Modifier.padding(8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyLarge
        )
    }
    Divider()
}

private fun makeItems(): List<Pair<String, String>> {
    val platform = Platform()
    return listOf(
        Pair("Platform", "${platform.osName} ${platform.osVersion}"),
        Pair("Model", platform.deviceModel),
        Pair("Screen density", platform.screenDensity.toString())
    )

}