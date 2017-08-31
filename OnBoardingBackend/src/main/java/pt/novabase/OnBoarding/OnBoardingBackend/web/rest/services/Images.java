package pt.novabase.OnBoarding.OnBoardingBackend.web.rest.services;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

import pt.novabase.OnBoarding.OnBoardingBackend.business.Image;
import pt.novabase.OnBoarding.OnBoardingBackend.web.response.ServiceResult;
import pt.novabase.OnBoarding.OnBoardingBackend.web.rest.beans.ImagesBean;


@Api(value="/images")
@Path("/images")
public class Images {

	private static final Logger LOGGER = LoggerFactory.getLogger(Images.class);
			
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Saves an image associated with a process", notes="Saves an image associated with a process")
	public Response saveImages(ImagesBean image) {
		try {

			LOGGER.info("[REST] Log audit request arrived. Saving image for process: " + image.getProcessId());

			ServiceResult result = new ServiceResult(Image.createProcess(image));
			
			return Response.status(Response.Status.OK).entity(result).build();

		} catch (Throwable t) {
			LOGGER.error("[REST] Failed to process saveImages request.", t);
			ServiceResult result = ServiceResult.error(t);
			return Response.status(result.getWebStatus()).entity(result).build();
		}

	}
	
	@GET
	@Path("/get/{imageId}")
	@ApiOperation(value="Gets the image by imageId as a PNGimage", notes="Gets the image by imageId as a PNGimage")
	public Response getImage(@ApiParam(value="imageId", required=true) @PathParam("imageId") long imageId) {
		try {
			
			LOGGER.info("[REST] Getting images for the process: " + imageId);
			
			BufferedImage image = Image.getImage(imageId);

			ServiceResult result = new ServiceResult(image);
			return Response.status(Response.Status.OK).entity(result).build();

		} catch (Throwable t) {
			LOGGER.error("[REST] Failed to process getImages request.", t);
			ServiceResult result = ServiceResult.error(t);
			return Response.status(result.getWebStatus()).entity(result).build();
		}
	}
	
	@GET
	@Path("/find/{processId}")
	@ApiOperation(value="Gets the images associated to an determined process", notes="Gets the images associated to an determined process")
	public Response getJourneyImages(@ApiParam(value="processId", required=true) @PathParam("processId") long processId) {
		try {
			
			LOGGER.info("[REST] Getting images for the process: " + processId);

			List<ImagesBean> images = Image.getImagesByProcess(processId);
			
			ServiceResult result = new ServiceResult(images);
			return Response.status(Response.Status.OK).entity(result).build();

		} catch (Throwable t) {
			LOGGER.error("[REST] Failed to process getJourneyImages request.", t);
			ServiceResult result = ServiceResult.error(t);
			return Response.status(result.getWebStatus()).entity(result).build();
		}
	}
	
	@DELETE
	@Path("/delete/{imageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Deletes a image", notes="Deletes a image.")
	public Response deleteImage(@ApiParam(value="imageId", required=true) @PathParam("imageId") long imageId) {
		try {
			LOGGER.info("[REST] Deleting image: " + imageId);
			
			ServiceResult result = new ServiceResult(null);
			return Response.status(Response.Status.OK).entity(result).build();
			
		} catch (Throwable t) {
			LOGGER.error("[REST] Failed to process deleteImage request.", t);
			ServiceResult result = ServiceResult.error(t);
			return Response.status(result.getWebStatus()).entity(result).build();
		}
	}
}
