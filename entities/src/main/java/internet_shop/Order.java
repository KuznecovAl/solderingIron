package internet_shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@ToString(exclude = {"user","items"})
@AllArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {

    @Id
    @GenericGenerator(name = "ord-usr",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "user"))
    @GeneratedValue(generator = "ord-usr")
    @Column(name = "ORDER_ID")
    private Long id;

    @CreationTimestamp
    @Column(name = "CREATE_TIME")
    private LocalDateTime creationtime;

    @Column(name = "STATUS")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Item> items=new ArrayList<>();


}


