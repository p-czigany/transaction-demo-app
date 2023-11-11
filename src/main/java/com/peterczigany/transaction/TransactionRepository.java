package com.peterczigany.transaction;

import com.peterczigany.transaction.model.Transaction;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, UUID> {}
