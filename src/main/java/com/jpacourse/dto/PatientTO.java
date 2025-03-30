package com.jpacourse.dto;

import java.io.Serializable;
import java.util.Collection;

public class PatientTO implements Serializable {
    private Collection<VisitTO> visits;

    private boolean isPrivateVisit;

    public Collection<VisitTO> getVisits() {
        return visits;
    }

    public void setVisits(Collection<VisitTO> visits) {
        this.visits = visits;
    }

    public boolean getIsPrivateVisit() {
        return isPrivateVisit;
    }

    public void setIsPrivateVisit(boolean isPrivateVisit) {
        this.isPrivateVisit = isPrivateVisit;
    }
}
