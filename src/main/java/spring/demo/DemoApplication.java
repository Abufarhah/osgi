package spring.demo;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.osgi.io.OsgiBundleResourcePatternResolver;

@Configuration
//@ComponentScan
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer
        implements BundleActivator
{

    ConfigurableApplicationContext appContext;

    @Override
    public void start(BundleContext bundleContext) {
        // Set context classloader
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        // trick to enable scan: get osgi resource pattern resolver
        OsgiBundleResourcePatternResolver resourceResolver = new OsgiBundleResourcePatternResolver(bundleContext.getBundle());
        // and prvide it to spring application
        appContext = new SpringApplication(resourceResolver, DemoApplication.class).run();
    }
//    public void start(BundleContext bundleContext) {
//        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
//        this.appContext = SpringApplication.run(DemoApplication.class, new String[0]);
//    }

    @Override
    public void stop(BundleContext bundleContext) {
        SpringApplication.exit(appContext, () -> 0);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class);
    }
    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }

}

