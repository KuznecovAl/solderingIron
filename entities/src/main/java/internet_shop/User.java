package internet_shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
@ToString
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

    @Column(name = "STS")
    private String status;

    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @CreationTimestamp
    @Column(name = "CRT_TIME")
    private LocalDateTime creationtime;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", privilege='" + privilege + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                ", lang='" + lang + '\'' +
                ", status='" + status + '\'' +
                ", birthday=" + birthday +
                ", creationtime=" + creationtime +
                '}';
    }
}
