package seriyalexandrov.springai.structuredoutput

import org.springframework.ai.chat.client.ChatClient
import org.springframework.stereotype.Service

@Service
class StructuredOutputService(
    private val chatClient: ChatClient,
) {

    fun solveEquation(equation: String): EquationResult? = chatClient
        .prompt()
        .user { it.text("Solve equation: $equation") }
        .call()
        .entity(EquationResult::class.java)
}
