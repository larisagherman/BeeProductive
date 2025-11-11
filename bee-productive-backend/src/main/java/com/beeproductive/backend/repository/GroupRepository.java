package com.beeproductive.backend.repository;

import com.beeproductive.backend.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
