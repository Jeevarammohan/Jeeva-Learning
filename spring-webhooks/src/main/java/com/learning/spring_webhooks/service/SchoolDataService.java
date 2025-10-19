package com.learning.spring_webhooks.service;

import com.learning.spring_webhooks.model.SchoolData;
import com.learning.spring_webhooks.repository.SchoolDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolDataService {

    @Autowired
    private SchoolDataRepository schoolDataRepository;

    public SchoolData addNewSchool(SchoolData schoolData) {
      return  schoolDataRepository.save(schoolData);
    }

    public SchoolData getSchoolData(Integer schoolId) {
        return schoolDataRepository.findById(schoolId).get();
    }
}
