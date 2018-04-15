package internet_shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@ToString(exclude = "order")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @GenericGenerator(name = "item-prod",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "product"))
    @GeneratedValue(generator = "item-prod")
    @Column(name = "ITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn(name = "PROD_ID")
    private Product product;

    @Column(name = "QUANT_IN_ORDER")
    private Long quantity;

    @Column(name = "DISCOUNT")
    private Integer discount;

    @Column(name = "STS_ITEM")
    private String status;

}

