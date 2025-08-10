package seriyalexandrov.springai.structuredoutput

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
}