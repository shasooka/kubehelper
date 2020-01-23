package com.shantanu.kubehelper;


import com.shantanu.kubehelper.model.Pod;
import com.shantanu.kubehelper.repository.PodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class PodController {

    @Autowired
    private PodRepository podRepository;

    @GetMapping("/questions")
    public Page<Pod> getPods(Pageable pageable) {
        return podRepository.findAll(pageable);
    }

}