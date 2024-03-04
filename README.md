# boot3-cloudfoundry-client-demo

Add your own `application-local.properties` and run:

```
 ./gradlew bootRun --args='--spring.profiles.active=local'
```

You'll see an output similar to:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.3)

2024-03-04T16:14:39.857-05:00  INFO 17247 --- [           main] b.Boot3CloudfoundryClientDemoApplication : Starting Boot3CloudfoundryClientDemoApplication using Java 21.0.1 with PID 17247 (/Users/anthonyd2/workspaces/anthonydahanne/boot3-cloudfoundry-client-demo/build/classes/java/main started by anthonyd2 in /Users/anthonyd2/workspaces/anthonydahanne/boot3-cloudfoundry-client-demo)
2024-03-04T16:14:39.858-05:00  INFO 17247 --- [           main] b.Boot3CloudfoundryClientDemoApplication : The following 1 profile is active: "local"
2024-03-04T16:14:40.391-05:00  INFO 17247 --- [           main] b.Boot3CloudfoundryClientDemoApplication : [default]
2024-03-04T16:14:40.565-05:00 ERROR 17247 --- [           main] i.n.r.d.DnsServerAddressStreamProviders  : Unable to load io.netty.resolver.dns.macos.MacOSDnsServerAddressStreamProvider, fallback to system defaults. This may result in incorrect DNS resolutions on MacOS. Check whether you have a dependency on 'io.netty:netty-resolver-dns-native-macos'. Use DEBUG level to see the full stack: java.lang.UnsatisfiedLinkError: failed to load the required native library
anthony_dahanne_gmail_com
2024-03-04T16:14:44.150-05:00  INFO 17247 --- [ry-client-nio-2] cloudfoundry-client.compatibility        : Client supports API version 2.186.0 and is connected to server with API version 2.218.0. Things may not work as expected.
2024-03-04T16:14:44.276-05:00  INFO 17247 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint(s) beneath base path '/actuator'
2024-03-04T16:14:44.382-05:00  INFO 17247 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080
2024-03-04T16:14:44.389-05:00  INFO 17247 --- [           main] b.Boot3CloudfoundryClientDemoApplication : Started Boot3CloudfoundryClientDemoApplication in 4.724 seconds (process running for 4.954)

```