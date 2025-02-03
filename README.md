# Spring Cloud Gateway issue

To see the issue in action run [
`GreetControllerTest`](src/test/java/com/att/training/gateway/example/GreetControllerTest.java)

Both tests should pass, but the second one fails.
The happy flow, `givenRequestWithNameParam_whenGet_thenOkWithGreeting`, completes successfully, while the error flow,
`givenRequestWithoutNameParam_whenGet_thenBadRequestWithOperationType`, fails since the operationType field in the
response
is `null` instead of "HELLO"

If you go to the pom and switch to Spring Boot 3.3.8 with Spring Cloud 2023.0.5, the test will pass.

You can also run the app and make a successful/failed request to see the issue in action.
Use the http client requests [here](http/hello.http)
