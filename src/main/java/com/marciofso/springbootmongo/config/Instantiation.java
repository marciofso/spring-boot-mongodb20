package com.marciofso.springbootmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marciofso.springbootmongo.domain.Post;
import com.marciofso.springbootmongo.domain.User;
import com.marciofso.springbootmongo.repository.PostRepository;
import com.marciofso.springbootmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRpository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
		postRpository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null,sdf.parse ("21/03/2018"),"Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null,sdf.parse ("23/03/2018"),"Bom dia", "Acordei feliz hoje!", maria);
		
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		postRpository.saveAll(Arrays.asList(post1, post2));
		
		 
		
	}
}
