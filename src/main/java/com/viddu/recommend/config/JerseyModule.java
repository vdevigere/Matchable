package com.viddu.recommend.config;
import java.util.HashMap;
import java.util.Map;

import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.viddu.recommend.bo.Matchable;
import com.viddu.recommend.bo.Tag;
import com.viddu.recommend.persister.InMemoryMatchableItemPersister;
import com.viddu.recommend.persister.MatchableItemPersiser;
import com.viddu.recommend.persister.RedisConfig;
import com.viddu.recommend.persister.RedisPersister;
import com.viddu.recommend.resource.MatchableResource;


public class JerseyModule extends ServletModule{

	@Override
	protected void configureServlets() {
		//TODO: Add bindings here...
		
		bind(MatchableResource.class);
		
		
//		bind(MatchableItemPersiser.class).to(InMemoryMatchableItemPersister.class);
		bind(MatchableItemPersiser.class).to(RedisPersister.class);
		bind(RedisConfig.class).toInstance(new RedisConfig("localhost", 6379));
		serve("/*").with(GuiceContainer.class);
	}
	
	@Provides
	public Map<Long, Matchable> dummyMapProvider(){
		// Setup some dummy items..
		Map<Long, Matchable> matchableItemMap = new HashMap<Long, Matchable>();
		Matchable dummyItem = new Matchable(1L, "Dummy");
		dummyItem.addDescriptionTag("dummy");
		dummyItem.addDescriptionTag("dodo");

		dummyItem.addRecommendationTag("viddu");
		matchableItemMap.put(dummyItem.getId(), dummyItem);
		return matchableItemMap;
	}
	
	
}
