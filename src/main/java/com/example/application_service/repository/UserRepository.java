package com.example.application_service.repository;

import com.example.application_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

//    @Query(
//            value = "SELECT email, role_name FROM user JOIN user_role"+
//                    "ON (user.user_id = user_role.user_id) JOIN role"+
//                    "ON (role.role_id = user_role.role_id)",
//            nativeQuery = true;
//    )
//    List<Object[]>findAllEmailAndRoleName();

//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE user SET status=:status",nativeQuery = true)
//    void changeStatusToUsers(@Param("status"),Boolean status);

}
