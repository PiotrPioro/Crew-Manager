package pl.crewmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.crewmanager.entity.Contract;
import pl.crewmanager.entity.Worker;
import pl.crewmanager.repository.ContractRepository;
import pl.crewmanager.repository.WorkerRepository;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final WorkerRepository workerRepository;

    @Transactional
    public void addContract(Contract contract){

        contractRepository.save(contract);
    }

    @Transactional
    public void editContract(Contract contract){

        contractRepository.save(contract);
    }

    @Transactional
    public void deleteContract(Long id){

        Contract contract = contractRepository.findContractById(id);
        contractRepository.delete(contract);
    }

    public Contract findById(Long id){

        return contractRepository.findContractById(id);
    }

    public List<Contract> findAllContract(){

        List<Contract> contractList = contractRepository.findAll();
        return contractList.stream()
                .sorted(Comparator.comparing(Contract::getName))
                .collect(Collectors.toList());
    }

    public List<Worker> workerForContract(Contract contract){

        List<Worker> workerList = workerRepository.findAll();
        List<Worker> workerList1 = new LinkedList<>();
        List<Worker> workerList2 = new LinkedList<>();
        List<Worker> workerList3 = new LinkedList<>();
        List<Worker> workerList4 = new LinkedList<>();
        List<Worker> workerList5 = new LinkedList<>();
        List<Worker> workerList6 = new LinkedList<>();
        List<Worker> workerList7 = new LinkedList<>();

        if(contract.isRigging()){
            workerList1 = workerList.stream()
                    .filter(worker -> worker.isRigging())
                    .collect(Collectors.toList());
        }
        else {
            workerList1 = workerList;
        }

        if(contract.isConstruction()){
            workerList2 = workerList1.stream()
                    .filter(worker -> worker.isConstruction())
                    .collect(Collectors.toList());
        }
        else {
            workerList2 = workerList1;
        }

        if(contract.isLighting()){
            workerList3 = workerList2.stream()
                    .filter(worker -> worker.isLighting())
                    .collect(Collectors.toList());
        }
        else {
            workerList3 = workerList2;
        }

        if(contract.isForklift()){
            workerList4 = workerList3.stream()
                    .filter(worker -> worker.isForklift())
                    .collect(Collectors.toList());
        }
        else {
            workerList4 = workerList3;
        }

        if(contract.isCherrypicker()){
            workerList5 = workerList4.stream()
                    .filter(worker -> worker.isCherrypicker())
                    .collect(Collectors.toList());
        }
        else {
            workerList5 = workerList4;
        }

        if(contract.isSound()){
            workerList6 = workerList5.stream()
                    .filter(worker -> worker.isSound())
                    .collect(Collectors.toList());
        }
        else {
            workerList6 = workerList5;
        }

        if(contract.isMultimedia()){
            workerList7 = workerList6.stream()
                    .filter(worker -> worker.isMultimedia())
                    .collect(Collectors.toList());
        }
        else {
            workerList7 = workerList6;
        }

        return workerList7.stream()
                .sorted(Comparator.comparing(Worker::getLastName)
                .thenComparing(Worker::getFirstName))
                .collect(Collectors.toList());
    }
}
