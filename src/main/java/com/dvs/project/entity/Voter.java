
package com.dvs.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Voter {
    @Id
    private String identifier; // could be address or email
    private boolean voted = false;
}
