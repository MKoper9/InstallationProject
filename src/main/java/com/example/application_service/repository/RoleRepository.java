package com.example.application_service.repository;

import com.example.application_service.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    //SELECT * FROM role WHERE role_name=?
    Role findFirstByRoleName(String roleName);
    @Transactional
    @Modifying
    @Query(value =
            "delete from user_role where role_id = (select role_id from role where role_name = :roleName)",
            nativeQuery = true)
    void deleteAllRoleNamesFromUser(@Param("roleName") String roleName);


}
