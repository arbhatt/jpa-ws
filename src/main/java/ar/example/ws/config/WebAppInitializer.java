package ar.example.ws.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext context) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(ApplicationConfiguration.class);
		context.addListener(new ContextLoaderListener(rootContext));

		RepositoryRestExporterServlet exporter = new RepositoryRestExporterServlet();

		ServletRegistration.Dynamic reg = context.addServlet(getServletName(), exporter);
		reg.setLoadOnStartup(1);
		reg.addMapping("/*");

		// Filter[] filters = getServletFilters();
		// if (!ObjectUtils.isEmpty(filters)) {
		// for (Filter filter : filters) {
		// registerServletFilter(context, filter);
		// }
		// }
	}

	// protected Filter[] getServletFilters() {
	// return new Filter[] { new HiddenHttpMethodFilter(), new
	// MultipartFilter(), new OpenEntityManagerInViewFilter() };
	// }

	// protected FilterRegistration.Dynamic registerServletFilter(ServletContext
	// servletContext, Filter filter) {
	// String filterName = Conventions.getVariableName(filter);
	// Dynamic registration = servletContext.addFilter(filterName, filter);
	// registration.setAsyncSupported(isAsyncSupported());
	// registration.addMappingForServletNames(getDispatcherTypes(), false,
	// getServletName());
	// return registration;
	// }
	//
	private String getServletName() {
		return "exporter";
	}
	//
	// private EnumSet<DispatcherType> getDispatcherTypes() {
	// return isAsyncSupported() ? EnumSet.of(DispatcherType.REQUEST,
	// DispatcherType.FORWARD, DispatcherType.INCLUDE,
	// DispatcherType.ASYNC) : EnumSet.of(DispatcherType.REQUEST,
	// DispatcherType.FORWARD,
	// DispatcherType.INCLUDE);
	// }
	//
	// private boolean isAsyncSupported() {
	// return true;
	// }

}
