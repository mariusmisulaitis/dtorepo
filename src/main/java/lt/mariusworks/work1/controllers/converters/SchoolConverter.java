package lt.mariusworks.work1.controllers.converters;

import lt.mariusworks.work1.dto.SchoolDTO;
import lt.mariusworks.work1.entities.School;

import java.util.ArrayList;
import java.util.List;

public class SchoolConverter {

    public static SchoolDTO convertEntityToDTO(School school) {
        SchoolDTO dto = null;
        if (school != null) {
            dto = new SchoolDTO();
            dto.setId(school.getId());
            dto.setName(school.getName());
            dto.setAddress(school.getAddress());
        }
        return dto;
    }

    public static List<SchoolDTO> convertEntityListToDTOList(List<School> schools) {
        List<SchoolDTO> dtoList = null;
        if (schools != null && !schools.isEmpty()) {
            dtoList = new ArrayList<SchoolDTO>();
            for (School school : schools) {
                dtoList.add(SchoolConverter.convertEntityToDTO(school));
            }
        }
        return dtoList;
    }

}
