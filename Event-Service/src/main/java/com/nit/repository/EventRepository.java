package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;

import com.nit.entity.Event;

import jakarta.persistence.LockModeType;

public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Event findByEventId(Long eventId);
}
