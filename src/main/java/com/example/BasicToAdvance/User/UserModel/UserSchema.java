package com.example.BasicToAdvance.User.UserModel;

import com.example.BasicToAdvance.User.UserDto.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Table(name="t_user")
@Getter
@Setter
@Audited
public class UserSchema extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name = "Default Name"; // Default value set

    @Column(nullable = false, unique = true, length = 100)
    private String email = "default@email.com"; // Default value set

    @Column(nullable = false, length = 150)
    private String password = "defaultPassword"; // Default value set

    @Column(name="jarnals")
    private List<UUID> jarnals=new ArrayList<>();

    @Column(name="SentimentAnalyzer")
    private Boolean isSentimentAnalyzer=false;

    @Column(name="Role")
    private List<String> roles=new ArrayList<>();



    public UserSchema(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public User toUser(){
        User user = new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setEmail(this.email);
        return user;
    }


}
