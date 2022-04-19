package tashmatov11.db.models;

import tashmatov11.db.models.userClasses.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_seq")
    @SequenceGenerator(name = "hibernate_seq", sequenceName = "bank_seq", allocationSize = 1,
            initialValue = 2)
    @Column(name = "bank_account_id")
    private Long id;
    @OneToOne(mappedBy = "bankAccount")
    private User user;
    private int account;
    private LocalDate createdAt;
    @OneToMany
    @JoinTable(
            name = "bank_account_transaction",
            joinColumns = @JoinColumn(
                    name = "bank_account_id",
                    referencedColumnName = "bank_account_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "transaction_id",
                    referencedColumnName = "transaction_id"
            )
    )
    private List<TransactionHistory> transaction;
}
