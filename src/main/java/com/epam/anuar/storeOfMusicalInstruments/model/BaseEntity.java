package com.epam.anuar.storeOfMusicalInstruments.model;

public class BaseEntity {
    private int id;

    public BaseEntity(int id) {
        this.id = id;
    }

    public BaseEntity() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "id = " + id ;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
