package pl.crewmanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.crewmanager.entity.Contract;
import pl.crewmanager.entity.Worker;
import pl.crewmanager.service.EmailService;
import pl.crewmanager.service.WorkerService;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;
    private final WorkerService workerService;

    @GetMapping("/sendEmail")
    public String sendEmail(HttpSession session, @RequestParam("id") Long id){

        Contract contract = (Contract) session.getAttribute("contract");
        Worker worker = workerService.findById(id);

        String subject = "Jest job";
        String text = String.format("Nazwa kontraktu %s \n Miejsce kontraktu %s \n Nazwa firmy %s \n Imię i Nazwisko osoby do kontaktu %s \n" +
                "Numer telefonu osoby kontaktowej %s \n Początek kontraktu %s \n Koniec kontraktu %s \n"
                , contract.getName(), contract.getPlace(), contract.getCompanyName(), contract.getContactName(),
                contract.getContactPhoneNumber(), contract.getStartDate(), contract.getEndDate());
        String to = worker.getEmail();
        emailService.sendMessage(subject, text, to);
        return "redirect:/contract/contractEmail";
    }
}
