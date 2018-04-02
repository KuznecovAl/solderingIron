package internet_shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "PROD_ID")
    private Long id;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SUPPLIER")
    private String supplier;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "PICS")
    private String pics;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "QUANT")
    private Integer quantity;

    @Column(name = "PRICE")
    private float price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;


}

