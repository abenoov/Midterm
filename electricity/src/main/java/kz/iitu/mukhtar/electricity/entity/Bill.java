package kz.iitu.mukhtar.electricity.entity;

public class Bill {
    private int id;
    private int kwh;
    private String name;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKwh() {
        return kwh;
    }

    public void setKwh(int kwh) {
        this.kwh = kwh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", kwh=" + kwh +
                ", tariff='" + name + '\'' +
                '}';
    }
}
