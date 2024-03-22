package gr.aueb.cf.springauthsession5.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.reactive.AbstractReactiveTransactionManager;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "students")
public class Student extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;


    public Student(String firstname, String lastname,Boolean isActive){
        this.firstname = firstname;
        this.lastname = lastname;
        this.setIsActive(isActive);
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    public void addUser(User user){
        this.user = user;
        user.setStudent(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
