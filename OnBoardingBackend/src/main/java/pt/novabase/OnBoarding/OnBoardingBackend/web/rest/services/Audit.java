package pt.novabase.OnBoarding.OnBoardingBackend.web.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import pt.novabase.OnBoarding.OnBoardingBackend.web.response.ServiceResult;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.AuditBean;

@Api(value="/audit")
@Path("/audit")
public class Audit {
	private static final Logger LOGGER = LoggerFactory.getLogger(Audit.class);

	@POST
	@Path("/log")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Logs in the audit", notes="Logs in the audit")
	public Response logAudit(AuditBean audit) {
		try {

			LOGGER.info("[REST] Log audit request arrived. Logging process: " + audit.getProcessId());

			

			ServiceResult result = new ServiceResult(null);
			return Response.status(Response.Status.OK).entity(result).build();

		} catch (Throwable t) {
			LOGGER.error("[REST] Failed to process logAudit request.", t);
			ServiceResult result = ServiceResult.error(t);
			return Response.status(result.getWebStatus()).entity(result).build();
		}

	}
}
