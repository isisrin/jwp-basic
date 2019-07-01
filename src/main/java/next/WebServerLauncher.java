package next;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebServerLauncher {
    private static final Logger logger = LoggerFactory.getLogger(WebServerLauncher.class);

    public static void main(String[] args) throws Exception {
        String webappDirLocation = "webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        logger.info("configuring app with absedir: {}", new File(webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();

//        String contextPath = "/";
//        String webappDirLocation = "webapp/";
//        String baseDirectory = new File(webappDirLocation).getAbsolutePath();
//
//        Tomcat tomcat = new Tomcat();
//        tomcat.setPort(8080);
//        StandardContext context = (StandardContext) tomcat.addWebapp(contextPath, baseDirectory);
//
//        // Additions to make @WebServlet work
//        String buildPath = "target/classes";
//        String webAppMount = "/WEB-INF/classes";
//
//        File additionalWebInfClasses = new File(buildPath);
//        WebResourceRoot resources = new StandardRoot(context);
//        resources.addPreResources(new DirResourceSet(resources, webAppMount, additionalWebInfClasses.getAbsolutePath(), contextPath));
//        context.setResources(resources);
//        // End of additions
//
//        tomcat.start();
//        tomcat.getServer().await();

    }

}
