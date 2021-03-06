package com.drvc.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.drvc.cursomc.dao.domain.Address;
import com.drvc.cursomc.dao.domain.Category;
import com.drvc.cursomc.dao.domain.City;
import com.drvc.cursomc.dao.domain.Customer;
import com.drvc.cursomc.dao.domain.CustomerOrder;
import com.drvc.cursomc.dao.domain.OrderItem;
import com.drvc.cursomc.dao.domain.Payment;
import com.drvc.cursomc.dao.domain.PaymentBill;
import com.drvc.cursomc.dao.domain.PaymentCard;
import com.drvc.cursomc.dao.domain.Product;
import com.drvc.cursomc.dao.domain.State;
import com.drvc.cursomc.dao.domain.enums.CustomerType;
import com.drvc.cursomc.dao.domain.enums.PaymentState;
import com.drvc.cursomc.dao.repositories.AddressRepository;
import com.drvc.cursomc.dao.repositories.CategoryRepository;
import com.drvc.cursomc.dao.repositories.CityRepository;
import com.drvc.cursomc.dao.repositories.CustomerRepository;
import com.drvc.cursomc.dao.repositories.OrderItemRepository;
import com.drvc.cursomc.dao.repositories.OrderRepository;
import com.drvc.cursomc.dao.repositories.PaymentRepository;
import com.drvc.cursomc.dao.repositories.ProductRepository;
import com.drvc.cursomc.dao.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
	
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		State st1 = new State(null, "Minas Gerais");
		State st2 = new State(null, "São Paulo");
		
		City c1 = new City(null, "Uberlândia", st1);
		City c2 = new City(null, "São Paulo", st2);
		City c3 = new City(null, "Campinas", st2);
		
		st1.getCities().addAll(Arrays.asList(c1));
		st2.getCities().addAll(Arrays.asList(c2,c3));
		
		stateRepository.saveAll(Arrays.asList(st1,st2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Customer cus1 = new Customer(null, "maria Silva", "maria@gmail.com", "36378912377", CustomerType.PERSON);
		cus1.getTelephones().addAll(Arrays.asList("2734787788", "954878446"));
		
		Address a1 = new Address(null, "Rua Flores", "300", "Ap. 303", "Jardim Florido", "08977000", cus1, c1);
		Address a2 = new Address(null, "Avenida Mattos", "105", "Sala 801", "Centro", "08000200", cus1, c2);
		
		cus1.getAddresses().addAll(Arrays.asList(a1, a2));
		customerRepository.save(cus1);
		addressRepository.saveAll(Arrays.asList(a1, a2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		CustomerOrder order1 = new CustomerOrder(null, sdf.parse("30/09/2017 10:32"), cus1, a1);
		CustomerOrder order2 = new CustomerOrder(null, sdf.parse("10/10/2017 19:35"), cus1, a2);
		
		Payment pay1 = new PaymentCard(null, PaymentState.DONE, order1, 6);
		order1.setPayment(pay1);
		
		Payment pay2 = new PaymentBill(null, PaymentState.PENDING, order2, sdf.parse("20/10/2017 00:00"), null);
		order2.setPayment(pay2);
		
		cus1.getOrders().addAll(Arrays.asList(order1, order2));
				
		orderRepository.saveAll(Arrays.asList(order1, order2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));
		
		OrderItem ip1 = new OrderItem(order1, p1, 0.00, 1, 2000.00);
		OrderItem ip2 = new OrderItem(order1, p3, 0.00, 2, 80.00);
		OrderItem ip3 = new OrderItem(order2, p2, 100.00, 1, 800.00);
		
		order1.getItens().addAll(Arrays.asList(ip1, ip2));
		order2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		orderItemRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
	}
}
