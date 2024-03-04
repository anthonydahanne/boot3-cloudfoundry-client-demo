package net.dahanne.boot3cloudfoundryclientdemo;

import jakarta.annotation.PostConstruct;
import org.cloudfoundry.operations.CloudFoundryOperations;
import org.cloudfoundry.operations.organizations.OrganizationSummary;
import org.springframework.stereotype.Service;

@Service
public class Boot3LovesCloudFoundry {


	private final CloudFoundryOperations cloudFoundryOperations;

	public Boot3LovesCloudFoundry(CloudFoundryOperations cloudFoundryOperations) {
		this.cloudFoundryOperations=cloudFoundryOperations;
	}

	@PostConstruct
	public void init() {
		String orgs = cloudFoundryOperations.organizations()
				.list()
				.map(OrganizationSummary::getName)
				.blockFirst();

		System.out.println(orgs);
	}

}
