package ma.jpa.hospital.web;

import ma.jpa.hospital.entities.Patient;
import ma.jpa.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//controleur qui permet de consulter la liste des patients
@RestController
public class PatientRestController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> patientList()
    {
        return patientRepository.findAll();
    }

}
