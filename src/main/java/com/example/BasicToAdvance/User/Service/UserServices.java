package com.example.BasicToAdvance.User.Service;

import com.example.BasicToAdvance.Jarnal.Dto.JarnalResponse;
import com.example.BasicToAdvance.Jarnal.Repository.JarnalRepository;
import com.example.BasicToAdvance.Jarnal.model.JarnalSchema;
import com.example.BasicToAdvance.User.Repository.UserRepository;
import com.example.BasicToAdvance.User.UserDto.UserAuditDto;
import com.example.BasicToAdvance.User.UserDto.User;
import com.example.BasicToAdvance.User.UserDto.UserResponse;
import com.example.BasicToAdvance.User.UserModel.UserSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.history.Revision;
import org.springframework.data.history.RevisionMetadata;
import org.springframework.data.history.Revisions;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class UserServices {

//    @Value("${jwt.token}")
//    private String token;


    private static final Logger logger = LoggerFactory.getLogger(UserServices.class);

    private final UserRepository userRepository;
    final private JarnalRepository jarnalRepository;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServices(UserRepository userRepository,JarnalRepository jarnalRepository) {
        this.userRepository = userRepository;
        this.jarnalRepository = jarnalRepository;
//        System.out.println(token);
    }

    public UserResponse addUser(User user) {
       try {
           user.setPassword(passwordEncoder.encode(user.getPassword()));
           UserSchema data=userRepository.findByEmail(user.getEmail());
        if(data!=null){
            throw new RuntimeException("User already exists with email: " + user.getEmail());
        }
           UserSchema userSchema = new UserSchema(user);
           userSchema.getRoles().add("USER");
           UserSchema savedUser = userRepository.save(userSchema);
           return new UserResponse(savedUser);
       }
       catch (Exception e) {
           logger.error(e.getMessage());
           throw new RuntimeException(e.getMessage());
       }
    }

    public UserResponse getUser(String email) {
        UserSchema userSchema = userRepository.findByEmail(email);
        if (userSchema == null) {
            throw new RuntimeException("User not found with email: " + email);
        }
        return new UserResponse(userSchema);
    }

    public UserResponse updateUser(User user) {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String email = authentication.getName();
      UserSchema userSchema = userRepository.findByEmail(email);
      if (userSchema == null) {
          throw new RuntimeException("User not found with email: " + email);
      }

        userSchema.setName(user.getName()!=null?user.getName():userSchema.getName());
        userSchema.setEmail(user.getEmail()!=null?user.getEmail():userSchema.getEmail());
        userSchema.setPassword(passwordEncoder.encode(user.getPassword()));
        UserSchema savedUser = userRepository.save(userSchema);
        return new UserResponse(savedUser);
    }

    public void deleteUser(String email) {
        UserSchema userSchema = userRepository.findByEmail(email);
        if (userSchema == null) {
            throw new RuntimeException("User not found with email: " + email);
        }
        userRepository.delete(userSchema);
    }

    public UserResponse getUserById(UUID id) {
        UserSchema userSchema = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        return new UserResponse(userSchema);
    }

    public User getUserByEmail(String email) {
        UserSchema userSchema = userRepository.findByEmail(email);
        if (userSchema == null) {
            throw new RuntimeException("User not found with email: " + email);
        }
        return userSchema.toUser();
    }

    public List<UserResponse> getAllUsers() {
        List<UserSchema> userSchemas = userRepository.findAll();
//        List<UserResponse> userResponses = new UserResponse().toUserResponses(userSchemas);
//        return userResponses;

        List<UserResponse> user=userSchemas.stream().map(
                data->new UserResponse(
                        data.getId(),
                        data.getName(),
                        data.getEmail(),
                        data.getJarnals()
                )
        ).toList();
        return user;
    }

    @Transactional
    public List<JarnalResponse> getUserJarnals(String email) {
        UserSchema userSchema = userRepository.findByEmail(email);
        if (userSchema == null) {
            throw new RuntimeException("User not found with email: " + email);
        }
        List<UUID> jarnalsId = userSchema.getJarnals();
        List<JarnalSchema> jarnals= jarnalRepository.findAllById(jarnalsId);
//        List<JarnalResponse> jarnalResponses = jarnals.stream().map(data->new JarnalResponse(data)).toList();
        List<JarnalResponse> jarnalResponses = new JarnalResponse().toJarnalResponses(jarnals);
        return jarnalResponses;
    }


    public UserResponse addAdmin(String email){
        UserSchema user=userRepository.findByEmail(email);
        if(user==null){
            throw new RuntimeException("user not found");
        }
        user.getRoles().add("ADMIN");
        UserSchema save=userRepository.save(user);
        UserResponse userResponse= new UserResponse(save);
        return userResponse;
    }



//    public List<Revision<Integer, UserSchema>> findRevisions(UUID id) {
//        Revisions<Integer, UserSchema> revisions = userRepository.findRevisions(id);
//        List<Revision<Integer, UserSchema>> revisionList = new ArrayList<>();
//        for(Revision<Integer, UserSchema> revision : revisions) {
//            revisionList.add(revision);
//        }
//        return revisionList;
//    }

    public List<UserAuditDto> findRevisions(UUID id) {
        Revisions<Integer, UserSchema> revisions = userRepository.findRevisions(id);
        List<UserAuditDto> revisionList = new ArrayList<>();
        for(Revision<Integer, UserSchema> revision : revisions) {
            revisionList.add(new UserAuditDto(revision));
//            revisionList.add(convertToRevisionDto(revision));
        }
        return revisionList;
    }

    private UserAuditDto convertToRevisionDto(Revision<Integer, UserSchema> revision) {
        UserSchema user = revision.getEntity();
        RevisionMetadata<Integer> metadata = revision.getMetadata();

        return new UserAuditDto(
                metadata.getRevisionNumber().orElse(null),
                metadata.getRevisionType(),
                metadata.getRevisionInstant().orElse(null),
                user,
                user.getModifiedBy(),
                user.getModifiedAt()
        );
    }
}
