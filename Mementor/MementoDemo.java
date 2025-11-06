public class MementoDemo {
    public static void main(String args[]) {
        Historial pm = new Historial();
        Desarrollador juan = new Desarrollador("Juan", pm);
        Tester ana = new Tester("Ana", pm);
        Gerente luis = new Gerente("Luis", pm);

        pm.registrar(juan, ana, luis);

        juan.enviar("Listo el módulo de login, por favor probar.");
        ana.enviar("Bug encontrado en validación.");
        luis.enviar("Revisión de sprint mañana a las 9am.");
    }
}
