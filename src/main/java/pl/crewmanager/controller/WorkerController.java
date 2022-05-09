package pl.crewmanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.crewmanager.entity.Admin;
import pl.crewmanager.entity.Worker;
import pl.crewmanager.service.WorkerService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerService workerService;

    @GetMapping("/addWorker")
    public String addWorkerView(Model model){

        model.addAttribute("worker", new Worker());
        return "addWorker";
    }

    @PostMapping("/addWorker")
    public String addWorker(@ModelAttribute("worker") @Valid Worker worker, BindingResult result){

        if(result.hasErrors()){
            return "addWorker";
        }

        workerService.addWorker(worker);
        return "redirect:/worker/workerList";
    }

    @GetMapping("/editWorker")
    public String editWorkerView(Model model, @RequestParam("id") Long workerId){

        Worker worker = workerService.findById(workerId);
        model.addAttribute("worker", worker);
        return "addWorker";
    }

    @PostMapping("/editWorker")
    public String editWorker(@ModelAttribute("worker") @Valid Worker worker, BindingResult result){

        if(result.hasErrors()){
            return "addWorker";
        }

        workerService.addWorker(worker);
        return "redirect:/worker/workerList";
    }

    @GetMapping("/showWorker")
    public String showWorkerView(@RequestParam("id") Long id, Model model, HttpSession session){

        Worker worker = workerService.findById(id);
        Admin admin = (Admin) session.getAttribute("loggedAdmin");
        model.addAttribute("worker", worker);
        model.addAttribute("admin", admin);
        return "showWorker";
    }

    @GetMapping("/deleteWorker")
    public String deleteWorkerView(@RequestParam("id") Long id, Model model){

        Worker worker = workerService.findById(id);
        model.addAttribute("worker", worker);
        return "deleteWorker";
    }

    @GetMapping("/delete")
    public String deleteWorker(@RequestParam("id") Long id){

        Worker worker = workerService.findById(id);
        workerService.deleteWorker(worker.getEmail());
        return "redirect:/worker/workerList";
    }

    @GetMapping("/workerList")
    public String workerList(Model model, HttpSession session){

        List<Worker> workerList = workerService.findAllWorker();
        Admin admin = (Admin) session.getAttribute("loggedAdmin");
        model.addAttribute("admin", admin);
        model.addAttribute("workers", workerList);
        return "workerList";
    }
}
