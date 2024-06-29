plugins {
	java
	id("org.springframework.boot") version "3.2.7"
	id("io.spring.dependency-management") version "1.1.5"
//	id("io.swagger.core.v3.swagger-gradle-plugin") version "2.2.22"

}

group = "com.assignment"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven {
		url = uri("https://repo.spring.io/release")
	}
	maven {
		url = uri("https://repository.jboss.org/maven2")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
//	implementation ("mysql:mysql-connector-java:8.0.33")
	runtimeOnly("com.mysql:mysql-connector-j")
//	runtimeOnly ("com.h2database:h2")
//	implementation( "io.springfox:springfox-boot-starter:3.0.0")

//	implementation("org.webjars:swagger-ui:5.17.14")

	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.5.0")
//	implementation("org.springdoc:springdoc-openapi-starter-webmvc-common:2.5.0")


}

tasks.withType<Test> {
	useJUnitPlatform()
}

