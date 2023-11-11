package com.peterczigany.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
  private final UUID id;
  private final String sender;
  private final String recipient;
  private final BigDecimal amount;
  private final LocalDateTime localDateTime;

  public Transaction(
      UUID id, String sender, String recipient, BigDecimal amount, LocalDateTime localDateTime) {
    this.id = id;
    this.sender = sender;
    this.recipient = recipient;
    this.amount = amount;
    this.localDateTime = localDateTime;
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
