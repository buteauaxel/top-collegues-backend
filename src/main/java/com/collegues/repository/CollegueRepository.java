/**
 * 
 */
package com.collegues.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegues.entity.Collegue;

/**
 * @author Axel B.
 *
 */
public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	Boolean existsByPseudo(String pseudo);

	Collegue findCollegueByPseudo(String pseudo);
}
