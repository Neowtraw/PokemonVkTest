package com.twixvj.pokemonvktest.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.twixvj.pokemonvktest.domain.use_cases.GetAllPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllPokemonsViewModel @Inject constructor(
    private val getAllPokemonsUseCase: GetAllPokemonsUseCase,
) : ViewModel() {
    private val _viewState: MutableStateFlow<AllPokemonsViewState> =
        MutableStateFlow(AllPokemonsViewState.Loading)
    val viewState = _viewState.asStateFlow()

    private var state = AllPokemonsState()

    private fun applyAction(action: AllPokemonsAction, state: AllPokemonsState): AllPokemonsState =
        when (action) {
            AllPokemonsAction.Init -> state.copy(isLoading = true)
            is AllPokemonsAction.LoadError -> state.copy(isLoading = false, error = action.error)
            is AllPokemonsAction.PokemonsLoaded -> state.copy(
                isLoading = false,
                pokemons = action.result,
            )
        }

    private fun submitSideEffect(sideEffect: AllPokemonsSideEffect) {
        when (sideEffect) {
            is AllPokemonsSideEffect.LoadPokemons -> getAllPokemons()
        }
    }

    fun submitAction(action: AllPokemonsAction) {
        state = applyAction(action, state)

        _viewState.update { changeViewState(state) }

        when (action) {
            AllPokemonsAction.Init -> submitSideEffect(AllPokemonsSideEffect.LoadPokemons)
            is AllPokemonsAction.LoadError,
            is AllPokemonsAction.PokemonsLoaded -> Unit
        }
    }

    private fun changeViewState(state: AllPokemonsState): AllPokemonsViewState =
        when {
            state.isLoading -> AllPokemonsViewState.Loading
            !state.error.isNullOrBlank() -> AllPokemonsViewState.Error(state.error)
            else -> AllPokemonsViewState.Result(state.pokemons)
        }

    private fun getAllPokemons() {
        viewModelScope.launch {
            getAllPokemonsUseCase()
                .onSuccess { result ->
                    submitAction(AllPokemonsAction.PokemonsLoaded(result))
                }
                .onFailure { throwable ->
                    submitAction(AllPokemonsAction.LoadError(throwable.message ?: FATAL))
                }
        }
    }

    companion object {
        private const val FATAL = "FATAL"
    }
}
