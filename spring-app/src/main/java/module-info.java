module heroprocess.spring {
	requires heroprocess.domain;
	requires heroprocess.usecase;
	requires heroprocess.repository;
	requires org.mapstruct.processor;

	requires org.mapstruct;
	requires spring.context;
	requires spring.beans;
	requires spring.boot.autoconfigure;
	requires spring.boot;

	requires lombok;
	requires spring.core;
	requires spring.web;
	requires spring.webmvc;
	requires org.apache.tomcat.embed.core;
	requires java.compiler;

	exports com.heroprocess.handler;
}
