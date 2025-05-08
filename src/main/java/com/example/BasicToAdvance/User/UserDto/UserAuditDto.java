package com.example.BasicToAdvance.User.UserDto;
import com.example.BasicToAdvance.User.UserModel.UserSchema;
import lombok.*;
import org.springframework.data.history.Revision;
import org.springframework.data.history.RevisionMetadata;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserAuditDto {
    private Integer revisionNumber;
    private RevisionMetadata.RevisionType revisionType;
    private Instant revisionTimestamp;
    private UserSchema userData;
    private String modifiedBy;
    private LocalDateTime modifiedAt;

    public UserAuditDto(Revision<Integer, UserSchema> revision){
        UserSchema user = revision.getEntity();
        RevisionMetadata<Integer> metadata = revision.getMetadata();

        this.revisionNumber = metadata.getRevisionNumber().orElse(null);
        this.revisionType = metadata.getRevisionType();
        this.revisionTimestamp = metadata.getRevisionInstant().orElse(null);
        this.userData = user;
        this.modifiedBy = user.getModifiedBy();
        this.modifiedAt = user.getModifiedAt();
    }
}
