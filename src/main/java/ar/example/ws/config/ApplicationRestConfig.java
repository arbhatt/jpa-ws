package ar.example.ws.config;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.repository.context.AnnotatedHandlerRepositoryEventListener;
import org.springframework.data.rest.webmvc.RepositoryRestMvcConfiguration;

@Configuration
@Import(RepositoryRestMvcConfiguration.class)
@XSlf4j
public class ApplicationRestConfig {

	// @Bean
	// public ResourceProcessor<Resource<Book>> addProcessor() {
	// return new ResourceProcessor<Resource<Book>>() {
	//
	// @Override
	// public Resource<Book> process(Resource<Book> book) {
	// book.add(new Link("http://localhost:8080/jpa-ws/authorbook",
	// "author.book"));
	// return book;
	// }
	// };
	// }

	// @Bean
	// public Validator addValidator() {
	// return new Validator() {
	//
	// @Override
	// public boolean supports(Class<?> clazz) {
	// log.info("Validating is supported");
	// return ClassUtils.isAssignable(clazz, Book.class);
	// }
	//
	// @Override
	// public void validate(Object target, Errors errors) {
	// log.info("Validating");
	// // Book book = (Book) target;
	// // log.info(book.toString());
	// // if (null == book.getTitle()) {
	// // errors.rejectValue("title", "Unspecified");
	// // }
	// //
	// // if
	// // ("bad word".equalsIgnoreCase(book.getTitle().toLowerCase()))
	// // {
	// // errors.rejectValue("title", "Bad Word");
	// // }
	// }
	//
	// };
	//
	// }

	@Bean
	public AnnotatedHandlerRepositoryEventListener handlerListener() {
		return new AnnotatedHandlerRepositoryEventListener("ar.example.ws.config");
	}
	//
	// @Bean
	// public ApplicationListener<AfterSaveEvent> afterSaveEventHandler() {
	// return new ApplicationListener<AfterSaveEvent>() {
	//
	// @Override
	// public void onApplicationEvent(AfterSaveEvent event) {
	// if (event.getSource() instanceof Book) {
	// log.info("Got a Book to process");
	// }
	//
	// }
	// };
	// }

}
