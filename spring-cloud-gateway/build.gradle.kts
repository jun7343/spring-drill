import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

subprojects {
    tasks.named<BootBuildImage>("bootBuildImage") {
        imageName.set("${project.name}:latest")
    }
}

tasks.register("gatewayWebmvcBuildImage") {
    group = "gateway-webmvc"

    dependsOn(
        ":gateway-config:bootBuildImage",
        ":gateway-webmvc:bootBuildImage",
        ":example-service:a-service:bootBuildImage",
        ":example-service:b-service:bootBuildImage",
        ":example-service:c-service:bootBuildImage"
    )
}

tasks.register("gatewayWebfluxBuildImage") {
    group = "gateway-webmvc"

    dependsOn(
        ":gateway-config:bootBuildImage",
        ":gateway-webflux:bootBuildImage",
        ":example-service:a-service:bootBuildImage",
        ":example-service:b-service:bootBuildImage",
        ":example-service:c-service:bootBuildImage"
    )
}