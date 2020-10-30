package com.finalcase.oaks.OaksFinalCase;

import com.finalcase.oaks.OaksFinalCase.entity.Role;
import com.finalcase.oaks.OaksFinalCase.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OaksFinalCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(OaksFinalCaseApplication.class, args);
        //System.out.println(new BCryptPasswordEncoder().encode("123"));

        /*Role admin = new Role();
        admin.setNameRole("ADMIN");

        List<Role> roles = new ArrayList<>();
        roles.add(admin);

        User userAdmin = new User();
        userAdmin.setLogin("admin");
        userAdmin.setPassword("1234");
        userAdmin.setRoles(roles);*/
    }
}
