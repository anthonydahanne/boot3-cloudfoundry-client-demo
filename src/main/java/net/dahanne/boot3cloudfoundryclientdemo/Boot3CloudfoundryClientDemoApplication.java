package net.dahanne.boot3cloudfoundryclientdemo;

import jakarta.annotation.PostConstruct;
import org.cloudfoundry.client.CloudFoundryClient;
import org.cloudfoundry.doppler.DopplerClient;
import org.cloudfoundry.operations.CloudFoundryOperations;
import org.cloudfoundry.operations.DefaultCloudFoundryOperations;
import org.cloudfoundry.reactor.ConnectionContext;
import org.cloudfoundry.reactor.DefaultConnectionContext;
import org.cloudfoundry.reactor.TokenProvider;
import org.cloudfoundry.reactor.client.ReactorCloudFoundryClient;
import org.cloudfoundry.reactor.tokenprovider.PasswordGrantTokenProvider;
import org.cloudfoundry.reactor.uaa.ReactorUaaClient;
import org.cloudfoundry.reactor.doppler.ReactorDopplerClient;
import org.cloudfoundry.uaa.UaaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class Boot3CloudfoundryClientDemoApplication {
	private static final Logger LOG
			= LoggerFactory.getLogger(Boot3CloudfoundryClientDemoApplication.class);

	private final Environment environment;

	public Boot3CloudfoundryClientDemoApplication(Environment environment) {
		this.environment = environment;
	}

	public static void main(String[] args) {
		SpringApplication.run(Boot3CloudfoundryClientDemoApplication.class, args);
	}

	@PostConstruct
	public void init() {
		LOG.info(String.valueOf(Arrays.asList(environment.getDefaultProfiles())));
	}

	@Bean
	ConnectionContext connectionContext(@Value("${cf.apiHost}") String apiHost) {
		return DefaultConnectionContext.builder()
				.apiHost(apiHost)
				.build();
	}

	@Bean
	TokenProvider tokenProvider(@Value("${cf.username}") String username,
								@Value("${cf.password}") String password) {
		return PasswordGrantTokenProvider.builder()
				.password(password)
				.username(username)
				.build();
	}

	@Bean
	CloudFoundryClient cloudFoundryClient(ConnectionContext connectionContext, TokenProvider tokenProvider) {
		return ReactorCloudFoundryClient.builder()
				.connectionContext(connectionContext)
				.tokenProvider(tokenProvider)
				.build();
	}

	@Bean
	DopplerClient dopplerClient(ConnectionContext connectionContext, TokenProvider tokenProvider) {
		return ReactorDopplerClient.builder()
				.connectionContext(connectionContext)
				.tokenProvider(tokenProvider)
				.build();
	}

	@Bean
	UaaClient uaaClient(ConnectionContext connectionContext, TokenProvider tokenProvider) {
		return ReactorUaaClient.builder()
				.connectionContext(connectionContext)
				.tokenProvider(tokenProvider)
				.build();
	}

	@Bean
	CloudFoundryOperations cloudFoundryOperations(CloudFoundryClient cloudFoundryClient,
														 DopplerClient dopplerClient,
														 UaaClient uaaClient,
														 @Value("${cf.organization}") String organization,
														 @Value("${cf.space}") String space) {
		return DefaultCloudFoundryOperations.builder()
				.cloudFoundryClient(cloudFoundryClient)
				.dopplerClient(dopplerClient)
				.uaaClient(uaaClient)
				.organization(organization)
				.space(space)
				.build();
	}

}
