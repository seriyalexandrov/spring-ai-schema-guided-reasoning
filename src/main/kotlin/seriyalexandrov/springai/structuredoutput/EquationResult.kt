package seriyalexandrov.springai.structuredoutput

import com.fasterxml.jackson.annotation.JsonPropertyDescription

data class EquationResult(
    val resolutionSteps: List<Step>,
    val results: List<Double>,
)

data class Step(
    @field:JsonPropertyDescription("Which action was applied to the equation?")
    val appliedAction: String,

    val currentEquation: String,

    @field:JsonPropertyDescription("Why this action is needed?")
    val briefExplanation: String,
)
