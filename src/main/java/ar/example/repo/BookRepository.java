package ar.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import ar.example.domain.Book;

@RestResource(rel = "books", path = "books")
public interface BookRepository extends JpaRepository<Book, Long> {

	@RestResource(path = "textbook")
	List<Book> findByTextBookFlagIsTrue();

	@RestResource(path = "title")
	List<Book> findByTitle(@Param("title") String title);
}