package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema=Schema.SCHEMA_NAME)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="ID")
public class ShortTerm extends Account {

    private double interest;

    public ShortTerm(LocalDateTime createdAt, double amount, User user, double interest) {
        super(createdAt, amount, user);
        this.interest = interest;
    }

}
