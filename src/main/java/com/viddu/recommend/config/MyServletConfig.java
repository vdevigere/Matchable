package com.viddu.recommend.config;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;


public class MyServletConfig extends GuiceServletContextListener{

	@Override
	protected Injector getInjector() {
	    return Guice.createInjector(new JerseyModule());
	}
}
