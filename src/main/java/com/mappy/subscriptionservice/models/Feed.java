package com.mappy.subscriptionservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountId;
    @ElementCollection
    private List<Long> project_ids;

    public Feed(Long accountId, List<Long> project_ids) {
        this.accountId = accountId;
        this.project_ids = project_ids;
    }
}
