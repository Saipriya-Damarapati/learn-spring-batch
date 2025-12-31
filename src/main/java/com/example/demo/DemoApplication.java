package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public Step step1() {
		return new StepBuilder("step1")
			.tasklet((contribution, chunkContext) -> {
				System.out.println("Executing Step 1");
				return RepeatStatus.FINISHED;
			})
			.build();
	}

	@Bean
	public Step step2() {
		return new StepBuilder("step2")
			.tasklet((contribution, chunkContext) -> {
				System.out.println("Executing Step 2");
				return RepeatStatus.FINISHED;
			})
			.build();
	}

	@Bean
	public Job myJob() {
		return new JobBuilder("myJob")
			.start(step1())
			.next(step2())
			.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
