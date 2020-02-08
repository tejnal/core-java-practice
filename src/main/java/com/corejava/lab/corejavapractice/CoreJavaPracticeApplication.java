package com.corejava.lab.corejavapractice;

import com.corejava.lab.corejavapractice.topics.lambds.utils.modals.Bingo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CoreJavaPracticeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CoreJavaPracticeApplication.class, args);

		Bingo newBingo = (Bingo) ctx.getBean("bingo");
		System.out.println(newBingo);
	}

}
