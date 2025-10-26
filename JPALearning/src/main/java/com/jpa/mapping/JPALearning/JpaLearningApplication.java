package com.jpa.mapping.JPALearning;

import com.jpa.mapping.JPALearning.model.Manufactures;
import com.jpa.mapping.JPALearning.model.Model;
import com.jpa.mapping.JPALearning.repo.ManufactureRepository;
import com.jpa.mapping.JPALearning.repo.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaLearningApplication implements CommandLineRunner {

    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private ManufactureRepository manufacturesRepository;
	public static void main(String[] args) {
		SpringApplication.run(JpaLearningApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Manufactures manufactures = new Manufactures("Honda");
        manufacturesRepository.save(manufactures);
        Model model1 = new Model(1, "AYZ", manufactures);
        Model model2 = new Model(2, "ZET", manufactures);
        modelRepository.save(model1);
        modelRepository.save(model2);
        
    }
}
