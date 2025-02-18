package Bashiru.com.Core.Banking.System.repository;

import Bashiru.com.Core.Banking.System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.userName = :userName AND u.password = :password")
    User findUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}

