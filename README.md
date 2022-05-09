spring-boot tracing example
===========================


Requirements (verify all of these are installed and working):
-------------
docker
kind (k8s in docker)
Java JDK
Apache maven
helm
kubectl


1. Run the three spring-boot services -- `mvn spring-boot:run` in /tracing, /greetingservice, /nameservice
2. Run jaeger all-in-one:
```
docker run -d --name jaeger-collector \
  -e COLLECTOR_ZIPKIN_HOST_PORT=:9411 \
  -p 5775:5775/udp \
  -p 6831:6831/udp \
  -p 6832:6832/udp \
  -p 5778:5778 \
  -p 16686:16686 \
  -p 14250:14250 \
  -p 14268:14268 \
  -p 14269:14269 \
  -p 9411:9411 \
  jaegertracing/all-in-one:1.33
```



mvn spring-boot:build-image -Dspring-boot.build-image.imageName=brentos/greetingservice
