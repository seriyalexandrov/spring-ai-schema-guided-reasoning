package seriyalexandrov.springai.structuredoutput

import org.springframework.ai.chat.client.ChatClient
import org.springframework.stereotype.Service

@Service
class StructuredOutputService(
    private val chatClient: ChatClient,
) {

    fun solveEquation(equation: String): EquationSolution? = chatClient
        .prompt()
        .user { it.text("Solve equation: $equation") }
        .call()
        .entity(EquationSolution::class.java)

    fun solveLogicalProblem(problem: String): LogicalProblemSolution? = chatClient
        .prompt()
        .user { it.text("Solve this logical puzzle: $problem") }
        .call()
        .entity(LogicalProblemSolution::class.java)
}
