package it.epicode;

import java.util.Random;

public class Customers {
    private long id;
    private String name;
    private int tier;

    public Customers(String name) {
        Random rdnm = new Random();
        this.id = rdnm.nextLong(100000, 999999);
        this.name = name;
        this.tier = rdnm.nextInt(1, 4);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTier() {
        return tier;
    }

}
