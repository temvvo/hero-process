module heroprocess.usecase {
	requires heroprocess.domain;
	requires lombok;
	requires spring.context;
	requires spring.beans;
	exports com.heroprocess.usecase.port;
	exports com.heroprocess.usecase;

}
