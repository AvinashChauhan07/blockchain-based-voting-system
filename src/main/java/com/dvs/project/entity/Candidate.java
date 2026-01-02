
package com.dvs.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Candidate {
    @Id
    private Long id;
    private String name;
    private String party;
    private Long voteCount = 0L;
}
