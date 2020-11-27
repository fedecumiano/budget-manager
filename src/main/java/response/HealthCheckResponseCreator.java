package response;

import org.springframework.stereotype.Component;

@Component
public class HealthCheckResponseCreator {

    public String getResponse() {
        return "HEALTHY";
    }
}
