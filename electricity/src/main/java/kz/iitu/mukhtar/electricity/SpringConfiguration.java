package kz.iitu.mukhtar.electricity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("kz.iitu.mukhtar.electricity")
@PropertySource("application.properties")
public class SpringConfiguration {

}
