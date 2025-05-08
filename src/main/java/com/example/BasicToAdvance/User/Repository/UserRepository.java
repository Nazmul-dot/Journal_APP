package com.example.BasicToAdvance.User.Repository;

import com.example.BasicToAdvance.User.UserDto.User;
import com.example.BasicToAdvance.User.UserModel.UserSchema;
import org.springframework.data.envers.repository.support.EnversRevisionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserSchema, UUID>, RevisionRepository<UserSchema, UUID, Integer> {
    UserSchema findByEmail(String email);
    UserSchema findByName(String name);
}
