package javatips.fsabino.patterns_of_design.structural.bridge;

public class Main {
    public  static void main (String[] args) {
        Movie m = new Movie();
        m.setClassification("Es la primera");
        m.setTitle("Limitles");
        m.setYear("2014");
        m.setRuntime("Nada de runtime");

        Formatter f = new PrintFormatter();
        Printer p = new MoviePrinter(m);
        String mensaje = p.format(f);

        System.out.println(mensaje);
    }
}
