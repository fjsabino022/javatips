package com.fsabino.javacodingtips.patterns_of_design.structural.proxy;

public class TwitterServiceStub implements TwitterService {

	@Override
	public String getTimeline(String screenName) {
		return "metodo gettimeline";
	}

	@Override
	public void postToTimeline(String screenName, String message) {
		// TODO Auto-generated method stub

	}
}
