FROM maven:3.6.3-jdk-8 as builder
WORKDIR /build
COPY pom.xml .

COPY src/ /build/src/
RUN mvn install


FROM openjdk:8-jre

COPY --from=builder /build/target/calculator-1.0-SNAPSHOT.jar .

CMD java -cp calculator-1.0-SNAPSHOT.jar com.calculator.Calculator
