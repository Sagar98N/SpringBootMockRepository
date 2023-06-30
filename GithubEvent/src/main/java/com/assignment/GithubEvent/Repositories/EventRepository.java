package com.assignment.GithubEvent.Repositories;

import com.assignment.GithubEvent.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    public List<Event> findByRepoIdOrderByIdAsc(int repoId);

}
