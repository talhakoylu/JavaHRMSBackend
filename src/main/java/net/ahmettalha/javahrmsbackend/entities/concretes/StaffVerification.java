package net.ahmettalha.javahrmsbackend.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "staff_verifications")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class StaffVerification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "verified_at")
    private LocalDateTime date;

    @Column(name = "is_verified")
    private boolean isVerified;

    @ManyToOne()
    @JoinColumn(name = "staff_id")
    private StaffUser staffUser;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
