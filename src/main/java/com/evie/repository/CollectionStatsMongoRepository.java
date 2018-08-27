package com.evie.repository;

import com.evie.domain.CollectionStats;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by shannonhedges on 8/6/17.
 */
public interface CollectionStatsMongoRepository extends PagingAndSortingRepository<CollectionStats, String> {

}
