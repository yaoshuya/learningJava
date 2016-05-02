package SpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World! Spring FrameWork!";
            }
        };
    }

  public static void main(String[] args) {
    @SuppressWarnings("resource")
	ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
	MessagePrinter printer = context.getBean(MessagePrinter.class);
    printer.printMessage();     
  }
}
