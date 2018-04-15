package internet_shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    //private Long id;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STREET")
    private String street;
    @Column(name = "BUILDING")
    private String building;
    @Column(name = "FLT")
    private String flat;
    @Column(name = "POSTAL_CODE")
    private String index;



}
