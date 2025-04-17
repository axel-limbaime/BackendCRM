package gp2.StudentLifeCycle.StudentLifecylce.config;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import lombok.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfig {

    private final String accountSid = "ACae52e57007ce3a1ae12a199ba2da630a";

    private final String authToken = "c3cd3114142613d865d9ebfc96df5e0b";

    @PostConstruct
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }
}