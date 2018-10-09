package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.sql.Time;
import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> inMemoryTimeEntryMap;

    private long id;

    public InMemoryTimeEntryRepository() {
        inMemoryTimeEntryMap = new HashMap<>();
        this.id = 0;
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(++id);
        inMemoryTimeEntryMap.put(timeEntry.getId(), timeEntry);
        return find(this.id);
    }

    @Override
    public TimeEntry find(long id) {
        TimeEntry timeEntry = isInMemoryEmpty() ? null : inMemoryTimeEntryMap.get(id);
        return timeEntry;
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> timeEntries = new ArrayList<>();
        for(Map.Entry<Long, TimeEntry> timeEntrySet : inMemoryTimeEntryMap.entrySet()) {
            timeEntries.add(timeEntrySet.getValue());
        }
        return timeEntries;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(isInMemoryEmpty()) {
            return null;
        }
        else {
            timeEntry.setId(id);
            inMemoryTimeEntryMap.put(id, timeEntry);
        }
        return find(this.id);
    }

    @Override
    public TimeEntry delete(long id) {
        return isInMemoryEmpty() ? null : inMemoryTimeEntryMap.remove(id);
    }

    private boolean isInMemoryEmpty() {
        return null == inMemoryTimeEntryMap || inMemoryTimeEntryMap.isEmpty();
    }
}