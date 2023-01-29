package com.mingxinbeijing.search.service;

import com.mingxinbeijing.search.dto.trip.SearchRQ;
import com.mingxinbeijing.search.dto.trip.SearchRS;

import java.util.Optional;

/**
 * 
 * @author jiangzhiwei
 * @date 2022/11/29
 */
public interface SupplyService {

	Optional<SearchRS> search(SearchRQ req);



}
