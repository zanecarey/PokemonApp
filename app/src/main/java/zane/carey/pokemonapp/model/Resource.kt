package zane.carey.pokemonapp.model


interface ResourceSummary {
    val id: Int
    val category: String
    val url: String
}

data class ApiResource(
    override val category: String,
    override val id: Int,
    override val url: String
) : ResourceSummary

data class NamedApiResource(
    val name: String,
    override val category: String,
    override val id: Int,
    override val url: String
) : ResourceSummary

data class Name(
    val name: String,
    val language: NamedApiResource
)

data class Description(
    val description: String,
    val language: NamedApiResource
)

interface ResourceSummaryList<out T : ResourceSummary> {
    val count: Int
    val next: String?
    val previous: String?
    val results: List<T>
}

data class ApiResourceList(
    override val count: Int,
    override val next: String?,
    override val previous: String?,
    override val results: List<ApiResource>
) : ResourceSummaryList<ApiResource>

data class NamedApiResourceList(
    override val count: Int,
    override val next: String?,
    override val previous: String?,
    override val results: List<NamedApiResource>
) : ResourceSummaryList<NamedApiResource>

data class VerboseEffect(
    val effect: String,
    val shortEffect: String,
    val language: NamedApiResource
)

data class VersionEncounterDetail(
    val version: NamedApiResource,
    val maxChance: Int,
    val encounterDetails: List<Encounter>
)

data class VersionGameIndex(
    val gameIndex: Int,
    val version: NamedApiResource
)

data class VersionGroupFlavorText(
    val text: String,
    val language: NamedApiResource,
    val versionGroup: NamedApiResource
)

data class Encounter(
    val minLevel: Int,
    val maxLevel: Int,
    val conditionValues: List<NamedApiResource>,
    val chance: Int,
    val method: NamedApiResource
)

data class GenerationGameIndex(
    val gameIndex: Int,
    val generation: NamedApiResource
)

data class Effect(
    val effect: String,
    val language: NamedApiResource
)

data class AbilityEffectChange(
    val effectEntries: List<Effect>,
    val versionGroup: NamedApiResource
)