package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
	    SomeBean someBean = new SomeBean("value1", "value2", "value3");
	    return applyFiltering(someBean, "field1", "field3");
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {
	    SomeBean someBean = new SomeBean("value1", "value2", "value3");
	    SomeBean someBean2 = new SomeBean("value4", "value5", "value6");
	    List<SomeBean> someBeans = Arrays.asList(someBean, someBean2);
	    
	    return applyFiltering(someBeans, "field2", "field3");
	}
	
	private MappingJacksonValue applyFiltering(Object value, String... fields) {
	    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(value);
	    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
	    FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
	    mappingJacksonValue.setFilters(filters);
	    return mappingJacksonValue;
	}
}
