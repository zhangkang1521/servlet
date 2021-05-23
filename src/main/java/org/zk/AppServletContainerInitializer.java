package org.zk;

import org.zk.controller.DemoServlet;
import org.zk.listener.DemoListener;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

/**
 * 代理web.xml配置
 */
public class AppServletContainerInitializer implements ServletContainerInitializer {

	public void onStartup(Set<Class<?>> arg0, ServletContext sc) throws ServletException {

		// @HandlesTypes(WebApplicationInitializer.class)
//		for (Class<?> claz : arg0) {
//			System.out.println(claz);
//		}

		ServletRegistration.Dynamic servlet = sc.addServlet("userServlet", new DemoServlet());
		servlet.addMapping("/user");


		//注册Listener
		sc.addListener(DemoListener.class);

		//注册Filter  FilterRegistration
		// FilterRegistration.Dynamic filter = sc.addFilter("userFilter", UserFilter.class);
		// filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
	}
}
