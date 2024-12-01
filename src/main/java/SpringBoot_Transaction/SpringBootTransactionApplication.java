package SpringBoot_Transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class SpringBootTransactionApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTransactionApplication.class, args);
	}

}
