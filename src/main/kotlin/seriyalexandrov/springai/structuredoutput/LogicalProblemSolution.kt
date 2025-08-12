package seriyalexandrov.springai.structuredoutput

import com.fasterxml.jackson.annotation.JsonPropertyDescription

data class LogicalProblemSolution(
    @field:JsonPropertyDescription("What we want to achieve?")
    val finalObjective: String,

    @field:JsonPropertyDescription("Which conditions should be satisfied to achieve the final objective?")
    val conditions: List<String>,

    @field:JsonPropertyDescription("Let's outline any ideas, even the most crazy ones")
    val ideas: List<String>,

    @field:JsonPropertyDescription("Let's briefly outline the promising ideas")
    val promisingIdeas: List<Idea>,

    val bestIdea: String,

    val doesBestIdeaSatisfyConditions: Boolean,

    @field:JsonPropertyDescription("Keep empty if idea doesn't satisfy any condition")
    val finalSolution: String?,
)

data class Idea(
    @field:JsonPropertyDescription("Briefly describe the idea")
    val idea: String,

    val satisfiedConditions: List<String>,

    val unsatisfiedConditions: List<String>,

    val isIdeaAcceptable: Boolean,
)