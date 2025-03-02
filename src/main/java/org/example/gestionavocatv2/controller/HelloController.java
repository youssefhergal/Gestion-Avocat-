package org.example.gestionavocatv2.controller;

import org.example.gestionavocatv2.entity.User;
import org.example.gestionavocatv2.repository.UserRepository;
import org.example.gestionavocatv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {




//    @Autowired
//    BureauAvocatService bureauAvocatService;

//    @Autowired
//    DossierService dossierService;
//
//    @Autowired
//    AvocatService avocatService;

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository repo;

//    @DeleteMapping("/Admin/Avocat/delete/{id}")
//    public ResponseEntity<Void> deleteDossier(@PathVariable Long id) {
//        dossierService.deleteDossier(id);
//        return ResponseEntity.noContent().build();
//    }

    @RequestMapping(value = "/")
    public String home(Model model, @RequestParam(name = "query", defaultValue = "") String mc,
                       @RequestParam(name = "query", defaultValue = "") String mu) throws Exception {
        List<User> users = userService.findByFirstName(mu);
//        List<BureauAvocat> bureaux = bureauAvocatService.findByNom(mc);
//        List<Barreau> barreaux = bureauAvocatService.findAllBarreaux();
//        List<Ville> villes = bureauAvocatService.findAllVilles();

        // Encoding an image example
        //String encodedImage = Base64.getEncoder().encodeToString(bureaux.get(0).getImage().getBytes());

        model.addAttribute("users", users);
//        model.addAttribute("bureaux", bureaux);
//        model.addAttribute("barreaux", barreaux);
//        model.addAttribute("villes", villes);
        System.out.println("hhfh");
        return "/home";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("je suis login");
        return "login";
    }

//    @RequestMapping("Admin/Avocat/employee-dashboard")
//    public String employeedashboard() {
//        return "employee-dashboard";
//    }

//    @RequestMapping("Admin/activities")
//    public String activities() {
//        return "activities";
//    }

    @GetMapping("/recherche")
    public String home1(Model model, @RequestParam(name = "query", defaultValue = "") String mc) {
//        List<BureauAvocat> bureaux = bureauAvocatService.findByNom(mc);
//        List<Barreau> barreaux = bureauAvocatService.findAllBarreaux();
//        List<Ville> villes = bureauAvocatService.findAllVilles();

//        model.addAttribute("bureaux", bureaux);
//        model.addAttribute("barreaux", barreaux);
//        model.addAttribute("villes", villes);

        return "home";
    }

//    @GetMapping("/Client/client-profile")
//    public String clientprofile(Model model, @RequestParam("bureau") Long bureau) {
//        BureauAvocat result = bureauAvocatService.findById(bureau);
//        model.addAttribute("bureau", result);
//        return "client-profile";
//    }

    @RequestMapping("/registration")
    public String registration(Model model, @RequestParam(name = "query", defaultValue = "") String mc) {
//        List<Ville> villes = bureauAvocatService.findAllVilles();
//        List<Barreau> barreaux = bureauAvocatService.findAllBarreaux();
//        List<BureauAvocat> bureaux = bureauAvocatService.findByNom(mc);
//        model.addAttribute("bureaux", bureaux);
//        model.addAttribute("villes", villes);
//        model.addAttribute("barreaux", barreaux);
        model.addAttribute("user", new User());

        return "registration";
    }

    @PostMapping("/process_register")
    public String processRegistration(@ModelAttribute("user") User user) {
        repo.save(user);
        return "register_success";
    }

    @RequestMapping("/Client/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/Admin/Avocat/clients")
    public String clients() {
        return "clients";
    }

//    @RequestMapping("/Client/AddFolder")
//    public String AddFolder(HttpServletRequest request, Model model) {
//        HttpSession session = request.getSession();
//        org.baeldung.persistence.model.User user = (org.baeldung.persistence.model.User) session.getAttribute("user1");
//        if (user != null) {
//            model.addAttribute("user", user);
//        }
//        return "Client/AddFolder";
//    }

    @RequestMapping("/Client/ajouterDossier")
    public String ajouterDossier() {
        return "ajouterDossier";
    }

    @RequestMapping("/Admin/Avocat/clients-list")
    public String clientslist() {
        return "clients-list";
    }

    @RequestMapping("/Admin/chat")
    public String chat() {
        return "chat";
    }

    @RequestMapping("/register")
    public String resgister() {
        return "register";
    }

    @RequestMapping("/forgetPassword")
    public String forgetPassword() {
        return "forgetPassword";
    }

    @RequestMapping("/registra")
    public String registra() {
        return "registra";
    }
}
