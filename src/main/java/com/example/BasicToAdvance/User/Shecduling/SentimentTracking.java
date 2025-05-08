package com.example.BasicToAdvance.User.Shecduling;

import com.example.BasicToAdvance.Jarnal.Repository.JarnalRepository;
import com.example.BasicToAdvance.Jarnal.model.JarnalSchema;
import com.example.BasicToAdvance.User.Repository.UserRepository;
import com.example.BasicToAdvance.User.Service.CustomMailSender;
import com.example.BasicToAdvance.User.UserModel.UserSchema;
import jakarta.annotation.security.DenyAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SentimentTracking {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JarnalRepository jarnalRepository;

    @Autowired
    private CustomMailSender customMailSender;

    @DenyAll
    @Scheduled(cron = "0 30 9 * * SUN") // Changed to fixedRate
    public void sentMessageBaseOnSentiment() {
        System.out.println("Scheduled sentiment analysis running at: " + System.currentTimeMillis());

        try {
            List<UserSchema> userSchemas = userRepository.findAll();
            System.out.println("Found " + userSchemas.size() + " users to process");

            for (UserSchema userSchema : userSchemas) {
                List<UUID> jarnalIds = userSchema.getJarnals();
                if (jarnalIds != null && !jarnalIds.isEmpty()) {
                    List<JarnalSchema> jarnals = jarnalRepository.findAllById(jarnalIds);
                    List<String> content = jarnals.stream()
                            .map(JarnalSchema::getContent)
                            .filter(c -> c != null)
                            .toList();

                    if (!content.isEmpty()) {
                        String contentString = String.join(" ", content);
                        String sentiment = new SentimentGenerate().generateSentiment(contentString);
                        System.out.println("Sending mail to " + userSchema.getEmail());
                        customMailSender.SendMail(
                                userSchema.getEmail(),
                                "Sentiment of your jarnals is",
                                "Sentiment of your jarnals is " + sentiment
                        );
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error in scheduled task: " + e.getMessage());
            e.printStackTrace();
        }
    }
}