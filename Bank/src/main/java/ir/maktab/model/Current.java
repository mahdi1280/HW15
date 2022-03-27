package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema=Schema.SCHEMA_NAME)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="ID")
public class Current extends Account {

    private boolean czech;

    public Current(LocalDateTime createdAt, double amount, User user, boolean czech) {
        super(createdAt, amount, user);
        this.czech = czech;
    }

}
