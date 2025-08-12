package seriyalexandrov.springai.structuredoutput

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StructuredOutputServiceChatTest {

    @Autowired
    lateinit var chatService: StructuredOutputService

    @Test
    fun `should return a LLM response`() {
        val response = chatService.solveEquation("5.9x = x^2 + 5.11x")!!

        assertThat(response.results).containsExactlyInAnyOrder(0.0, 0.79)
        response.resolutionSteps.forEach {
            assertThat(it.appliedAction).isNotBlank
            assertThat(it.currentEquation).isNotBlank
            assertThat(it.briefExplanation).isNotBlank
        }
    }

    @Test
    fun `should solve a logical problem`() {
        val response = chatService.solveLogicalProblem(
            "У меня есть металлическая чашка, но у неё наглухо закрыто верхнее отверстие. " +
                    "Также у неё отпилено дно. Как из неё можно пить? " +
                    "Переделать чашку нельзя, держать воду рукой тоже."
        )!!

        val beautified = jacksonObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response)
        println(beautified)
    }


}