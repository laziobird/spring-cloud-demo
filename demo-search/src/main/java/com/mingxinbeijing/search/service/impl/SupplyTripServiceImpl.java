package com.mingxinbeijing.search.service.impl;

import com.mingxinbeijing.search.dto.trip.SearchRQ;
import com.mingxinbeijing.search.dto.trip.SearchRS;
import com.mingxinbeijing.search.service.SupplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * 投放携程的Search API
 *
 */
@Service
public class SupplyTripServiceImpl implements SupplyService {

    @Autowired
    RestTemplate restTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(SupplyTripServiceImpl.class);

    @Override
    public Optional<SearchRS> search(SearchRQ req) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SearchRQ> request = new HttpEntity<>(req, headers);
        SearchRS rs = restTemplate.postForObject("http://xjctrip.fishup.cn/flight/search", request, SearchRS.class);
        return Optional.ofNullable(rs);
    }

    
    
}
