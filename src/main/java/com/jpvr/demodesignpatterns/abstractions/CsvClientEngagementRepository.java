package com.jpvr.demodesignpatterns.abstractions;

import java.util.ArrayList;
import java.util.List;

public class CsvClientEngagementRepository implements ClientEngagementRepository {

    private List<ClientEngagement> engagements = new ArrayList<>();

    @Override
    public void add(ClientEngagement engagement) throws RepositoryException {

    }

    @Override
    public void remove(ClientEngagement engagement) throws RepositoryException {

    }

    @Override
    public Iterable<ClientEngagement> find(Query query) throws RepositoryException {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
} // end class CsvClientEngagementRepository
