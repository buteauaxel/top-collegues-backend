/**
 * 
 */
package com.collegues.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.collegues.entity.Collegue;
import com.collegues.model.ActionIhm;
import com.collegues.model.AjouterCollegue;
import com.collegues.model.ApiCollegue;
import com.collegues.model.Avis;
import com.collegues.repository.CollegueRepository;

/**
 * @author Axel B.
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/collegues")
public class CollegueController {

	@Autowired
	private CollegueRepository collegueR;

	@GetMapping
	public List<Collegue> listerCollegues() {
		return this.collegueR.findAll();
	}

	@RequestMapping(value = "/{pseudo}", method = RequestMethod.PATCH)
	public Collegue modifNote(@PathVariable String pseudo, @RequestBody ActionIhm action) {
		Collegue c1 = new Collegue();
		if (collegueR.existsByPseudo(pseudo)) {
			c1 = collegueR.findCollegueByPseudo(pseudo);

			if (action.getAction().equals(Avis.AIMER) && c1.getNote() < 1000) {
				c1.setNote(c1.getNote() + 10);
			}
			if (action.getAction().equals(Avis.DETESTER) && c1.getNote() > -1000) {
				Integer note = c1.getNote();
				c1.setNote(note -= 5);
			}
			this.collegueR.save(c1);

		}
		return c1;
	}

	@RequestMapping(value = "/{pseudo}", method = RequestMethod.GET)
	public Collegue find(@PathVariable String pseudo) {
		return collegueR.findCollegueByPseudo(pseudo);
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.POST)
	public void ajouterCollegue(@RequestBody AjouterCollegue collegue) {

		final String uri = "http://collegues-api.cleverapps.io/collegues";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ApiCollegue[]> response = restTemplate.getForEntity(uri, ApiCollegue[].class);
		List<ApiCollegue> list = Arrays.asList(response.getBody());

		Optional<ApiCollegue> chercheCollegue = list.stream().filter((ApiCollegue col) -> {
			return col.getMatricule().equals(collegue.getMatricule());
		}).findFirst();

		// System.out.println(collegue);

		chercheCollegue.ifPresent(c -> {
			Collegue c1 = new Collegue();
			c1.setPseudo(collegue.getPseudo());
			c1.setNote(0);
			c1.setMatricule(collegue.getMatricule());
			c1.setAdresse(c.getAdresse());
			c1.setEmail(c.getEmail());
			c1.setNom(c.getNom());
			c1.setPrenom(c.getPrenom());
			c1.setPhoto(c.getPhoto());
			this.collegueR.save(c1);
		});

	}

}
