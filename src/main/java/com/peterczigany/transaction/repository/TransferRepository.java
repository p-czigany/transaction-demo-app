package com.peterczigany.transaction.repository;

import com.peterczigany.transaction.model.Transfer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface TransferRepository extends CrudRepository<Transfer, UUID> {
  List<Transfer> findByLocalDateTimeBetween(LocalDateTime firstTime, LocalDateTime lastTime);
}
