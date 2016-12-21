package com.wanpeng.poc;

import com.sun.istack.internal.NotNull;
import com.wanpeng.poc.process.BashInvoker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.IOException;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class ProcessMonitoringApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ProcessMonitoringApplication.class, args);

		BashInvoker bashInvoker = new BashInvoker();
		bashInvoker.monitorProcess();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
