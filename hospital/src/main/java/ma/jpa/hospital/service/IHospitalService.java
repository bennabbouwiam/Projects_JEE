package ma.jpa.hospital.service;

import ma.jpa.hospital.entities.Consultation;
import ma.jpa.hospital.entities.Medecin;
import ma.jpa.hospital.entities.Patient;
import ma.jpa.hospital.entities.RendezVous;

public interface IHospitalService {

    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
