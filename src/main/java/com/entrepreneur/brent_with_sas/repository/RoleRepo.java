package com.entrepreneur.brent_with_sas.repository;

import com.entrepreneur.brent_with_sas.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, String> {
}
