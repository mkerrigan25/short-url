package com.michael.shorturl.Repository;


import com.michael.shorturl.entity.LongURL;
import org.springframework.data.repository.CrudRepository;


public interface URLRepository extends CrudRepository<LongURL, Integer> {

    LongURL findLongUrlById(Integer id);
}
