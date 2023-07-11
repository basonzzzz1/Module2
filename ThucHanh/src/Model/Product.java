package Model;

import java.util.Objects;

public class Product {
    private int idProduct;
    private String nameProduct;
    private float price;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, float price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return idProduct == product.idProduct && Float.compare(product.price, price) == 0 && Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, nameProduct, price);
    }

    @Override
    public String toString() {
        return "id = "+idProduct+" name product = "+nameProduct+" Price = "+price+"\n";
    }
}
