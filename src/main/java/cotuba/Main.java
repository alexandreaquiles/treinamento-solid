package cotuba;

import cotuba.cli.CLI;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
class CotubaConfig {

}

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CotubaConfig.class);
        CLI cli = applicationContext.getBean(CLI.class);
        cli.executa(args);
    }

}
