package dbTables;

import lesson22.OrderModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS", schema = "MA_STUDENT")
public class Products implements java.io.Serializable {
    private String productId;
    private String mfrId;
    private String description;
    private BigDecimal price;
    private BigDecimal qtyOnHand;
    private Set<OrderModel> ordersSet;

    public Products() {
    }

    public Products(String productId) {
        this.productId = productId;
    }

    public Products(String productId, String mfrId, String description, BigDecimal price, BigDecimal qtyOnHand, Set<OrderModel> ordersSet) {
        this.productId = productId;
        this.mfrId = mfrId;
        this.description = description;
        this.price = price;
        this.qtyOnHand = qtyOnHand;
        this.ordersSet = ordersSet;
    }

    @Id
    @Column(name = "PRODUCT_ID")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Column(name = "MFR_ID")
    public String getMfrId() {
        return mfrId;
    }

    public void setMfrId(String mfrId) {
        this.mfrId = mfrId;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "QTY_ON_HAND")
    public BigDecimal getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(BigDecimal qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public Set<OrderModel> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<OrderModel> ordersSet) {
        this.ordersSet = ordersSet;
    }


}
