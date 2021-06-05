package net.ahmettalha.javahrmsbackend.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "candidate_foreign_language")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateForeignLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language_level")
    private String languageLevel;

    @ManyToOne
    @JoinColumn(name = "foreign_language_id")
    private ForeignLanguage foreignLanguage;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private CandidateUser candidateUser;
}
