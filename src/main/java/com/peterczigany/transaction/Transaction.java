package com.peterczigany.transaction;

import java.math.BigDecimal;
import java.util.UUID;

public class Transaction {
  private UUID id;
  private String sender;
  private String recipient;
  private BigDecimal amount;

  public Transaction(UUID id, String sender, String recipient, BigDecimal amount) {
    this.id = id;
    this.sender = sender;
    this.recipient = recipient;
    this.amount = amount;
  }
}
