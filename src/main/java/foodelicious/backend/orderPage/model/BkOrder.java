package foodelicious.backend.orderPage.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "orders")
public class BkOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Integer ordersId;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "orders_note")
    private String ordersNote;

    @Column(name = "orders_state")
    private String ordersState;

    @Column(name = "orders_total")
    private Integer ordersTotal;

    @Column(name = "orders_date")
    private Date ordersDate;

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getOrdersNote() {
        return ordersNote;
    }

    public void setOrdersNote(String ordersNote) {
        this.ordersNote = ordersNote;
    }

    public String getOrdersState() {
        return ordersState;
    }

    public void setOrdersState(String ordersState) {
        this.ordersState = ordersState;
    }

    public Integer getOrdersTotal() {
        return ordersTotal;
    }

    public void setOrdersTotal(Integer ordersTotal) {
        this.ordersTotal = ordersTotal;
    }

    public Date getOrdersDate() {
        return ordersDate;
    }

    public void setOrdersDate(Date ordersDate) {
        this.ordersDate = ordersDate;
    }
}
