package io.github.omydagreat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.touchlab.kermit.Logger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.browser.window
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Suppress("PropertyName", "kotlin:S117")
@Serializable
data class Repository(
    val name: String,
    val html_url: String,
    val pushed_at: String,
)

@Composable
fun App() {
    var repositories by remember { mutableStateOf(listOf<Repository>()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val httpClient =
        HttpClient(Js) { install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) } }

    LaunchedEffect(Unit) {
        while (true) {
            try {
                repositories = fetchRepositories(httpClient)
                errorMessage = null
            } catch (e: Exception) {
                errorMessage = "Failed to fetch repositories: ${e.message}"
            }
            delay(60000) // Update every 60 seconds
        }
    }

    MaterialTheme {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            val scrollState = rememberScrollState()
            Box(Modifier.fillMaxWidth().padding(16.dp).verticalScroll(scrollState)) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text("Om Gupta", style = typography.h4)
                        Text("Kotlin Developer", style = typography.h6)
                        Text(
                            "Welcome to my GitHub page! Here you'll find my projects and contributions.")
                        errorMessage?.let { Text(it, color = MaterialTheme.colors.error) }
                        repositories.forEach { repo ->
                            Button(onClick = { window.open(repo.html_url, "_blank") }) {
                                Text(repo.name)
                            }
                        }
                    }
            }
        }
    }
}

suspend fun fetchRepositories(client: HttpClient): List<Repository> {
    Logger.i("Fetching repositories...")
    val response: HttpResponse = client.get("https://api.github.com/users/omydagreat/repos")
    Logger.i("Received response with status: ${response.status.value}")
    if (!response.status.isSuccess()) {
        throw Exception("Network request failed with status ${response.status}")
    }
    val repos: List<Repository> = response.body()
    Logger.i("Decoded repositories: \n$repos")
    return repos.filter { !it.name.contains("OmyDaGreat") }.sortedByDescending { it.pushed_at }
}
