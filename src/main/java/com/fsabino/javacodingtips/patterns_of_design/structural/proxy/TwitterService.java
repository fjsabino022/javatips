package com.fsabino.javacodingtips.patterns_of_design.structural.proxy;

public interface TwitterService {
	String getTimeline(String screenName);
	void postToTimeline(String screenName, String message);
}
