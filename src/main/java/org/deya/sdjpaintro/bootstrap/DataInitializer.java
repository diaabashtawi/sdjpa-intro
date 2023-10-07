package org.deya.sdjpaintro.bootstrap;

import org.deya.sdjpaintro.domain.Book;
import org.deya.sdjpaintro.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;

public class DataInitializer implements CommandLineRunner{
	
	private final BookRepository bookRepository;
	
	

	public DataInitializer(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book(
				"Domain Driven Design",
				"123",
				"RandomHouse"
				);
		
		System.out.println("Id : " + book1.getId());
		
		Book saveBook1 = bookRepository.save(book1);
		
		System.out.println("Id : " + saveBook1.getId());
		Book book2 = new Book(
				"Spring Data JPA",
				"435",
				"Oriely"
				);
		Book saveBook2 = bookRepository.save(book2);
		
		bookRepository.findAll().forEach(book -> {
			System.out.println("Book Id : " + book.getId());
			System.out.println("Book Id : " + book.getTitle());
		});
		
		
	}
	
	

}
