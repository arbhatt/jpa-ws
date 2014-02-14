package ar.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

import ar.example.domain.Book;
import ar.example.domain.Topic;

@RestResource(rel = "topics", path = "topics")
public interface TopicRepository extends JpaRepository<Topic, Long> {

	List<Topic> findByBook(Book book);

}
