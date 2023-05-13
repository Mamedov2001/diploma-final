package kz.careerguidance.applicationapi.mapper;

import kz.careerguidance.applicationapi.dto.university.SpecialityDto;
import kz.careerguidance.applicationapi.entity.university.Speciality;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpecialityMapper {
    SpecialityDto toSpecialityDto(Speciality s);

    Speciality toSpecialityEntity(SpecialityDto s);
}
