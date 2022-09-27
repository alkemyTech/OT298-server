package com.alkemy.ong.util;

import com.alkemy.ong.security.model.Role;
import com.alkemy.ong.security.model.User;
import com.alkemy.ong.security.repository.RoleRepository;
import com.alkemy.ong.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class UserDataLoader implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (userRepository.count() == 0) {

            //ROLES
            Role roleAdmin = new Role(1L, "ROLE_ADMIN");
            Role roleRegular = new Role(2L, "ROLE_USER");

            List<Role> roles = new ArrayList<>();
            roles.add(roleAdmin);
            roles.add(roleRegular);
            roleRepository.saveAll(roles);

            //LIST ROLES
            Set<Role> rolesRegular = new HashSet<>();
            rolesRegular.add(roleRegular);

            Set<Role> rolesAdmin = new HashSet<>();
            rolesAdmin.add(roleAdmin);

            //ADMIN USERS
            User userAdmin1 = new User(1L,
                    "AdminFirstNameUno",
                    "AdminLastNameUno",
                    "admin1@admin1.com",
                    passwordEncoder.encode("1234Admin1!"),
                    rolesAdmin);
            User userAdmin2 = new User(2L,
                    "AdminFirstNameDos",
                    "AdminLastNameDos",
                    "admin2@admin2.com",
                    passwordEncoder.encode("1234Admin2!"),
                    rolesAdmin);
            User userAdmin3 = new User(3L,
                    "AdminFirstNameTres",
                    "AdminLastNameTres",
                    "admin3@admin3.com",
                    passwordEncoder.encode("1234Admin3!"),
                    rolesAdmin);
            User userAdmin4 = new User(4L,
                    "AdminFirstNameFour",
                    "AdminLastNameFour",
                    "admin4@admin4.com",
                    passwordEncoder.encode("1234Admin4!"),
                    rolesAdmin);
            User userAdmin5 = new User(5L,
                    "AdminFirstNameFive",
                    "AdminLastNameFive",
                    "admin5@admin5.com",
                    passwordEncoder.encode("1234Admin5!"),
                    rolesAdmin);
            User userAdmin6 = new User(6L,
                    "AdminFirstNameSix",
                    "AdminLastNameSix",
                    "admin6@admin6.com",
                    passwordEncoder.encode("1234Admin6!"),
                    rolesAdmin);
            User userAdmin7 = new User(7L,
                    "AdminFirstNameSeven",
                    "AdminLastNameSeven",
                    "admin7@admin7.com",
                    passwordEncoder.encode("1234Admin7!"),
                    rolesAdmin);
            User userAdmin8 = new User(8L,
                    "AdminFirstNameEight",
                    "AdminLastNameEight",
                    "admin8@admin8.com",
                    passwordEncoder.encode("1234Admin8!"),
                    rolesAdmin);
            User userAdmin9 = new User(9L,
                    "AdminFirstNameNine",
                    "AdminLastNameNine",
                    "admin9@admin9.com",
                    passwordEncoder.encode("1234Admin9!"),
                    rolesAdmin);
            User userAdmin10 = new User(10L,
                    "AdminFirstNameTen",
                    "AdminLastNameTen",
                    "admin10@admin10.com",
                    passwordEncoder.encode("1234Admin10!"),
                    rolesAdmin);

            List<User> usersAdmin = new ArrayList<>();
            usersAdmin.add(userAdmin1);
            usersAdmin.add(userAdmin2);
            usersAdmin.add(userAdmin3);
            usersAdmin.add(userAdmin4);
            usersAdmin.add(userAdmin5);
            usersAdmin.add(userAdmin6);
            usersAdmin.add(userAdmin7);
            usersAdmin.add(userAdmin8);
            usersAdmin.add(userAdmin9);
            usersAdmin.add(userAdmin10);
            userRepository.saveAll(usersAdmin);

            //REGULAR USERS
            User userRegular1 = new User(11L,
                    "UserFirstNameUno",
                    "UserLastNameUno",
                    "user1@user1.com",
                    passwordEncoder.encode("1234User1!"),
                    rolesRegular);
            User userRegular2 = new User(12L,
                    "UserFirstNameDos",
                    "UserLastNameDos",
                    "user2@user2.com",
                    passwordEncoder.encode("1234User2!"),
                    rolesRegular);
            User userRegular3 = new User(13L,
                    "UserFirstNameTres",
                    "UserLastNameTres",
                    "user3@user3.com",
                    passwordEncoder.encode("1234User3!"),
                    rolesRegular);
            User userRegular4 = new User(14L,
                    "UserFirstNameFour",
                    "UserLastNameFour",
                    "user4@user4.com",
                    passwordEncoder.encode("1234User4!"),
                    rolesRegular);
            User userRegular5 = new User(15L,
                    "UserFirstNameFive",
                    "UserLastNameFive",
                    "user5@user5.com",
                    passwordEncoder.encode("1234User5!"),
                    rolesRegular);
            User userRegular6 = new User(16L,
                    "UserFirstNameSix",
                    "UserLastNameSix",
                    "user6@user6.com",
                    passwordEncoder.encode("1234User6!"),
                    rolesRegular);
            User userRegular7 = new User(17L,
                    "UserFirstNameSeven",
                    "UserLastNameSeven",
                    "user7@user7.com",
                    passwordEncoder.encode("1234User7!"),
                    rolesRegular);
            User userRegular8 = new User(18L,
                    "UserFirstNameEight",
                    "UserLastNameEight",
                    "user8@user8.com",
                    passwordEncoder.encode("1234User8!"),
                    rolesRegular);
            User userRegular9 = new User(19L,
                    "UserFirstNameNine",
                    "UserLastNameNine",
                    "user9@user9.com",
                    passwordEncoder.encode("1234User9!"),
                    rolesRegular);
            User userRegular10 = new User(20L,
                    "UserFirstNameTen",
                    "UserLastNameTen",
                    "user10@user10.com",
                    passwordEncoder.encode("1234User10!"),
                    rolesRegular);

            List<User> usersRegular = new ArrayList<>();
            usersRegular.add(userRegular1);
            usersRegular.add(userRegular2);
            usersRegular.add(userRegular3);
            usersRegular.add(userRegular4);
            usersRegular.add(userRegular5);
            usersRegular.add(userRegular6);
            usersRegular.add(userRegular7);
            usersRegular.add(userRegular8);
            usersRegular.add(userRegular9);
            usersRegular.add(userRegular10);
            userRepository.saveAll(usersRegular);

        }
    }
}
