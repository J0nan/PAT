package info.jab.microservices.repository;


import info.jab.microservices.model.UserDetail;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserDetailRepository extends CrudRepository<UserDetail, Long> {

    @Query("SELECT TOP 1 * FROM USER_DETAILS WHERE USERNAME= :username")
    UserDetail getUserDetailByUserName(@Param("username") String username);

    @Query("UPDATE USER_DETAILS SET USER_DETAILS.password= :password WHERE USER_DETAILS.username= :username ")
    @Modifying
    int updatePasswordByUserName(@Param("username") String username, @Param("password") String newPassword);
}