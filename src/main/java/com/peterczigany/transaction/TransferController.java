package com.peterczigany.transaction;

import com.peterczigany.transaction.model.Transfer;
import com.peterczigany.transaction.repository.TransferRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransferController {

  @Autowired TransferRepository repository;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Transfer> getTransactionsInTimeInterval(
      @RequestParam LocalDateTime firstTime, @RequestParam LocalDateTime lastTime) {

    return repository.findByLocalDateTimeBetween(firstTime, lastTime);
  }
}
