package com.curso.config;


import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.entities.Category;
import com.curso.entities.Order;
import com.curso.entities.User;
import com.curso.entities.enums.OrderStatus;
import com.curso.repositories.CategoryRepository;
import com.curso.repositories.OrderRepository;
import com.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com","989888898","12345");
		User u2 = new User(null, "Alex Greem", "alex@gmail.com","9877777777","12345");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T16:53:07Z"), OrderStatus.PAD, u1);
		Order o2 = new Order(null, Instant.parse("2019-06-20T16:53:07Z"), OrderStatus.WAITTING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-06-20T16:53:07Z"), OrderStatus.WAITTING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
