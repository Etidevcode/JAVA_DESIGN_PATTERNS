package com.etienne;

import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {

		// Création de différents abonnés
		PhoneSubscriber phoneSubscriber = new PhoneSubscriber();
		phoneSubscriber.setSubscriberId(1L);
		phoneSubscriber.setAddress("123 Main St");
		phoneSubscriber.setPhoneNumber(5551234L);
		phoneSubscriber.setBaseRate(10); // 10 cents par minute

		ISPSubscriber ispSubscriber = new ISPSubscriber();
		ispSubscriber.setSubscriberId(2L);
		ispSubscriber.setAddress("456 Oak St");
		ispSubscriber.setPhoneNumber(5555678L);
		ispSubscriber.setBaseRate(5); // 5 cents par MB
		ispSubscriber.setFreeUsage(500); // 500 MB gratuits

		// Ajout de sessions pour les abonnés
		CallHistory.addSession(phoneSubscriber.getSubscriberId(), LocalDateTime.now().minusMinutes(5), 5);
		CallHistory.addSession(phoneSubscriber.getSubscriberId(), LocalDateTime.now().minusMinutes(10), 10);

		InternetSessionHistory.addSession(ispSubscriber.getSubscriberId(), LocalDateTime.now().minusHours(1), 300);
		InternetSessionHistory.addSession(ispSubscriber.getSubscriberId(), LocalDateTime.now().minusHours(2), 400);

		// Calcul des factures
		double phoneBill = phoneSubscriber.calculateBill();
		double ispBill = ispSubscriber.calculateBill();

		// Affichage des factures
		System.out.println("Facture de l'abonné téléphonique : " + phoneBill);
		System.out.println("Facture de l'abonné internet : " + ispBill);
	}
}
