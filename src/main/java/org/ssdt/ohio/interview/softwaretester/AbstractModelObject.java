package org.ssdt.ohio.interview.softwaretester;

import java.util.UUID;

public abstract class AbstractModelObject {

    private static final long serialVersionUID = 1L;

    private UUID id;

    public AbstractModelObject() {
        this.id = UUID.randomUUID();
    }

    public AbstractModelObject(UUID id) {
        setId(id);
    }

    public AbstractModelObject(String id) {
        setId(id);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = UUID.fromString(id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractModelObject)) {
            return false;
        }

        AbstractModelObject other = (AbstractModelObject) obj;
        return getId().equals(other.getId());
    }
}
