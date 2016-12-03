/**
 *
 */
package davidbejar.study.hibernate52;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import davidbejar.study.hibernate52.pojo.PurchasedItem;

/**
 * @author davidbejar
 *
 */
@RestController
@EnableAutoConfiguration
public class Main {

	/**
	 * Home json output
	 * TODO convert to Junit test
	 *
	 * @return
	 */
	@RequestMapping("/")
	List<String> home() {
		try {
			SessionFactory sessionFactory;
			sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			List<String> output =
					session.createQuery("SELECT h FROM PurchasedItem h WHERE price> 50000", PurchasedItem.class)
							.stream().map(PurchasedItem::getDescription).collect(Collectors.toList());
			session.close();
			return output;
		} catch (Exception e) {
			List<String> output = new ArrayList<>();
			output.add(e.getMessage());
			output.add(e.getCause().getMessage());
			return output;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}

}
