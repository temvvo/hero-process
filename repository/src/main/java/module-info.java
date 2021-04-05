module heroprocess.repository {
	requires heroprocess.domain;
	requires heroprocess.usecase;
	requires lombok;
	requires org.mapstruct;
	requires java.compiler;
	requires org.apache.logging.log4j;
	requires com.fasterxml.jackson.databind;
	requires  junit;
	//requires org.junit.jupiter.api;
	requires spring.context;
	requires spring.beans;
	requires spring.data.commons;
	requires java.persistence;
	exports com.heroprocess.repository.port;
}
