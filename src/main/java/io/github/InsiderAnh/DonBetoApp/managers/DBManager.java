package io.github.InsiderAnh.DonBetoApp.managers;

import io.github.InsiderAnh.DonBetoApp.MainApp;
import io.github.InsiderAnh.backendapi.client.IDBClient;
import io.github.InsiderAnh.backendapi.client.impl.DBClient;
import io.github.InsiderAnh.backendapi.client.settings.ClientConfig;
import lombok.Getter;

@Getter
public class DBManager {
	
	private MainApp mainApp = MainApp.getInstance();
	private IDBClient dbClient;
	
	public void load() {
	   this.dbClient = new DBClient(
            new ClientConfig()
                .host("154.53.40.112")
                .port(2500)
                .jwt("none")
        );
	   
       	try {
    	   this.dbClient.connect();
    	   System.out.print("Connected API correctly.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}