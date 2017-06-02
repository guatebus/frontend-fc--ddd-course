package com.schibsted.domain.map.model;

public class VisitorReference {
    public final int x, y;
    public final int id;
    public final int type;

    public VisitorReference(int x, int y, int id, int type) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisitorReference that = (VisitorReference) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
