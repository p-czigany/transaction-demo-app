package com.peterczigany.transaction;

import com.peterczigany.transaction.model.Transfer;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface TransferRepository extends CrudRepository<Transfer, UUID> {}
