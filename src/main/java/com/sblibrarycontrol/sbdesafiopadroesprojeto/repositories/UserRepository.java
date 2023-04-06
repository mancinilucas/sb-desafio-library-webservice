package com.sblibrarycontrol.sbdesafiopadroesprojeto.repositories;

import com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
