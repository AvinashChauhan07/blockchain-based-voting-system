
package com.dvs.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class VoteRecord {
    @Id
    private String id; // composite id e.g. voter::timestamp
    private String voterId;
    private Long candidateId;
    private String txHash; // optional on-chain tx hash
    private String timestamp;
}
