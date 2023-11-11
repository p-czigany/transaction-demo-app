package com.peterczigany.transaction.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "transfer")
public class Transfer {
  @Id private UUID id;
  private String sender;
  private String recipient;
  private BigDecimal amount;
  private LocalDateTime localDateTime;

  public Transfer() {}

  public Transfer(
      UUID id, String sender, String recipient, BigDecimal amount, LocalDateTime localDateTime) {
    this.id = id;
    this.sender = sender;
    this.recipient = recipient;
    this.amount = amount;
    this.localDateTime = localDateTime;
  }

  public UUID getId() {
    return id;
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

  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public void setLocalDateTime(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime;
  }
}
