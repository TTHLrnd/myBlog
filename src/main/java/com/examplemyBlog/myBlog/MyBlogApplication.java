package com.examplemyBlog.myBlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBlogApplication {
	/**
	 * 						String username,
	 *                   String firstname,
	 *                   String lastname,
	 *                   Date birthdate,
	 *                   String email,
	 *                   String password,
	 *                   List<Blog> userBlogs,
	 *                   List<Comment> userComments,
	 *                   Role role
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(MyBlogApplication.class, args);
	}

/*	@Bean
	CommandLineRunner commandLineRunner(AuthorRepository authorRepository){
		return args -> {
			Author temp = new Author(
					"admin",
					"admin",
					"admin",
					LocalDate.of(Integer.parseInt("1999"), Integer.parseInt("2"), Integer.parseInt("12")),
					"lorandtoth.lori@gmail.com",
					"admin",
					new ArrayList<>(),
					new ArrayList<>(),
					Role.valueOf("admin")
			);
			authorRepository.save(temp);


		};
	}*/
}
