package com.ZenPack.repository;

import com.ZenPack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findOneByEmailIdIgnoreCaseAndPassword(String emailId, String password);
}
