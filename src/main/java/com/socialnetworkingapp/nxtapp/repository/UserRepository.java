package com.socialnetworkingapp.nxtapp.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.socialnetworkingapp.nxtapp.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(final String email);
}
