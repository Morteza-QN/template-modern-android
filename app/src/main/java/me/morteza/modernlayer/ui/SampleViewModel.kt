package me.morteza.modernlayer.ui

class SampleViewModel

/*
@HiltViewModel
class PlanetsListViewModel @Inject constructor(
    planetsRepository: PlanetsRepository
): ViewModel() {
    private val planets = planetsRepository.getPlanetsFlow()

    val uiState = planets.map { planets ->
        when (planets) {
            is WorkResult.Error -> PlanetsListUiState(isError = true)
            is WorkResult.Loading -> PlanetsListUiState(isLoading = true)
            is WorkResult.Success -> PlanetsListUiState(planets = planets.data)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = PlanetsListUiState(isLoading = true)
    )
    // ----------------------------------------------
    fun addSamplePlanets() {
        viewModelScope.launch {
            val planets = arrayOf(
                Planet(name = "Skaro", distanceLy = 0.5F, discovered = Date()),
                Planet(name = "Trenzalore", distanceLy = 5F, discovered = Date()),
                Planet(name = "Galifrey", distanceLy = 80F, discovered = Date()),
            )
            planets.forEach { addPlanetUseCase(it) }
        }
    }
    // ----------------------------------------------
    fun deletePlanet(planetId: String) {
        viewModelScope.launch {
            planetsRepository.deletePlanet(planetId)
        }
    }
    // ----------------------------------------------
    fun refreshPlanetsList() {
        viewModelScope.launch {
            planetsRepository.refreshPlanets()
        }
    }
    // ----------------------------------------------
}
* */

/*
@HiltViewModel
class AddEditPlanetViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val planetsRepository: PlanetsRepository
): ViewModel() {
    private val planetId: String? = savedStateHandle[PlanetsDestinationsArgs.PLANET_ID_ARG]

    private val _uiState = MutableStateFlow(AddEditPlanetUiState())
    val uiState: StateFlow<AddEditPlanetUiState> = _uiState.asStateFlow()

    init {
        if (planetId != null) {
            loadPlanet(planetId)
        }
    }

    private fun loadPlanet(planetId: String) {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val result = planetsRepository.getPlanetFlow(planetId).first()
            if (result !is WorkResult.Success || result.data == null) {
                _uiState.update { it.copy(isLoading = false) }
            }
            else {
                val planet = result.data
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        planetName = planet.name,
                        planetDistanceLy = planet.distanceLy,
                        planetDiscovered = planet.discovered
                    )
                }
            }
        }
    }
}
* */