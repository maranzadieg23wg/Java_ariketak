public class Main {
    public static void main(String[] args) {
        // Crear un objeto Ikastaroak
        Ikastaroak ikastaroak = new Ikastaroak();

        // Crear 5 ejemplos de empleados (Langile) con apellidos vascos
        Langile langile1 = new Langile("11111111A", "Manex", "Etxeberria", 123456789, 987654321, "manex@example.com", 1990);
        Langile langile2 = new Langile("22222222B", "Leire", "Zubizarreta", 234567890, 876543210, "leire@example.com", 1985);
        Langile langile3 = new Langile("33333333C", "Janire", "Urrutia", 345678901, 765432109, "janire@example.com", 1988);
        Langile langile4 = new Langile("44444444D", "Ane", "Gonzalez", 456789012, 654321098, "ane@example.com", 1995);
        Langile langile5 = new Langile("55555555E", "Iker", "Larrinaga", 567890123, 543210987, "iker@example.com", 1983);

        // Añadir cursos a los empleados con los nuevos nombres de curso y estados
        langile1.gehituIkastaroa(1, "ikastaro1", 2023, 2024, "ganditua");
        langile1.gehituIkastaroa(2, "ikastaro2", 2023, 2024, "ez gainditua");
        langile2.gehituIkastaroa(2, "ikastaro2", 2023, 2024, "ez gainditua");
        langile3.gehituIkastaroa(3, "ikastaro3", 2023, 2024, "egiten");
        langile4.gehituIkastaroa(1, "ikastaro1", 2023, 2024, "ganditua");
        langile5.gehituIkastaroa(4, "ikastaro4", 2023, 2024, "egiten");

        // Mostrar información de empleados y sus cursos
        langile1.datuakErakutsi();
        langile1.ikusiIkastaroak();
        System.out.println("-----------------------------------");
        langile2.datuakErakutsi();
        langile2.ikusiIkastaroak();
        System.out.println("-----------------------------------");
        langile3.datuakErakutsi();
        langile3.ikusiIkastaroak();
        System.out.println("-----------------------------------");
        langile4.datuakErakutsi();
        langile4.ikusiIkastaroak();
        System.out.println("-----------------------------------");
        langile5.datuakErakutsi();
        langile5.ikusiIkastaroak();

        // Cambiar datos de un empleado y añadir/borrar cursos
        langile1.datuakAldatu("11111111B", "Manexa", "Etxeberria", 123456789, 987654321, "manex@example.com", 1990);
        langile1.gehituIkastaroa(5, "ikastaro5", 2023, 2024, "egiten");
        langile1.kenduIkastaroa(1);

        System.out.println("-----------------------------------");
        langile1.datuakErakutsi();
        langile1.ikusiIkastaroak();

        System.out.println("-----------------------------------");
        ikastaroak.ikastaroEgoera("11111111B",5);

    }
}
