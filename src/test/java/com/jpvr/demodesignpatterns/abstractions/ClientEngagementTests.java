package com.jpvr.demodesignpatterns.abstractions;

public class ClientEngagementTests {

    public void testClientEngagements() {

        ClientEngagementRepository repository = null;

        final Iterable<ClientEngagement> engagements = repository.find(new Query()
                .atLeastHoursWorked(3)
                .client("JP"));
    } // end void testClientEngagements()
} // end class ClientEngagementTests
