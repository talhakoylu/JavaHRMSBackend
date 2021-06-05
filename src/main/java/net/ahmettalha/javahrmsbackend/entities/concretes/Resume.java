package net.ahmettalha.javahrmsbackend.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "resumes")
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cover_letter", length = 1500)
    private String coverLetter;

    @Column(name = "known_technologies", length = 1500)
    private String knownTechnologies;

    @ManyToOne
    @JoinColumn(name = "education_id")
    private Education education;

    @ManyToOne
    @JoinColumn(name = "job_experience_id")
    private JobExperience jobExperience;

    @ManyToOne
    @JoinColumn(name = "candidate_foreign_language_id")
    private CandidateForeignLanguage candidateForeignLanguage;

    @ManyToOne
    @JoinColumn(name = "candidate_link_id")
    private CandidateLink candidateLink;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;
}
