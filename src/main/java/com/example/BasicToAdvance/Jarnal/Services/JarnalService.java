package com.example.BasicToAdvance.Jarnal.Services;

import com.example.BasicToAdvance.Jarnal.Dto.Jarnal;
import com.example.BasicToAdvance.Jarnal.Repository.JarnalRepository;
import com.example.BasicToAdvance.Jarnal.Dto.JarnalResponse;
import com.example.BasicToAdvance.Jarnal.model.JarnalSchema;
import com.example.BasicToAdvance.User.Repository.UserRepository;
import com.example.BasicToAdvance.User.UserModel.UserSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class JarnalService {
    final private JarnalRepository jarnalRepository;
    final private UserRepository userRepository;
    public JarnalService(JarnalRepository jarnalRepository, UserRepository userRepository) {
        this.jarnalRepository = jarnalRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public JarnalResponse addJarnal(Jarnal jarnal,String email) {

        UserSchema userSchema=userRepository.findByEmail(email);

        JarnalSchema jarnalSchema=new JarnalSchema(jarnal);
        jarnalSchema.setEmail(email);
        JarnalSchema savedJarnal=jarnalRepository.save(jarnalSchema);

        userSchema.getJarnals().add(savedJarnal.getId());
        userRepository.save(userSchema);
        return new JarnalResponse(savedJarnal);
    }

    public JarnalResponse getJarnal(UUID id) {
        JarnalSchema jarnalSchema=jarnalRepository.findById(id).orElseThrow(()->new RuntimeException("Jarnal not found with ID: "+id));
        return new JarnalResponse(jarnalSchema);
    }

    public JarnalResponse getJarnalByName(String title) {
        try {
            JarnalSchema jarnalSchema=jarnalRepository.findByTitle(title);
//        if(jarnalSchema==null){
//            throw new RuntimeException("Jarnal not found with name: "+name);
//        }
            return new JarnalResponse(jarnalSchema);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<JarnalResponse> getAllJarnals() {
        List<JarnalSchema> jarnalSchemas=jarnalRepository.findAll();
        List<JarnalResponse> jarnalResponses=jarnalSchemas.stream().map(data->new JarnalResponse(data)).toList();
        return jarnalResponses;
    }

    public JarnalResponse updateJarnal(Jarnal jarnal) {
        JarnalSchema jarnalSchema=jarnalRepository.findById(jarnal.getId()).orElseThrow(()->new RuntimeException("Jarnal not found with ID: "+jarnal.getId()));
        jarnalSchema.setContent(jarnal.getContent());
        jarnalSchema.setTitle(jarnal.getTitle());
        JarnalSchema savedJarnal=jarnalRepository.save(jarnalSchema);
        return new JarnalResponse(savedJarnal);
    }

    public void deleteJarnal(UUID jarnalId) {
        JarnalSchema jarnalSchema = jarnalRepository.findById(jarnalId)
                .orElseThrow(() -> new RuntimeException("Journal not found"));

        // Get the user associated with the journal
        UserSchema userSchema = userRepository.findByEmail(jarnalSchema.getEmail());

        if (userSchema != null) {
            userSchema.getJarnals().remove(jarnalId); // Remove the journal ID from user details
            userRepository.save(userSchema); // Save updated user details
        }

        // Delete the journal
        jarnalRepository.deleteById(jarnalId);
    }

}
