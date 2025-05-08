package com.example.BasicToAdvance.User.UserDto;

import com.example.BasicToAdvance.User.UserModel.UserSchema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private UUID id;
    private String name;
    private String email;
    private List<UUID> jarnals= new ArrayList<>();

    public UserResponse(UserSchema userSchema) {
        this.id = userSchema.getId();
        this.name = userSchema.getName();
        this.email = userSchema.getEmail();
        this.jarnals = userSchema.getJarnals();
    }

    public List<UserResponse> toUserResponses(List<UserSchema> userSchemas) {
        List<UserResponse> userResponses = new ArrayList<>();
       for(UserSchema userSchema : userSchemas) {
           userResponses.add(new UserResponse(userSchema));
       }
       return userResponses;
    }
    public UserResponse toUserResponse(UserSchema userSchema) {
        return new UserResponse(userSchema);
    }
}
