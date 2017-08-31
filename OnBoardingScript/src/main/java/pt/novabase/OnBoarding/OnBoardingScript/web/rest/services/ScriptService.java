package pt.novabase.OnBoarding.OnBoardingScript.web.rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import pt.novabase.OnBoarding.OnBoardingScript.business.Script;
import pt.novabase.OnBoarding.OnBoardingScript.web.response.ServiceResult;
import pt.novabase.OnBoarding.OnBoardingScript.web.rest.ScriptBean;


@Api(value="/script")
@Path("/script")
public class ScriptService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScriptService.class);

	@GET
	@Path("/{scriptCode}")
	@ApiOperation(value="Gets the operator script", notes="Gets the operator script")
	@Produces(MediaType.APPLICATION_JSON)
	public ScriptBean getScript(@ApiParam(value="scriptCode", required=true) @PathParam("scriptCode") String scriptCode) {
		try {

			LOGGER.info("[REST] Getting scripts of type: " + scriptCode);

			return Script.getTemplateScript(scriptCode);
			

		} catch (Throwable t) {
			LOGGER.error("[REST] Failed to process getScript request.", t);
			ServiceResult result = ServiceResult.error(t);
			return null;
		}
	}
	
	@GET
	@Path("/test/{scriptCode}")
	@ApiOperation(value="Gets the operator script", notes="Gets the operator script")
	@Produces(MediaType.APPLICATION_JSON)
	public Response testScript(@ApiParam(value="scriptCode", required=true) @PathParam("scriptCode") Integer scriptCode) {

		try {

			LOGGER.info("[REST] Getting scripts of type: " + scriptCode);

			ScriptBean result = Script.scriptTest(scriptCode);
			return null;

		} catch (Throwable t) {
			LOGGER.error("[REST] Failed to process getScript request.", t);
			return null;
		}

	}



}
