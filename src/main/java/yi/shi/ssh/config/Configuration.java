package yi.shi.ssh.config;

import yi.shi.ssh.service.Service;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public ToolCallbackProvider toolCallbackProvider(Service service) {
        return MethodToolCallbackProvider.builder().toolObjects(service).build();
    }
}
