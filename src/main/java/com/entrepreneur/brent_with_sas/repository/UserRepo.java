package com.entrepreneur.brent_with_sas.repository;

import com.entrepreneur.brent_with_sas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    List<User> findByUserName(User user);

    Optional<User> findByUserName(String userName);
}
