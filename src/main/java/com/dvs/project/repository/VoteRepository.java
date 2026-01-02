
package com.dvs.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dvs.project.entity.VoteRecord;

public interface VoteRepository extends JpaRepository<VoteRecord, String> { }
