package ma.jee.jpaap;

import ma.jee.jpaap.entities.Patient;
import ma.jee.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {

    //Injection des dépendances
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i=0; i<100; i++){

            patientRepository.save(
                    new Patient(null, "Imane", new Date(), Math.random()>0.5?true:false, (int)(Math.random()*100)));
        }



        Page<Patient> patients = patientRepository.findAll(PageRequest.of(1,10));
        System.out.println("Total pages : " + patients.getTotalPages());
        System.out.println("Total elements : " + patients.getTotalElements());
        System.out.println("Numero page : " + patients.getNumber());
        //Contenu de la page : liste des patients
        List<Patient> content = patients.getContent();

        //page qui va contenir une liste des patients malades
        Page<Patient> byMalade =patientRepository.findByMalade(true, PageRequest.of(0,4));

        List<Patient> patientList=patientRepository.chercherPatients("%I%", 40);

        //Parcourir la liste des patients de la page
        byMalade.forEach(p->{
            System.out.println("=============================");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());

        });

        System.out.println("********************************");
        Patient patient = patientRepository.findById(1L).orElse(null);
        if(patient!=null)
        {
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
        }
        patient.setScore(870);
        patientRepository.save(patient);
        patientRepository.delete(patient);


    }
}
