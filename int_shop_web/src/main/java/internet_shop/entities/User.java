package internet_shop.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
@EqualsAndHashCode(exclude = {"orders","address"})
@ToString(exclude = {"orders","address"})
public class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "LGN")
    private String login;

    @Column(name = "PWD")
    private String password;

    @Column(name = "FNAME")
    private String firstname;

    @Column(name = "LNAME")
    private String lastname;
/*ROLE_+ADMIN,MODER,USER,GUEST*/
    @Column(name = "PRIVILEGE")
    private String privilege;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Embedded
    private Address address;

    @Column(name = "LANG")
    private String lang;
/*VIP,REG,NEW,GUE,DEL*/
    @Column(name = "STATE")
    private String status;

    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

    @OneToMany(mappedBy = "user")
    private List<Order> orders=new ArrayList<>();

    @CreationTimestamp
    @Column(name = "CRT_TIME")
    private LocalDateTime creationtime;

    public User(String login, String password, String email, Address address) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.address=address;
    }



}
