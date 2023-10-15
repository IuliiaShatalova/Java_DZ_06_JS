import java.util.*;
//Расчитано на понятливого пользователя)

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> clientParams = new HashMap<>(5);
        Set <Notebook> notebooks = new HashSet<>();
        createSet(notebooks);
        printAll(notebooks);
        fillClientParams(clientParams);
        System.out.println("Ноутбуки соответствующие Вашим параметрам: ");
        findTheNotebook(notebooks,clientParams);
    }

//Генерирует и собирает ноутбуки в сет
    static void createSet(Set<Notebook> notebooks){
        for (int i = 0; i < 10; i++) {
            Notebook notebook = generateNotebook();
            notebooks.add(notebook);
        }
    }

//Метод генерации случайных параметров
    static Notebook generateNotebook(){
        Map<Integer, String> brandParam = Map.of(
            1, "Asus",
            2, "Apple",
            3, "Hp"
        );
        Map<Integer, String> yearParam = Map.of(
                1, "2021",
                2, "2022",
                3, "2023"
        );
        Map<Integer, String>  colorParam = Map.of(
                1, "black",
                2, "white",
                3, "grey"
        );
        Map<Integer, String>  systemParam = Map.of(
                1, "iOS",
                2, "Windows",
                3, "Linux"
        );
        Map<Integer, String> RAMParam = Map.of(
                1, "6",
                2, "8",
                3, "12"
        );
        Map<Integer, String> SSDParam = Map.of(
                1, "256",
                2, "512",
                3, "1000"
        );
        Random random = new Random();
        Notebook notebook = new Notebook();

        notebook.brand = brandParam.get(random.nextInt(1,brandParam.size()+1));
        notebook.year = yearParam.get(random.nextInt(1,yearParam.size()+1));
        notebook.color = colorParam.get(random.nextInt(1,colorParam.size()+1));
        notebook.system = systemParam.get(random.nextInt(1, systemParam.size()+1));
        notebook.RAM = RAMParam.get(random.nextInt(1,RAMParam.size()+1));
        notebook.SSD = SSDParam.get(random.nextInt(1, SSDParam.size()+1));

        return notebook;
    }

    static void printAll(Set<Notebook> notebooks){
        for (Notebook notebook: notebooks) {
            System.out.println(notebook);
        }
    }

//Сбор параметров от пользователя
    static void fillClientParams(Map<Integer, String> clientParams) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            System.out.println("Выберете параметры:" + "\n" + "1 - ОЗУ" + "\n" + "2 - Объем ЖД" +
                    "\n" + "3 - Операционная система" + "\n" + "4 - Цвет" + "\n" + "5 - Принять");
            int menuNum = scanner.nextInt();
            if (menuNum < 1 || menuNum > 5){
                System.out.println("Неверное значение.");
                break;
            }
            else {
                if (menuNum == 1) {
                    System.out.println("Выберете нужное значение ОЗУ: " + "\n" + "6" + "\n" + "8" + "\n" + "12");
                    String clientRAM = scanner.next();
                    if (clientRAM.equals("6") || clientRAM.equals("8") || clientRAM.equals("12")) {
                        clientParams.put(menuNum, clientRAM);
                    } else System.out.println("Неверное значение.");
                }
                if (menuNum == 2) {
                    System.out.println("Выберете нужное значение ЖД: " + "\n" + "256" + "\n" + "512" + "\n" + "1000");
                    String clientSSD = scanner.next();
                    if (clientSSD.equals("256") || clientSSD.equals("512") || clientSSD.equals("1000")) {
                        clientParams.put(menuNum, clientSSD);
                    } else System.out.println("Неверное значение.");
                }
                if (menuNum == 3) {
                    System.out.println("Выберете нужную ОС: " + "\n" + "iOS" + "\n" + "Windows" + "\n" + "Linux");
                    String clientSystem = scanner.next();
                    if (clientSystem.equals("iOS") || clientSystem.equals("Windows") || clientSystem.equals("Linux")) {
                        clientParams.put(menuNum, clientSystem);
                    } else System.out.println("Неверное значение.");
                }
                if (menuNum == 4) {
                    System.out.println("Выберете нужный цвет: " + "\n" + "black" + "\n" + "white" + "\n" + "grey");
                    String clientColor = scanner.next();
                    if (clientColor.equals("black") || clientColor.equals("white") || clientColor.equals("grey")) {
                        clientParams.put(menuNum, clientColor);
                    } else System.out.println("Неверное значение.");
                }
                if (menuNum == 5) break;
            }
        }
        System.out.println(clientParams);
    }

//Поиск ноутбука по параметрам
    static void findTheNotebook(Set<Notebook> notebooks, Map<Integer, String> clientParams){
        for (Map.Entry<Integer, String> entry:clientParams.entrySet()) {
            for (Notebook notebook : notebooks) {
                if ((!clientParams.containsKey(1) || clientParams.get(1).equals(notebook.RAM)) &&
                        (!clientParams.containsKey(2) || clientParams.get(2).equals(notebook.SSD)) &&
                        (!clientParams.containsKey(3) || clientParams.get(3).equals(notebook.system)) &&
                        (!clientParams.containsKey(4) || clientParams.get(4).equals(notebook.color))){
                    System.out.println(notebook);
                }
            }
        }
    }
}

