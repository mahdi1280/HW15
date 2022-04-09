package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrow extends BaseEntity{

    @ManyToOne
    private Person person;
    @ManyToOne
    private Disc disk;
    private LocalDateTime date;
    @Column(columnDefinition = "boolean default false")
    private boolean rejected=false;
}
