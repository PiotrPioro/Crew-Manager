package pl.crewmanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.crewmanager.entity.Admin;
import pl.crewmanager.entity.Contract;
import pl.crewmanager.entity.Worker;
import pl.crewmanager.service.ContractService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/contract")
public class ContractController {

    private final ContractService contractService;

    @GetMapping("/addContract")
    public String addContractView(Model model){

        model.addAttribute("contract", new Contract());
        return "addContract";
    }

    @PostMapping("/addContract")
    public String addContract(@ModelAttribute("contract") @Valid Contract contract, BindingResult result){

        if(result.hasErrors()){
            return "addContract";
        }

        contractService.addContract(contract);
        return "redirect:/contract/contractList";
    }

    @GetMapping("/editContract")
    public String editContractView(Model model, @RequestParam("id") Long contractId){

        Contract contract = contractService.findById(contractId);
        model.addAttribute("contract", contract);
        return "addContract";
    }

    @PostMapping("/editContract")
    public String editContract(@ModelAttribute("contract") @Valid Contract contract, BindingResult result){

        if(result.hasErrors()){
            return "addContract";
        }

        contractService.addContract(contract);
        return "redirect:/contract/contractEmail";
    }

    @GetMapping("/showContract")
    public String showContractView(@RequestParam("id") Long id, Model model, HttpSession session){

        Contract contract = contractService.findById(id);
        Admin admin = (Admin) session.getAttribute("loggedAdmin");
        model.addAttribute("contract", contract);
        model.addAttribute("admin", admin);
        return "showContract";
    }

    @GetMapping("/deleteContract")
    public String deleteContractView(@RequestParam("id") Long id, Model model){

        Contract contract = contractService.findById(id);
        model.addAttribute("contract", contract);
        return "deleteContract";
    }

    @GetMapping("/delete")
    public String deleteContract(@RequestParam("id") Long id){

        Contract contract = contractService.findById(id);
        contractService.deleteContract(contract.getId());
        return "redirect:/contract/contractList";
    }

    @GetMapping("/contractList")
    public String contractList(Model model, HttpSession session){

        List<Contract> contractList = contractService.findAllContract();
        Admin admin = (Admin) session.getAttribute("loggedAdmin");
        model.addAttribute("admin", admin);
        model.addAttribute("contracts", contractList);
        return "contractList";
    }

    @GetMapping("/contractEmail")
    public String contractEmail(@RequestParam("id") Long id , Model model){

        Contract contract = contractService.findById(id);
        List<Worker> workers = contractService.workerForContract(contract);
        model.addAttribute("workers", workers);
        model.addAttribute("contract", contract);

        return "contractEmail";
    }
}
