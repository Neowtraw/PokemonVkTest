package com.twixvj.pokemonvktest.presentation.info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.twixvj.pokemonvktest.domain.use_cases.GetPokemonInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonInfoViewModel @Inject constructor(
    private val getPokemonInfoUseCase: GetPokemonInfoUseCase,
) : ViewModel() {
    private val _viewState: MutableStateFlow<PokemonInfoViewState> =
        MutableStateFlow(PokemonInfoViewState.Loading)
    val viewState = _viewState.asStateFlow()

    private var state = PokemonInfoState()

    private fun applyAction(
        action: PokemonInfoAction,
        state: PokemonInfoState
    ): PokemonInfoState =
        when (action) {
            is PokemonInfoAction.Init -> state.copy(isLoading = true, name = action.name)
            is PokemonInfoAction.PokemonInfoLoaded -> state.copy(
                isLoading = false,
                info = action.result
            )

            is PokemonInfoAction.LoadError -> state.copy(isLoading = false, error = action.error)
        }

    private fun submitSideEffect(sideEffect: PokemonInfoSideEffect) {
        when (sideEffect) {
            is PokemonInfoSideEffect.LoadPokemonInfo -> getPokemonInfo(state.name)
        }
    }

    fun submitAction(action: PokemonInfoAction) {
        state = applyAction(action, state)

        _viewState.update { changeViewState(state) }

        when (action) {
            is PokemonInfoAction.Init -> submitSideEffect(PokemonInfoSideEffect.LoadPokemonInfo)
            is PokemonInfoAction.LoadError,
            is PokemonInfoAction.PokemonInfoLoaded -> Unit
        }
    }

    private fun changeViewState(state: PokemonInfoState): PokemonInfoViewState =
        when {
            state.isLoading -> PokemonInfoViewState.Loading
            !state.error.isNullOrBlank() -> PokemonInfoViewState.Error(state.error)
            else -> PokemonInfoViewState.Result(state.info)
        }

    private fun getPokemonInfo(name: String) {
        viewModelScope.launch {
            getPokemonInfoUseCase(name = name)
                .onSuccess { result ->
                    submitAction(PokemonInfoAction.PokemonInfoLoaded(result))
                }
                .onFailure { throwable ->
                    submitAction(PokemonInfoAction.LoadError(throwable.message ?: FATAL))
                }
        }
    }

    companion object {
        private const val FATAL = "FATAL"
    }
}
