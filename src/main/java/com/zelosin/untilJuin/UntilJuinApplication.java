package com.zelosin.untilJuin;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;

@SpringBootApplication
public class UntilJuinApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(UntilJuinApplication.class, args);


	}
}
