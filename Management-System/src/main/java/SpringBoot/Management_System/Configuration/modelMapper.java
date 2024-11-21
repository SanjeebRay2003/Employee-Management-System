package SpringBoot.Management_System.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class modelMapper {
    @Bean
    ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
