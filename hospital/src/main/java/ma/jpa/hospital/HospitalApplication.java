package ma.jpa.hospital;

import ma.jpa.hospital.entities.*;
import ma.jpa.hospital.repositories.ConsultationRepository;
import ma.jpa.hospital.repositories.MedecinRepository;
import ma.jpa.hospital.repositories.PatientRepository;
import ma.jpa.hospital.repositories.RendezVousRepository;
import ma.jpa.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication  {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	//methode éxécutée au démarrage et l'objet qui va le retourner => composant Spring
	@Bean
	CommandLineRunner start(IHospitalService hospitalService,
							PatientRepository patientRepository,
							RendezVousRepository rendezVousRepository,
							MedecinRepository medecinRepository,
							ConsultationRepository consultationRepository){
       return args -> {
		   Stream.of("Mohammed", "Hassan", "Najat").forEach(name->{
			   Patient patient= new Patient();
			   patient.setNom(name);
			   patient.setDateNaissance(new Date());
			   patient.setMalade(false);
			   hospitalService.savePatient(patient);
		   });

		   Stream.of("Aymane", "Hanane", "Yasmine").forEach(name->{
			   Medecin medecin=new Medecin();
			   medecin.setNom(name);
			   medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
			   medecin.setEmail(name+"@gmail.com");
			   hospitalService.saveMedecin(medecin);
		   });

		   Patient patient = patientRepository.findById(1L).orElse(null);
		   Patient patient1= patientRepository.findByNom("Mohammed");

		   Medecin medecin = medecinRepository.findByNom("Yasmine");

		   RendezVous rendezVous = new RendezVous();
		   rendezVous.setDate(new Date());
		   rendezVous.setStatus(StatusRDV.PENDING);
		   rendezVous.setMedecin(medecin);
		   rendezVous.setPatient(patient);
		   RendezVous savedRDV= hospitalService.saveRDV(rendezVous);
		   System.out.println(savedRDV.getId());

		 // hospitalService.saveRDV(rendezVous);

		   RendezVous rendezVous1= rendezVousRepository.findAll().get(0);
		   Consultation consultation=new Consultation();
		   consultation.setDateConsultation(new Date());
		   consultation.setRendezVous(rendezVous1);
		   consultation.setRapport("Rapport de la consultation ...");
		   hospitalService.saveConsultation(consultation);

	   };
	}
}
