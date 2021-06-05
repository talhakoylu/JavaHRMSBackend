package net.ahmettalha.javahrmsbackend.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "candidate_users")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "educations", "jobExperiences", "candidateForeignLanguages", "candidateLinks"})
public class CandidateUser extends User{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "birth_year")
    private int birthYear;

    @Column(name = "mernis_verification")
    private boolean mernisVerification = false;

    @OneToMany(mappedBy = "candidateUser")
    private List<Education> educations;

    @OneToMany(mappedBy = "candidateUser")
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "candidateUser")
    private List<CandidateForeignLanguage> candidateForeignLanguages;

    @OneToOne(mappedBy = "candidateUser")
    private CandidateLink candidateLinks;
}
