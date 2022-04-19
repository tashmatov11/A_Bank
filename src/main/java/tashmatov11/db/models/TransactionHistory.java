package tashmatov11.db.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_seq")
    @SequenceGenerator(name = "hibernate_seq", sequenceName = "transact_seq", allocationSize = 1,
            initialValue = 2)
    @Column(name = "transaction_id")
    private Long id;
    private int sum;
    private LocalDate transactionTime;
    @ManyToOne
    private BankAccount bankAccount;
}
