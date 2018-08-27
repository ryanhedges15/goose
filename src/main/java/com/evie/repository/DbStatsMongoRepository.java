package com.evie.repository;

import com.evie.domain.DbStats;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by rmhedge on 7/29/17.
 */
public interface DbStatsMongoRepository extends PagingAndSortingRepository<DbStats,String> {
}
