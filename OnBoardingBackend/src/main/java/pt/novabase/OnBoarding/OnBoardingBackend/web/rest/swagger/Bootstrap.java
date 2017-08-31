package pt.novabase.OnBoarding.OnBoardingBackend.web.rest.swagger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.wordnik.swagger.jaxrs.config.BeanConfig;

public class Bootstrap extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setContact("Novabase");
        beanConfig.setTitle("AberturaConta REST API");
        beanConfig.setDescription("provides all services available through rest api");
        beanConfig.setBasePath("/OnBoardingBackend/rest/v1");
        beanConfig.setScan(true);
        beanConfig.setResourcePackage("pt.novabase.OnBoarding.OnBoardingBackend.web.rest.services");
    }
}