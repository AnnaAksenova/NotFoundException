package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String fabricator;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String fabricator) {
        super(id, name, price);
        this.fabricator = fabricator;
    }

    public String getFabricator() {
        return fabricator;
    }

    public void setFabricator(String fabricator) {
        this.fabricator = fabricator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone smartphone = (Smartphone) o;
        return Objects.equals(fabricator, smartphone.fabricator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fabricator);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "fabricator='" + fabricator + '\'' +
                '}';
    }
}