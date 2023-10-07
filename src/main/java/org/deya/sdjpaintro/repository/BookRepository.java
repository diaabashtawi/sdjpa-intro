package org.deya.sdjpaintro.repository;

import org.deya.sdjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	

}
