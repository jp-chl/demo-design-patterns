package com.jpvr.demodesignpatterns.abstractions;

public interface ClientEngagementRepository extends AutoCloseable {

    int NO_ID = 0;

    void add(ClientEngagement engagement) throws RepositoryException;

    void remove(ClientEngagement engagement) throws RepositoryException;

//    Iterable<ClientEngagement> findEngagementByClient(final String client);
//    Iterable<ClientEngagement> findEngagementWithAtLeastHoursWorked(final int hoursWorked);
    Iterable<ClientEngagement> find(Query query) throws RepositoryException;
} // end interface ClientEngagementRepository
