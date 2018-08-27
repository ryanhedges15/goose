import com.evie.Application
import org.springframework.boot.SpringApplication
import org.springframework.context.ApplicationContext

/**
 * Created by rmhedge on 4/22/16.
 */
class TestApplication {


    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Application.class, args);

    }
}
