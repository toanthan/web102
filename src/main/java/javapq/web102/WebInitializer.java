package javapq.web102;

import javapq.web102.config.SpringConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(final ServletContext sc) {

        AnnotationConfigWebApplicationContext root =
                new AnnotationConfigWebApplicationContext();
        root.register(SpringConfig.class);
        root.refresh();

        ServletRegistration.Dynamic appServlet =
                sc.addServlet("mvc", new DispatcherServlet(root));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/mvc/*");
    }
}