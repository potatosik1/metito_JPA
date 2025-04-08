package com.jpacourse.dto;

import java.io.Serializable;
import java.util.Collection;

public class PatientTO implements Serializable {
    private Collection<VisitTO> visits;

    private boolean isPrivateVisitor;

    public Collection<VisitTO> getVisits() {
        return visits;
    }

    public void setVisits(Collection<VisitTO> visits) {
        this.visits = visits;
    }

    public boolean getIsPrivateVisitor() {
        return isPrivateVisitor;
    }

    public void setIsPrivateVisitor(boolean isPrivateVisitor) {
        this.isPrivateVisitor = isPrivateVisitor;
    }
}
