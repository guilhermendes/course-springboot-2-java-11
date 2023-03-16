package com.curso.config;


import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.entities.Category;
import com.curso.entities.Order;
import com.curso.entities.Product;
import com.curso.entities.User;
import com.curso.entities.enums.OrderStatus;
import com.curso.repositories.CategoryRepository;
import com.curso.repositories.OrderRepository;
import com.curso.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "O poder do hábito","Charles Duhigg, mostra como os hábitos funcionam", 90.00, "");
		Product p2 = new Product(null, "Macbook Pro","Apple notebook MacBook Air (de 13 polegadas, Processador M1 da Apple", 1490.00, "");
		Product p3 = new Product(null, "Câmera Babá Eletrônica","Sensor: 1/4CMOS Sensor A iluminação minima: 0.5Lux@550nm", 200.00, "");
		Product p4 = new Product(null, "Smartwatch Xiaomi","Smartwatch Mibro C2, Novo Modelo 2022 Lançamento, Versão Global", 300.00, "");
		Product p5 = new Product(null, "O poder da disciplina, do foco e dos minihábitos","Você só vai vencer quando estiver 100% presente. Ao longo de uma rotina estressante e desmotivadora", 27.00, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat1);
		p4.getCategories().add(cat1);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com","989888898","12345");
		User u2 = new User(null, "Alex Greem", "alex@gmail.com","9877777777","12345");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T16:53:07Z"), OrderStatus.PAD, u1);
		Order o2 = new Order(null, Instant.parse("2019-06-20T16:53:07Z"), OrderStatus.WAITTING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-06-20T16:53:07Z"), OrderStatus.WAITTING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}