package com.peterczigany.transaction;

import java.math.BigDecimal;
import java.util.UUID;

public class Transaction {
  private final UUID id;
  private final String sender;
  private final String recipient;
  private final BigDecimal amount;

  public Transaction(UUID id, String sender, String recipient, BigDecimal amount) {
    this.id = id;
    this.sender = sender;
    this.recipient = recipient;
    this.amount = amount;
  }

  public String getSender() {
    return sender;
  }

  public String getRecipient() {
    return recipient;
  }

  public BigDecimal getAmount() {
    return amount;
  }
}
