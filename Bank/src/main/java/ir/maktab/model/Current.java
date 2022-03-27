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

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{

        private boolean czech;
        LocalDateTime createdAt;
        private double amount;
        private User user;

        public Builder setCzech(boolean czech) {
            this.czech = czech;
            return this;
        }

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

        public Current build(){
            return new Current(createdAt,amount,user,czech);
        }
    }
}
