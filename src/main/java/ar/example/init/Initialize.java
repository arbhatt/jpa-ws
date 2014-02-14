package ar.example.init;

import java.util.List;

import javax.annotation.PostConstruct;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.XSlf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.example.domain.Book;
import ar.example.domain.Topic;
import ar.example.repo.BookRepository;
import ar.example.repo.TopicRepository;

@Component
@Setter
@Getter
@XSlf4j
public class Initialize {

	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private TopicRepository topicRepo;

	@PostConstruct
	public void initialize() {

		Book b1 = new Book();
		b1.setIsbn("ASDF");
		b1.setLanguage("English");
		b1.setTitle("Immortals of Meluha");
		b1.setTextBookFlag(Boolean.FALSE);
		b1 = bookRepo.saveAndFlush(b1);
		log.info(b1.toString());

		Book b2 = new Book();
		b2.setIsbn("ASDF");
		b2.setLanguage("Bangla");
		b2.setTitle("Geetobitan");
		b2.setTextBookFlag(Boolean.TRUE);
		b2 = bookRepo.saveAndFlush(b2);
		log.info(b2.toString());

		Book b3 = new Book();
		b3.setIsbn("ASDF");
		b3.setLanguage("Bangla");
		b3.setTitle("Aro Kichu");
		b3.setTextBookFlag(Boolean.FALSE);
		b3 = bookRepo.saveAndFlush(b3);
		log.info(b3.toString());

		log.info("=========DONE WITH BOOK========++++DONE WITH BOOK+++++=========DONE WITH BOOK========");
		Topic t1 = new Topic();
		t1.setName("Introduction");
		t1.setBook(b1);
		t1 = topicRepo.saveAndFlush(t1);
		log.info(t1.toString());

		t1 = new Topic();
		t1.setName("Preface");
		t1.setBook(b1);
		t1 = topicRepo.saveAndFlush(t1);
		log.info(t1.toString());

		t1 = new Topic();
		t1.setName("TOC");
		t1.setBook(b1);
		t1 = topicRepo.saveAndFlush(t1);
		log.info(t1.toString());

		t1 = new Topic();
		t1.setName("Summary");
		t1.setBook(b1);
		t1 = topicRepo.saveAndFlush(t1);
		log.info(t1.toString());

		log.info("************** About to Query ************");
		List<Book> bL = bookRepo.findByTitle("Immortals of Meluha");
		List<Topic> t = topicRepo.findByBook(bL.get(0));
		for (Topic tt : t) {
			log.info("Topic Query = " + tt.toString());
		}

		log.info("++++++++++++++++++++++=====DONE WITH TOPIC======++++++++++++++++++++++++++++++++++++");

	}
}
