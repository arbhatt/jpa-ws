package ar.example.ws.config;

import ar.example.domain.Book;

//@Component
//@RepositoryEventHandler(Book.class)
//@XSlf4j
public class AfterSaveHandler {

	// @HandleAfterSave
	public void afterSave(Book book) {
		// log.info("Book is saved " + book);
	}

}
