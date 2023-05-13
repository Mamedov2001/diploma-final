package kz.careerguidance.applicationapi.dto.university;

import kz.careerguidance.applicationapi.entity.Category;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class SpecialityDto implements Serializable {

    @NotEmpty(message = "category is required")
    @NotNull(message = "category is required")
    private Category category;

    private String categoryImage;

    private String image;

    @NotEmpty(message = "Speciality name cannot be null")
    @NotNull(message = "Speciality name cannot be null")
    @Size(min = 3, max = 100, message = "Speciality name must contain between 3 and 100 characters")
    private final String name;

    @NotEmpty(message = "Speciality description cannot be null")
    @NotNull(message = "Speciality description cannot be null")
    @Size(min = 20, max = 200, message = "Speciality description must contain between 20 and 200 characters")
    private final String description;

    @NotEmpty(message = "Detailed information about the speciality is required")
    @NotNull(message = "Detailed information about the speciality is required")
    @Size(min = 3, max = 200, message = "Detailed information about the speciality must contain more than 3 characters")
    private String whatMakes;

    @NotEmpty(message = "Detailed information about the speciality is required")
    @NotNull(message = "Detailed information about the speciality is required")
    @Size(min = 3, max = 200, message = "Required knowledge must contain more than 3 characters")
    private String requiredKnowledge;

    @NotEmpty(message = "Detailed information about the speciality is required")
    @NotNull(message = "Detailed information about the speciality is required")
    @Size(min = 3, max = 200, message = "Salary information must contain more than 3 characters")
    private String salaryInfo;
}