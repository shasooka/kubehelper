package com.shantanu.kubehelper.repository;

import com.shantanu.kubehelper.model.Pod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PodRepository extends JpaRepository<Pod, Long>{
}
