kind create cluster --name tracing --config=kind.yaml

(cd ./tracing && mvn spring-boot:build-image -Dspring-boot.build-image.imageName=brentos/tracing:0.0.1)
(cd ./nameservice && mvn spring-boot:build-image -Dspring-boot.build-image.imageName=brentos/nameservice:0.0.1)
(cd ./greetingservice && mvn spring-boot:build-image -Dspring-boot.build-image.imageName=brentos/greetingservice:0.0.1)

kind load docker-image brentos/tracing:0.0.1 brentos/nameservice:0.0.1 brentos/greetingservice:0.0.1 --name tracing

kubectl create deployment tracing --image=brentos/tracing:0.0.1
kubectl create deployment nameservice --image=brentos/nameservice:0.0.1
kubectl create deployment greetingservice --image=brentos/greetingservice:0.0.1

kubectl expose deployment/tracing --type="ClusterIP" --port 8080
kubectl expose deployment/nameservice --type="ClusterIP" --port 8080
kubectl expose deployment/greetingservice --type="ClusterIP" --port 8080

helm install kong kong/kong -f values.yaml --version 2.7.0 --set ingressController.installCRDs=false --atomic

kubectl apply -f jaeger.yaml
kubectl apply -f zipkin-plugin.yaml
kubectl apply -f jaeger-ingress.yaml
kubectl apply -f tracing-service-ingress.yaml
