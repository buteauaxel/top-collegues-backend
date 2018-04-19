/**
 * 
 */
package com.collegues.web.listener;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.collegues.entity.Collegue;

/**
 * @author Axel B.
 *
 */
@Component
public class StartUpAppListener {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {

		List<Collegue> listeCollegue = new ArrayList<Collegue>();
		listeCollegue.add(new Collegue(
				"https://gaiasphere.fr/wordpress/wp-content/uploads/2007/12/paresseux-400x200.jpg", "Paresseux"));
		listeCollegue.add(new Collegue("https://www.quizz.biz/uploads/quizz/1085957/5_C27MX.jpg", "Mandrill"));
		listeCollegue
				.add(new Collegue("http://fr.web.img6.acsta.net/c_400_200/newsv7/17/05/16/10/59/480832.jpg", "César"));
		listeCollegue
				.add(new Collegue("https://jesavaispas.com/wp-content/uploads/2016/03/Koala-400x200.jpg", "Koala"));
		listeCollegue.add(new Collegue("https://dkm-tv.com/wp-content/uploads/2015/04/bonobo-400x200.jpg", "Emmanuel"));
		listeCollegue.add(new Collegue(
				"https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F29582080%2F144893382253%2F1%2Foriginal.jpg?h=200&w=450&rect=0%2C49%2C2048%2C1024&s=94fe34b3820a5787d978c83988785dd8",
				"Capucin"));

		listeCollegue.forEach(em::persist);

	}

}
