import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.peterczigany.transaction.TransactionApplication;
import com.peterczigany.transaction.model.Transfer;
import com.peterczigany.transaction.repository.TransferRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.MOCK,
    classes = TransactionApplication.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class TransactionApplicationIntegrationTest {

  @Autowired private MockMvc mockMvc;

  @Autowired private TransferRepository repository;

  @Test
  void endpointTest() throws Exception {
    putValuesIntoDb();
    LocalDateTime firstTime = LocalDateTime.of(2024, 1, 1, 0, 1);
    LocalDateTime lastTime = LocalDateTime.of(2024, 1, 2, 0, 0);

    mockMvc
        .perform(
            get("/api/transactions/")
                .param("firstTime", firstTime.toString())
                .param("lastTime", lastTime.toString())
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));
  }

  private void putValuesIntoDb() {
    repository.save(createDummyTransferForTime(LocalDateTime.of(2024, 1, 1, 0, 0)));
    repository.save(createDummyTransferForTime(LocalDateTime.of(2024, 1, 1, 0, 1)));
    repository.save(createDummyTransferForTime(LocalDateTime.of(2024, 1, 2, 0, 0)));
    repository.save(createDummyTransferForTime(LocalDateTime.of(2024, 1, 2, 0, 1)));
  }

  private Transfer createDummyTransferForTime(LocalDateTime localDateTime) {
    return new Transfer(
        UUID.randomUUID(), "someTestSender", "someTestRecipient", BigDecimal.TEN, localDateTime);
  }
}
