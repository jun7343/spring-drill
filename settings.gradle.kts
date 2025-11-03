plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "spring-drill"
include("spring-cloud-gateway")
include("spring-cloud-gateway:example-service")
include("spring-cloud-gateway:example-service:a-service")
include("spring-cloud-gateway:example-service:b-service")
include("spring-cloud-gateway:example-service:c-service")
include("spring-cloud-gateway:gateway-webmvc")
include("spring-cloud-gateway:gateway-webflux")
include("spring-cloud-gateway:gateway-config")
include("spring-async")
include("spring-cache")