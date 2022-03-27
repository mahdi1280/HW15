package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
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

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{

        private LocalDateTime createdAt;
        private double amount;
        private User user;
        private double interest;

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setInterest(double interest) {
            this.interest = interest;
            return this;
        }

        public ShortTerm build(){
            return new ShortTerm(createdAt,amount,user,interest);
        }
    }

}
