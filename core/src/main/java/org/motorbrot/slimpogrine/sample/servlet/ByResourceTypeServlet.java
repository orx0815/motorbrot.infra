package org.motorbrot.slimpogrine.sample.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello World Servlet registered by resource type
 * 
 * <p>This servlet binds to the <tt>sling/servlet/default</tt> resource type,
 * which means that it is registered for all resources. The registration is
 * narrowed down by the selectors and extensions.</p>
 * 
 * <p>Assuming the sample content is installed, it will serve requests of the form
 * <tt>GET /${resource}.hello.html</tt></p>
 * 
 * @see <a href="https://sling.apache.org/documentation/the-sling-engine/servlets.html">Servlets and Scripts</a>
 */
@Component(
    service = Servlet.class,
    property = {
        Constants.SERVICE_DESCRIPTION + "=Hello World Path Servlet",
        Constants.SERVICE_VENDOR + "=The Apache Software Foundation",
        "sling.servlet.resourceTypes=sling/servlet/default",
        "sling.servlet.selectors=hello",
        "sling.servlet.extensions=html",
    }
)
@SuppressWarnings("serial")
public class ByResourceTypeServlet extends SlingSafeMethodsServlet {
    
    private final Logger log = LoggerFactory.getLogger(ByResourceTypeServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request,
            SlingHttpServletResponse response) throws ServletException,
            IOException {
        Resource resource = request.getResource();

        Writer w = response.getWriter();
        w.write("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">");
        w.write("<html>");
        w.write("<head>");
        w.write("<title>Hello World Servlet</title>");
        w.write("</head>");
        w.write("<body>");
        w.write("<h1>Hello ");
        w.write(resource.getPath());
        w.write("</h1>");
        w.write("</body>");
        w.write("</html>");
        
        log.info("Hello World Servlet");
        
    }

}

