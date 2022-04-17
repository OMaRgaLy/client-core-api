package kz.dar.academy.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "client_test")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true, length = 50)
    private String clientId;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String surname;
    @Column(nullable = false, length = 50)
    private String email;
}
