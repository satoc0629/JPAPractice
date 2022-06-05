package jpalearn.config;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.time.LocalDateTime;

@SessionScope
@Component
@Data
public class UserSession implements Serializable {
    private LocalDateTime lastAccessTime = LocalDateTime.now();
}
