package ar.example.ws.config;

import org.springframework.data.rest.webmvc.RepositoryRestMvcConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class RepositoryRestExporterServlet extends DispatcherServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = -4038137398991451628L;

	public RepositoryRestExporterServlet() {
		configure();
	}

	private void configure() {
		setContextClass(AnnotationConfigWebApplicationContext.class);
		setContextConfigLocation(RepositoryRestMvcConfiguration.class.getName());

	}

	public RepositoryRestExporterServlet(WebApplicationContext webApplicationContext) {
		super(webApplicationContext);
		configure();
	}

}
