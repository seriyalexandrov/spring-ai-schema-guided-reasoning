package seriyalexandrov.springai

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ChatServiceLiveTest {

    @Autowired
    lateinit var chatService: ChatService

    @Test
    fun `should return a LLM response`() {
        val response1 = chatService.chat("count from 1 to 5")
        println(response1)
        assertThat(response1).isNotEmpty()
    }
}
