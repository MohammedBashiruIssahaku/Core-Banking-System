package Bashiru.com.Core.Banking.System;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreBankingSystemApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(CoreBankingSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CoreBankingSystemApplication.class, args);
		LOGGER.info("Core Banking started..");
	}

}
