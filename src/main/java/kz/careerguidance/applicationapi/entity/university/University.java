package kz.careerguidance.applicationapi.entity.university;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class University {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Size(min = 5, max = 100, message = "University name must be between 5 and 100 characters")
    @NotNull(message = "University name is required")
    private String name;

    @Column(name = "status")
    @NotNull(message = "University status is required")
    private String status;


    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "university_subject",
            joinColumns = @JoinColumn(name = "university_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "university_tag",
            joinColumns = @JoinColumn(name = "university_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    @Size(min = 30, max = 500, message = "University description must be between 30 and 500 characters")
    @NotNull(message = "University description is required")
    private String description;


    @Column(name = "benefits")
    @NotNull(message = "University benefits are required")
    private String benefits;

    @Column(name = "location")
    @NotNull(message = "University location are required")
    private String location;

    @Column(name = "pass_scores")
    @NotNull(message = "University pass scores are required")
    private Integer passScores;

    @Column(name = "budget")
    @NotNull(message = "University budget is required")
    private Integer budget;

    @Column(name = "off_budget")
    @NotNull(message = "University offbudget is required")
    private Integer offBudget;

    @Column(name = "hasHotel")
    @NotNull(message = "University hotel existing status is required")
    private Boolean hasHotel;

    @Column(name = "hasMilitaryDepartment")
    @NotNull(message = "University military existing status is required")
    private Boolean hasMilitaryDepartment;

    @Column(name = "rating")
    @NotNull(message = "University rating is required")
    private Float rating;

    @Column(name = "link")
    @NotNull(message = "Link to university's webpage is required")
    private String link;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "university_speciality",
            joinColumns = @JoinColumn(name = "university_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities;

}
