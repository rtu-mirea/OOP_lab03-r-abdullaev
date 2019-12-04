package com.company;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        VotingSystem votingSystem = new VotingSystem();
        int task = 1;
        String name, login, password, repeatPassword;

        while (task != 0){
            try{
                if (votingSystem.getCurrentUser() == -2){
                    System.out.print("[0] - завершение работы" + '\n' +
                            "[1] - регистрация" + '\n' +
                            "[2] - вход в систему" + '\n' +
                            "Выберите нужный пункт: ");
                }
                if (votingSystem.getCurrentUser() > -1){
                    System.out.print("[0] - завершение работы" + '\n' +
                            "[3] - участие в голосовании" + '\n' +
                            "[6] - выход из системы" + '\n' +
                            "Выберите нужный пункт: ");
                }
                if (votingSystem.getCurrentUser() == -1){
                    System.out.print("[0] - завершение работы" + '\n' +
                            "[4] - добавление кандидата" + '\n' +
                            "[5] - конец голосования" + '\n' +
                            "[6] - выход из системы" + '\n' +
                            "Выберите нужный пункт: ");
                }
                task = in.nextInt();
                if (votingSystem.getCurrentUser() == -2)
                    switch (task) {
                        case 0:
                            System.out.println("Завершение работы(");
                            continue;
                        case 1:
                            in.nextLine();
                            System.out.println("Введите свое имя:");
                            name = in.nextLine();
                            System.out.println("Введите логин:");
                            login = in.nextLine();
                            System.out.println("Введите пароль:");
                            password = in.nextLine();
                            System.out.println("Повторите пароль:");
                            repeatPassword = in.nextLine();
                            votingSystem.addUser(name, login, password, repeatPassword);
                            System.out.println("Регистрация прошла успешно");
                            continue;
                        case 2:
                            in.nextLine();
                            System.out.println("Введите логин:");
                            login = in.nextLine();
                            System.out.println("Введите пароль:");
                            password = in.nextLine();
                            votingSystem.enter(login, password);
                            System.out.println("Вы успешно вошли в систему");
                            continue;
                        default:
                            System.out.println("Вы ввели непредусмотренную комбинацию");
                            continue;
                    }
                if (votingSystem.getCurrentUser() > -1)
                    switch (task) {
                        case 0:
                            System.out.println("Завершение работы(");
                            continue;
                        case 3:
                            votingSystem.giveVoice();
                            System.out.println("Вы успешно проголосавали");
                            continue;
                        case 6:
                            votingSystem.exit();
                            System.out.println("Вы успешно вышли из системы");
                            continue;
                        default:
                            System.out.println("Вы ввели непредусмотренную комбинацию");
                            continue;
                    }
                if (votingSystem.getCurrentUser() == -1)
                    switch (task){
                        case 0:
                            System.out.println("Завершение работы(");
                            continue;
                        case 4:
                            in.nextLine();
                            System.out.println("Ввыкдите имя кондидата:");
                            name = in.nextLine();
                            votingSystem.addCandidate(name);
                            System.out.println("Вы успешно добавили кандидата");
                            continue;
                        case 5:
                            name = votingSystem.getWinner();
                            System.out.println("Голосование завершено, победитель:\n" + name);
                            continue;
                        case 6:
                            votingSystem.exit();
                            System.out.println("Вы успешно вышли из системы");
                            continue;
                        default:
                            System.out.println("Вы ввели непредусмотренную комбинацию");
                            continue;
                    }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
