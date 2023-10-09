package com.santander_spring_boot_dio.domain.repository;

import com.santander_spring_boot_dio.domain.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    boolean existsByAccountNumber(String accountNumber);
}
