package hcmute.edu.tgdd.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 10)
    private String customerPhone;
    @Temporal(TemporalType.DATE)
    private final Date date = new Date();
    private String request;
    private String coupon;
    @Column(nullable = false)
    private int statusId;

    public Cart() {
    }

    public Cart(String customerPhone, String request, String coupon, int statusId) {
        this.customerPhone = customerPhone;
        this.request = request;
        this.coupon = coupon;
        this.statusId = statusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Date getDate() {
        return date;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", customerPhone='" + customerPhone + '\'' +
                ", date=" + date +
                ", request='" + request + '\'' +
                ", coupon='" + coupon + '\'' +
                ", statusId=" + statusId +
                '}';
    }
}
