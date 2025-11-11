package com.beeproductive.backend.repository;

import com.beeproductive.backend.entity.MemberDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDetailsRepository extends JpaRepository<MemberDetails, Long> {
}
