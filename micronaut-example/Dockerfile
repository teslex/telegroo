FROM oracle/graalvm-ce:19.0.0 as graalvm
COPY . /home/app/micronaut-example
WORKDIR /home/app/micronaut-example
RUN gu install native-image
RUN native-image --no-server -cp build/libs/micronaut-example-*.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-example .
ENTRYPOINT ["./micronaut-example"]
