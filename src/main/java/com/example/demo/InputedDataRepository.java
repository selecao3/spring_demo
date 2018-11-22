package com.example.demo;
import org.springframework.stereotype.Repository;
import com.example.demo.InputedDatas;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface InputedDataRepository extends JpaRepository<InputedDatas,Long> {
}