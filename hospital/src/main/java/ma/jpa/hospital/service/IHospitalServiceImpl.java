package ma.jpa.hospital.service;

import ma.jpa.hospital.entities.Consultation;
import ma.jpa.hospital.entities.Medecin;
import ma.jpa.hospital.entities.Patient;
import ma.jpa.hospital.entities.RendezVous;
import ma.jpa.hospital.repositories.ConsultationRepository;
import ma.jpa.hospital.repositories.MedecinRepository;
import ma.jpa.hospital.repositories.PatientRepository;
import ma.jpa.hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

//les objets de la couche metier
@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {
    //Faire l'injection

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public IHospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository,
                                RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {

        //générer une chaine de caractère unique
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultationRepository.save(consultation);
    }
}
