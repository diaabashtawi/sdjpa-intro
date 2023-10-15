package org.deya.sdjpaintro;


import org.deya.sdjpaintro.domain.Book;
import org.deya.sdjpaintro.repository.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(
        MethodOrderer.OrderAnnotation.class
)
@DataJpaTest
public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    @Rollback(value = false)
    @Order(1)
    @Test
    public void testJpaTestSlice() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(0);
        bookRepository.save(
                new Book(
                        "My Book",
                        "123456789",
                        "Deya Bakheet"
                ));
        long countAfter = bookRepository.count();
        assertThat(countBefore).isLessThan(countAfter);

    }

    @Order(2)
    @Test
    public void testJpaTestSliceTransaction(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(1);
    }

}
