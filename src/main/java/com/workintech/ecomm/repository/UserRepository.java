package com.workintech.ecomm.repository;

import com.workintech.ecomm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User deleteById(long id);
}
