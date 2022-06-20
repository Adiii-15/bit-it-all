package com.isu.cs309.biditall.repository;

import com.isu.cs309.biditall.model.Seller;
import com.isu.cs309.biditall.model.User;
import org.javatuples.Triplet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * interface used to connect to database
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // Custom Queries

    @Query(value = "SELECT *" +
            "FROM users u " +
            "JOIN login l ON l.id = u.login_id " +
            "WHERE l.username = ?1", nativeQuery = true)
    User findUserByUsername(String username);

    @Query(value = "SELECT * " +
            "FROM users u " +
            "JOIN seller s ON s.user_id = u.user_id " +
            "WHERE s.rating = (SELECT MAX(s.rating) FROM seller)",nativeQuery = true)
    List<User> getSellersWithHighestRating();

 

}
