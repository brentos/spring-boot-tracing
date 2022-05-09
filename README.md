spring-boot tracing example
===========================


Requirements (verify all of these are installed and working):
-------------
* docker
* kind (k8s in docker)
* Java JDK
* Apache maven
* helm
* kubectl

Run the install.sh script to create a local kind cluster, build the Java projects and docker images, install Kong ingress and Jaeger

```./install.sh```
