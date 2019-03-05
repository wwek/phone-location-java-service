# First stage: complete build environment
FROM maven:3.6.0-jdk-8-alpine AS builder
# workdir
WORKDIR /app
# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/
# package jar
RUN mvn clean package


# Second stage: minimal runtime environment
From openjdk:8-jre-alpine

# apk mirrors
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories
# install base lib
RUN apk update \
    && apk upgrade \
    && apk add bash \
    && apk add ca-certificates \
    && apk add wget \
    && apk add iputils \
    && apk add iproute2 \
    && apk add libc6-compat \
    && apk add -U tzdata \
    #&& apk add curl \
    #&& apk add tcpdump \
    #&& apk add nghttp2-dev \
    #&& apk add s6 \
    && rm -rf /var/cache/apk/*

# timezone
RUN rm -rf /etc/localtime \
 && ln -s /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

# workdir
WORKDIR /app
# copy jar from the first stage
COPY --from=builder /app/target/phonelocation-0.0.1-SNAPSHOT.jar phonelocation.jar

# port
EXPOSE 8080

# run jar
CMD ["java", "-jar", "phonelocation.jar"]