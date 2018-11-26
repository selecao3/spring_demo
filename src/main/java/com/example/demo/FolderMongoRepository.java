package com.example.demo;

import java.util.List;

import com.example.demo.MyDataMongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderMongoRepository extends MongoRepository<FolderMongo, Long> {
    //extendsによりMongoRepositoryから継承している。
    //つまりMongoRepositoryインターフェイスに記載されているメソッドが使える状態になっているということ。
    //オリジナルのメソッドを作りたかったらここに書けば良い。
    List<MyDataMongo> findById(String id);

}