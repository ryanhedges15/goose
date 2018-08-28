package com.evie.repository;

import com.evie.domain.Candidate;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by shannonhedges on 8/6/17.
 */
public interface CandidateMongoRepository extends PagingAndSortingRepository<Candidate,String> {

}
