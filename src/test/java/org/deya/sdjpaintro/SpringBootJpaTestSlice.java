package org.deya.sdjpaintro;


import org.deya.sdjpaintro.domain.Book;
import org.deya.sdjpaintro.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

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

}
