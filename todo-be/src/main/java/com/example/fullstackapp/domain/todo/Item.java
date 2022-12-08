package com.example.fullstackapp.domain.todo;

// lombok
import jdk.jfr.BooleanFlag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;

// JPA
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

// Bean validation
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Length(max = 128, min = 1)
    private String title;

    @Length(max = 1000, min = 1)
    private String content;

    @BooleanFlag
    private boolean completed;

    @NotNull
    private ZonedDateTime creationDate;

    private ZonedDateTime updateDate;

    @Builder
    private Item(String title, String content, ZonedDateTime currentTime) {
        this.title = title;
        this.content = content;
        this.completed = false;
        this.creationDate = currentTime;
    }

}
