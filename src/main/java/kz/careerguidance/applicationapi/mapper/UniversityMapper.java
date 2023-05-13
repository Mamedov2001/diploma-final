package kz.careerguidance.applicationapi.mapper;

import kz.careerguidance.applicationapi.dto.university.UniversityDto;
import kz.careerguidance.applicationapi.entity.university.University;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UniversityMapper {
    UniversityDto toUniversityDto(University university);

    University toUniversityEntity(UniversityDto universityDTO);
}
