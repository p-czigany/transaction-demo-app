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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = TransactionApplication.class)
@AutoConfigureMockMvc
class TransactionApplicationIntegrationTest {

  @Autowired private MockMvc mockMvc;

  @Autowired private TransferRepository repository;

  private static final LocalDateTime firstTime = LocalDateTime.of(2024, 1, 1, 0, 1);
  private static final LocalDateTime lastTime = LocalDateTime.of(2024, 1, 2, 0, 0);

  @Test
  void successfulRequest() throws Exception {
    putValuesIntoDb();

    mockMvc
        .perform(
            get("/transactions")
                .param("firstTime", firstTime.toString())
                .param("lastTime", lastTime.toString())
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));
  }

  @Test
  void badRequest_whenTimeFrameIsMissing() throws Exception {
    mockMvc
        .perform(get("/transactions").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  @Test
  void badRequest_whenBadParamNames() throws Exception {
    mockMvc
        .perform(
            get("/transactions")
                .param("firstDate", firstTime.toString())
                .param("lastDate", lastTime.toString())
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  @ParameterizedTest
  @ValueSource(strings = {"2024-01-02", "2024-01-02T00", "2024-01-02 00:00:00"})
  void badRequest_whenBadFormat(String timeParam) throws Exception {
    mockMvc
        .perform(
            get("/transactions")
                .param("firstTime", "2024-01-01T00:01:00")
                .param("lastTime", timeParam)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
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
