package dev.alazar.app;

import org.apache.log4j.Logger;

import dev.alazar.controllers.AccountController;
import dev.alazar.controllers.ClientController;
import dev.alazar.repositories.AccountDao;
import dev.alazar.repositories.AccountRepoDBImpl;
import dev.alazar.repositories.ClientDao;
import dev.alazar.repositories.ClientRepoDBImpl;
import dev.alazar.services.AccountService;
import dev.alazar.services.AccountServiceImpl;
import dev.alazar.services.ClientService;
import dev.alazar.services.ClientServiceImpl;
import io.javalin.Javalin;

public class App {

	static final Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {

		// Establish Javalin object
		Javalin app = Javalin.create();
		log.info("Javalin Created");

		// Establish the Routes/Endpoints Javalin will manage
		establishRoutes(app);

		// Run Javalin
		app.start(7000);

		log.info("Javalin Started");
	}

	private static void establishRoutes(Javalin app) {

		// Going to define a list of routes/endpoints Javalin will manage
		ClientDao cd = new ClientRepoDBImpl();
		ClientService cs = new ClientServiceImpl(cd);
		ClientController cc = new ClientController(cs);

		AccountDao ad = new AccountRepoDBImpl();
		AccountService as = new AccountServiceImpl(ad);
		AccountController ac = new AccountController(as);

		// Establish a route to the 'landing' page
		app.get("/", (ctx) -> ctx.result("This is Our Banking App Home Page!"));

		// Establish routes to every possibility
		app.get("/clients", cc.getAllClients);
		app.get("/clients/:id", cc.getClientById);

		app.get("clients/:id/accounts", ac.getAllAccounts);
		app.get("/clients/:id/accounts/:aId", ac.getAccountById);

		app.post("/clients", cc.createClient);

		app.post("/clients/:id/accounts", ac.createAccount);

		app.put("/clients/:id", cc.updateClient);

		app.put("/clients/:id/accounts/:aId", ac.updateAccount);

		app.delete("/clients/:id", cc.deleteClient);

		app.delete("/clients/:id/accounts/:id", ac.deleteAccount);

		app.patch("/clients/:id/accounts/:id", ac.withdrawOrDeposit);

		app.patch("/clients/:id/accounts/:id/transfer/:id", ac.transfer);
	}
}
