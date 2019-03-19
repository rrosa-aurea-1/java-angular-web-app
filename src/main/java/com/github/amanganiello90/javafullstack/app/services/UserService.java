package com.github.amanganiello90.javafullstack.app.services;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.List;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.amanganiello90.javafullstack.app.models.User;
import com.github.amanganiello90.javafullstack.app.repositories.UserRepository;

/**
 *
 * @author amanganiello90
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	User user;

	public User findById(String id) {
		return userRepository.findById(id);
	}

	public String save(User user) {
		userRepository.save(user);
		return user.getId();
	}

	public List<User> findAll() {
		return userRepository.findAll();

	}

	public User update(String id, User user) {

        for (int i = 0; i < 10; i++)
        {
            System.out.println("Teste" + i);
            System.out.println("Teste1" + i);
        }
        this.printText();
        printText();

        user.setId(id);

		this.save(user);
		return user;
	}

	public String delete ( String id ){
    User user = this.findById(id);
    userRepository.delete( user );
    return "user deleted with id: " + id;
	}

    public void printText()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("Teste" + i);
            System.out.println("Teste1" + i);
        }
    }


    public void  listTest()
    {
        List<String> l = new ArrayList<String>();
        List<String> l1 = new ArrayList<>();

        if (new Random().nextInt( 2) == 0)
        {
            l.add("Test");
        }

        int i = 5;
        int j = 6;
        i = new Random().nextInt(10);
        if (i == 6)
        {
        System.out.println("wrong alignment");
        }

        if (new Random().nextInt(3) == 0) {
            this.listTest();
            listTest();
        }

        if (new Random().nextInt(2) == 0)
        {
            if (i==j) {System.out.printf("nestedf If");}
        }

        if (i == j)
            System.out.printf("nestedf If");
    }
}
