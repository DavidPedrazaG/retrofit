@file:OptIn(ExperimentalMaterial3Api::class)

package eam.retrtofit.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.viewmodel.compose.viewModel
import eam.retrtofit.ui.screens.HomeScreen
import eam.retrtofit.ui.viewmodel.CharacterViewModel

@Composable
fun MarvelCharactersApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { MarvelTopAppBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val characterViewModel: CharacterViewModel =
                viewModel(factory = CharacterViewModel.Factory)
            HomeScreen(
                characterUiState = characterViewModel.characterUiState,
                retryAction = characterViewModel::getCharacters,
                contentPadding = it
            )
        }
    }
}

@Composable
fun MarvelTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = "Marvel Characters",
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier
    )
}