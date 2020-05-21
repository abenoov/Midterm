package kz.iitu.mukhtar.electricity.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "users"})
public class Checkouts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String payDate;
    private boolean payedStatus;


    @OneToMany(mappedBy = "checkouts", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();
}
