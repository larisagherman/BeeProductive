package com.beeproductive.backend.repository;

import com.beeproductive.backend.entity.MemberDetails;
import com.beeproductive.backend.entity.MemberKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDetailsRepository extends JpaRepository<MemberDetails, MemberKey> {
}
