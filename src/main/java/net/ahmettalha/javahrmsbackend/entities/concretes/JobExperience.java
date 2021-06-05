package net.ahmettalha.javahrmsbackend.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "job_experiences")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resumes"})
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "workplace_name")
    @NotNull
    private String workplaceName;

    @Column(name = "job_position")
    @NotNull
    private String jobPosition;

    @Column(name = "started_date")
    @NotNull
    private LocalDate startedDate;

    @Column(name = "finished_date")
    @Nullable
    private LocalDate finishedDate;

    @OneToMany(mappedBy = "jobExperience")
    private List<Resume> resumes;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    @NotNull
    private CandidateUser candidateUser;
}
