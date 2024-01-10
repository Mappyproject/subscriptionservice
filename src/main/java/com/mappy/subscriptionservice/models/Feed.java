package com.mappy.subscriptionservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Sharded;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Subscription")
public class Feed {
    @Id
    private int id;
    private Long accountId;
    private List<Long> project_ids;

    public Feed(Long accountId, List<Long> project_ids) {
        this.accountId = accountId;
        this.project_ids = project_ids;
    }
}
