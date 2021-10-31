package com.api.gel.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.api.gel.entities.Category;
import com.api.gel.entities.Order;
import com.api.gel.entities.User;
import com.api.gel.entities.enums.OrderStatus;
import com.api.gel.repositories.CategoryRepository;
import com.api.gel.repositories.OrderRepository;
import com.api.gel.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner  {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public void run(String... args) throws Exception {
		
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		
		User u1 = new User(null, "Joao", "jaoa@gmail.com", "99775566", null, null);
		User u2 = new User(null, "Pedro", "pedro@gmail.com", "99775566", null, null);
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1); 
		
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}

}
