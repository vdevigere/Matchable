package com.viddu.recommend.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.viddu.recommend.bo.Matchable;
import com.viddu.recommend.persister.MatchableItemPersiser;

@Path("/api/match")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MatchableResource {

	private MatchableItemPersiser mPersister;

	@Inject
	public MatchableResource(MatchableItemPersiser mPersister) {
		this.mPersister = mPersister;
	}

	@GET
	@Path("{id}")
	public Matchable getMatchableItemById(@PathParam("id") Long id) {
		return mPersister.findById(id);
	}

	@POST
	public void saveMatchableItem(Matchable mItem) {
		mPersister.save(mItem);
	}

	@PUT
	public void editMatchableItem(Matchable mItem) {
		mPersister.replace(mItem);
	}

	@DELETE
	@Path("{id}")
	public void deleteMatchableItem(@PathParam("id") Long id) {
		mPersister.delete(id);
	}

	@POST
	@Path("{id}/descTag")
	public void addDesciptionTag(@PathParam("id") Long id, @QueryParam("tagName") String tagName) {
		mPersister.addDesciptionTag(id, tagName);
	}

	@DELETE
	@Path("{id}/descTag")
	public void removeDesciptionTag(@PathParam("id") Long id, @QueryParam("tagName") String tagName) {
		mPersister.removeDesciptionTag(id, tagName);
	}

	@POST
	@Path("{id}/recoTag")
	public void addRecommendationTag(@PathParam("id") Long id, @QueryParam("tagName") String tagName) {
		mPersister.addRecommendationTag(id, tagName);
	}

	@DELETE
	@Path("{id}/recoTag")
	public void removeRecommendationTag(@PathParam("id") Long id, @QueryParam("tagName") String tagName) {
		mPersister.removeRecommendationTag(id, tagName);
	}

}
