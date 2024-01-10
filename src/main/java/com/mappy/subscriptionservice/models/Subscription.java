package com.mappy.subscriptionservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Sharded;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Subscription")
public class Subscription {
    @Id
    private int id;
    private Long accountId;
    private Long projectId;

    public Subscription(Long accountId, Long projectId) {
        this.accountId = accountId;
        this.projectId = projectId;
    }
}
