package UtsuPWiki;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class UtsuPApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtsuPApplication.class, args);
//		log.info("Application Started!");
//		log.info("\n" +
//				" Воля может и должна быть предметом гордости гораздо больше, нежели талант.\n" +
//				" Если талант — это развитие природных склонностей, \n" +
//				" то твёрдая воля — это ежеминутно одерживаемая победа над инстинктами,\n" +
//				" над влечениями, которые воля обуздывает и подавляет, над препятствиями\n" +
//				" и преградами, которые она осиливает, над всяческими трудностями,\n" +
//				" которые она героически преодолевает. \" (Оноре де Бальзак)");
	}
}
