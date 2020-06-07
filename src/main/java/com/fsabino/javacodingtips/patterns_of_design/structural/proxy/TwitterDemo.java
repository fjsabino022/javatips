package com.fsabino.javacodingtips.patterns_of_design.structural.proxy;

public class TwitterDemo {

	public static void main(String[] args) {
		TwitterService service = (TwitterService) SecurityProxy.newInstance(new TwitterServiceStub());
		System.out.println(service.getTimeline("primer cosa mandada"));
		service.postToTimeline("primer cosa mandada", "Es el mensaje que yo elegi");
	}

}
