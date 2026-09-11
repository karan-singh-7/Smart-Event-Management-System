package com.nit.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EventPageResponse {

	    private List<EventResponse> content;
	    private int page;
	    private int size;

	    private long totalElements;
	    private int totalPages;

	    private boolean last;
}
