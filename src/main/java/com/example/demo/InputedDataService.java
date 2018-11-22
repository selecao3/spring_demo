package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class InputedDataService implements InputedDataServiceInterface{

    private final InputedDataRepository inputedDataRepository;

    @Autowired
    public InputedDataService() {
        this.inputedDataRepository = new InputedDataRepository(){
        
            @Override
            public <S extends InputedDatas> Optional<S> findOne(Example<S> example) {
                return null;
            }
        
            @Override
            public <S extends InputedDatas> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }
        
            @Override
            public <S extends InputedDatas> boolean exists(Example<S> example) {
                return false;
            }
        
            @Override
            public <S extends InputedDatas> long count(Example<S> example) {
                return 0;
            }
        
            @Override
            public <S extends InputedDatas> S save(S entity) {
                return null;
            }
        
            @Override
            public Optional<InputedDatas> findById(Long id) {
                return null;
            }
        
            @Override
            public boolean existsById(Long id) {
                return false;
            }
        
            @Override
            public void deleteById(Long id) {
                
            }
        
            @Override
            public void deleteAll(Iterable<? extends InputedDatas> entities) {
                
            }
        
            @Override
            public void deleteAll() {
                
            }
        
            @Override
            public void delete(InputedDatas entity) {
                
            }
        
            @Override
            public long count() {
                return 0;
            }
        
            @Override
            public Page<InputedDatas> findAll(Pageable pageable) {
                return null;
            }
        
            @Override
            public <S extends InputedDatas> S saveAndFlush(S entity) {
                return null;
            }
        
            @Override
            public <S extends InputedDatas> List<S> saveAll(Iterable<S> entities) {
                return null;
            }
        
            @Override
            public InputedDatas getOne(Long id) {
                return null;
            }
        
            @Override
            public void flush() {
                
            }
        
            @Override
            public List<InputedDatas> findAllById(Iterable<Long> ids) {
                return null;
            }
        
            @Override
            public <S extends InputedDatas> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }
        
            @Override
            public <S extends InputedDatas> List<S> findAll(Example<S> example) {
                return null;
            }
        
            @Override
            public List<InputedDatas> findAll(Sort sort) {
                return null;
            }
        
            @Override
            public List<InputedDatas> findAll() {
                return null;
            }
        
            @Override
            public void deleteInBatch(Iterable<InputedDatas> entities) {
                
            }
        
            @Override
            public void deleteAllInBatch() {
                
            }
        };
    }

    @Override
    public InputedDatas save(InputedDatas inputedDatas) {
        return inputedDataRepository.saveAndFlush(inputedDatas);
    }
}