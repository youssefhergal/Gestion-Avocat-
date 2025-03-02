package org.example.gestionavocatv2.config;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


import org.example.gestionavocatv2.entity.Privilege;
import org.example.gestionavocatv2.entity.Role;
import org.example.gestionavocatv2.entity.User;
import org.example.gestionavocatv2.repository.PrivilegeRepository;
import org.example.gestionavocatv2.repository.RoleRepository;
import org.example.gestionavocatv2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // API

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // == create initial privileges
        final Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        final Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
        final Privilege passwordPrivilege = createPrivilegeIfNotFound("CHANGE_PASSWORD_PRIVILEGE");

        // == create initial roles
        final List<Privilege> adminPrivileges = new ArrayList<>(Arrays.asList(readPrivilege, writePrivilege, passwordPrivilege));
        final List<Privilege> userPrivileges = new ArrayList<>(Arrays.asList(readPrivilege, passwordPrivilege));
        final Role adminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        final Role userRole = createRoleIfNotFound("ROLE_USER", userPrivileges);

        // == create initial user
        createUserIfNotFound("chakirfst@gmail.com", "لقمان", "شكير", "1234", new ArrayList<>(Arrays.asList(userRole)));
        createUserIfNotFound("bens@yahoo.com", "خولة", "بن عبو", "abed", new ArrayList<>(Arrays.asList(adminRole)));
        createUserIfNotFound("idriss@yahoo.com", "العيساوي", "ادريس", "abcd", new ArrayList<>(Arrays.asList(adminRole)));

        alreadySetup = true;
    }

    @Transactional
    protected Privilege createPrivilegeIfNotFound(final String name) {
        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilege = privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    protected Role createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
        }
        role.setPrivileges(privileges);
        role = roleRepository.save(role);
        return role;
    }

    @Transactional
    protected User createUserIfNotFound(final String email, final String firstName, final String lastName, final String password, final Collection<Role> roles) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(passwordEncoder.encode(password));
            user.setEmail(email);
            user.setEnabled(true);
        }
        user.setRoles(roles);
        user = userRepository.save(user);
        return user;
    }

}
