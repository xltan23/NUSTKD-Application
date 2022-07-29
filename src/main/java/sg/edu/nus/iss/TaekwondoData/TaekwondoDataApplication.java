package sg.edu.nus.iss.TaekwondoData;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.iss.TaekwondoData.services.StudentService;

@SpringBootApplication
public class TaekwondoDataApplication implements ApplicationRunner {

	@Autowired
	StudentService stuSvc;
	public static void main(String[] args) {
		SpringApplication.run(TaekwondoDataApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		if (args.containsOption("dataDir")) {
			final String dataDir = args.getOptionValues("dataDir").get(0);
			stuSvc.setDataDir(new File(dataDir));

			if (!stuSvc.isDataDirValid()) {
				System.err.printf("%s does not exist, is not a directory or not writable");
				System.exit(-1);
			}
			System.out.printf("Using %s as data directory\n", dataDir);
		} else {
			stuSvc.setDataDir(new File("C:/nustkd"));
		}
	}

}
