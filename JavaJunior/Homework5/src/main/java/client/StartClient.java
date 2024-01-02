package client;

import java.util.Scanner;

public class StartClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите свое имя: ");
        Client client = new Client(scanner.nextLine());
        client.sendMesasge();
        scanner.close();
    }
}
