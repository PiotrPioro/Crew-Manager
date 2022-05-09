package pl.crewmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.crewmanager.entity.Worker;
import pl.crewmanager.repository.WorkerRepository;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

    @Transactional
    public void addWorker(Worker worker){

        workerRepository.save(worker);
    }

    @Transactional
    public void editWorker(Worker worker){

        workerRepository.save(worker);
    }

    @Transactional
    public void deleteWorker(String email){

        Worker worker = workerRepository.findByEmail(email);
        workerRepository.delete(worker);
    }

    public Worker findByEmail(String email){

        return workerRepository.findByEmail(email);
    }

    public Worker findById(Long id){

        return workerRepository.findWorkerById(id);
    }

    public List<Worker> findAllWorker(){

        List<Worker> workerList = workerRepository.findAll();
        return workerList.stream()
                .sorted(Comparator.comparing(Worker::getLastName)
                        .thenComparing(Worker::getFirstName))
                .collect(Collectors.toList());
    }
}
