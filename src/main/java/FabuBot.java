import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.*;
import java.util.Scanner;

public class FabuBot extends TelegramLongPollingBot {

    boolean vacio = false;
    int n = 1;
    boolean borrado = false;
    int nChistes = 1;

    public void onUpdateReceived(Update update) {

        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getFirstName());

        String recogWord = update.getMessage().getText();
        String caeGroudon = "cae groudon";
        SendMessage message = new SendMessage();
        SendPhoto photo = new SendPhoto();
        String dameX = update.getMessage().getText();
        int resultadoPpt = (int) (Math.random() * 3) + 1;


        boolean isMessage = false;
        boolean isPhoto = false;

        if(recogWord.equalsIgnoreCase("/aggron")){
            message.setText("Triturar de inmediato");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("en qué piensas fabubot")){
            message.setText(" ▒▒▒▒▒▒▒▒▄▄▄▄▄▄▄▄▒▒▒▒▒▒▒ \n" +
                    "▒▒▒▒▒▄█▀▀░░░░░░▀▀█▄▒▒▒▒ \n" +
                    "▒▒▒▄█▀▄██▄░░░░░░░░▀█▄▒▒ \n" +
                    "▒▒█▀░▀░░▄▀░░░░▄▀▀▀▀░▀█▒ \n" +
                    "▒█▀░░░░███░░░░▄█▄░░░░▀█ \n" +
                    "▒█░░░░░░▀░░░░░▀█▀░░░░░█ \n" +
                    "▒█░░░░░░░░░░░░░░░░░░░░█ \n" +
                    "▒█░░██▄░░▀▀▀▀▄▄░░░░░░░█ \n" +
                    "▒▀█░█░█░░░▄▄▄▄▄░░░░░░█▀ \n" +
                    "▒▒▀█▀░▀▀▀▀░▄▄▄▀░░░░▄█▀▒ \n" +
                    "▒▒▒█░░░░░░▀█░░░░░▄█▀▒▒▒ \n" +
                    "▒▒▒█▄░░░░░▀█▄▄▄█▀▀▒▒▒▒▒ \n" +
                    "▒▒▒▒▀▀▀▀▀▀▀▒▒▒▒▒▒▒▒▒▒▒▒");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("mejores atacantes")){
            photo.setPhoto("https://i.imgur.com/V4PyIVK.png");
            isPhoto = true;
            message.setText("El orden puede variar dependiendo de la situación.");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("mejores defensores")){
            message.setText("Siempre Blissey");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains(caeGroudon)){
            message.setText("Entre 3 si hay counters al 35+\n" +
                    "Entre 4 si hay counters al 30+\nEntre 5 con counters al 20+\n" +
                    "Entre 21 si alguno de vosotros usa Aggron\nPreferible siempre que haya amistad " +
                    "y clima a favor");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("counters para groudon")){
            message.setText("En clima neutro y a lvl 30 son (en este orden): \nGyarados, Mewtwo " +
                    "(rayo hielo), Kyogre, Roserade," +
                    "Venusaur (CD), Feraligatr. Sceptile, Weavile, Palkia, Exeggutor Al, Glaceon, Mamoswine.\n" +
                    "Con clima soleado los de planta pasan a primer puesto.");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("cae una t4")){
            message.setText("Para hacer una T4 actualmente hacen falta un mínimo de 2 personas. Raids como " +
                    "Tyranitar o Absol son relativamente fáciles siendo necesarios sólo amistad y Machamps " +
                    "al 30+. \nPara otras como Marowak alola 2 personas requieren de un equipo de Kyogres / Gengar " +
                    "/ Giratina Origen al 40, amistad y clima si es posible. 3 / 4 personas si es posible para asegurar en esos casos.");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("cae una t2")){
            message.setText("Las T2 las puedes hacer fácilmente sólo. Usa Pokémon que le hagan daño supereficaz y puedes tirarlo con cualquier equipo.");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("cae una t1")){
            message.setText("Las T1 las puedes hacer fácilmente sólo. Usa Pokémon que le hagan daño supereficaz y puedes tirarlo con cualquier equipo.");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("cae una t3")){
            message.setText("Todas las T3 son posibles en solitario. Algunas de ellas como Porygon, Raichu, Sharpedo o Scyther no requiere mucho equipo, pero " +
                    "siempre es importante tener los counters necesarios para ellos. \nRaids como Claydol, Donphan, Flareon o Jolteon requieren un equipo algo " +
                    "mejor, con counters al 35+ para asegurar. El único T3 que no se puede solear hasta el momento es Shuckle.");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("empieza el community")){
            message.setText("El CD es de 16:00 a 19:00");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("empieza el cd")){
            message.setText("El CD es de 16:00 a 19:00");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("empieza el dia de la comunidad")){
            message.setText("El CD es de 16:00 a 19:00");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("hora es el cd")){
            message.setText("El CD es de 16:00 a 19:00");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("hora es el commmunity")){
            message.setText("El CD es de 16:00 a 19:00");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("hora es el dia de la comunidad")){
            message.setText("El CD es de 16:00 a 19:00");
            isMessage = true;
            
        }

        else if(recogWord.toLowerCase().contains("lista de comandos")){
            message.setText("Mis comandos disponibles son:\n" +
                    "- Mejores atacantes\n" +
                    "- Mejores defensores\n" +
                    "- Cómo funcionan los IV?\n" +
                    "- A qué hora empieza el CD\n" +
                    "- Con cuántos cae Groudon?\n" +
                    "- Counters para Groudon\n" +
                    "- Con cuántos cae Deoxys velocidad?\n" +
                    "- Counters para Deoxys velocidad\n" +
                    "- Coste de polvos y caramelos\n" +
                    "- Cómo funcionan los lucky\n" +
                    "- Entre cuántos cae una T1\n" +
                    "- Entre cuántos cae una T2\n" +
                    "- Entre cuántos cae una T3\n" +
                    "- Entre cuántos cae una T4\n" +
                    "- Qué hace daño a xxxxx (siendo xxxxx un tipo cualquiera)\n" +
                    "\n" +
                    "- Páginas de utilidad\n" +
                    "Se irán actualizando");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("comandos chorra")){
            message.setText("\uD83D\uDD30 Piedra papel y tijeras\n" +
                            "\uD83D\uDD30 Cuenta chistes\n" +
                            "\uD83D\uDD30 Dame n X (siendo n un número entre 1 y 500\n" +
                            "\uD83D\uDD30 En qué piensas fabubot?\n" +
                            "\uD83D\uDD30 Aggron\n" +
                            "\uD83D\uDD30 Añadir Poke:\n" +
                            "\uD83D\uDD30 Eliminar Poke:\n" +
                            "\uD83D\uDD30 Muestra lista poke:\n" +
                            "\uD83D\uDD30 Fabubot malo");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("aggron")){

            writer("Counter.txt");

            message.setText("Triturado " + reader("Counter.txt") + " veces.");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("páginas de utilidad")){
            message.setText("https://pokemon.gameinfo.io/ - Para saber todas las estadísticas de los Pokémon\n" +
                    "https://www.pokebattler.com/raids - Para hacer simulaciones de raids\n" +
                    "https://www.reddit.com/r/TheSilphRoad/ - La información más verídica que podrás encontrar y la fuente de todos los estudios.\n" +
                    "http://pvpoke.com/ - Simulador de PVP y mejores rankings\n" +
                    "https://gostadium.club/pvp/iv -  Calculador de IV para PVP");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("funcionan los iv")){
            message.setText("IV significa Valores Individuales (Individual Values)," +
                    " y son una mecánica que funciona como los genes de un Pokémon." +
                    " Los IV tienen 3 categorías en Pokémon GO, al igual que las estadísticas " +
                    "base, Ataque, Defensa y Salud. Pueden variar entre 0 y 15 cada estadística," +
                    " por lo que hay 16 posibilidades distintas por cada estadística y un total de" +
                    " 4096 combinaciones de IV. \n\nLa funcionalidad de los IV no es más que una" +
                    " mera suma de esos valores que sacas con calculadoras como Calcy IV o Pokegenie" +
                    " a la estadística base de un Pokémon. \n\nPor poner un ejemplo, si el Pokémon" +
                    " tiene 100 de Ataque, 100 de Defensa y 100 de Salud y ves que sus IV son 15/15/15 " +
                    "sus estadísticas totales pasan a ser 115 de Ataque, 115 de Defensa y 115 en Salud." +
                    " En general, tanto por potencia del Pokémon y por coleccionismo, para raids y" +
                    " gimnasios suele interesar el 100% de IV (15/15/15) pero en casos como el PVP " +
                    "y sus 2 ligas con límite de PC el IV idóneo ronda el 0/15/15 (variando por cada especie).");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("cae deoxys velocidad")){
            message.setText("Entre 2 si hay amistad 4, Gengars/Giratina Origen y clima a favor \n" +
                    "Entre 3 si hay counters al 35+ \n" +
                    "Entre 3 si hay muy buenos counters al 30+ con amistad \n" +
                    "Entre 4 si hay counters al 25+ / 20+ \n" +
                    "\n" +
                    "Preferible siempre que haya amistad y clima a favor");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("counters para deoxys velocidad")){
            message.setText("En clima neutro y a lvl 30 son (en este orden): \nGengar (legacy), Giratina Origen, " +
                    "Tyranitar, Weavile, Mewtwo (bola sombra), Banette, Honchkrow, Houndoom, Absol, Pinsir.");
            isMessage = true;
        }


        else if(recogWord.toLowerCase().contains("daño a normal")){
            message.setText("Lucha");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a fuego")){
            message.setText("Agua, Tierra y Roca");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a agua")){
            message.setText("Eléctrico y Planta");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a electrico")){
            message.setText("Tierra");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a eléctrico")){
            message.setText("Tierra");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a planta")){
            message.setText("Fuego, Hielo, Veneno, Volador y Bicho");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a hielo")){
            message.setText("Fuego, Lucha, Roca y Acero");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a lucha")){
            message.setText("Volador, Psíquico y Hada");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a veneno")){
            message.setText("Tierra y Psíquico");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a tierra")){
            message.setText("Agua, Planta y Hielo");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a volador")){
            message.setText("Eléctrico, Hielo y Roca");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a psiquico")){
            message.setText("Bicho, Fantasma y Siniestro");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a psíquico")){
            message.setText("Bicho, Fantasma y Siniestro");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a bicho")){
            message.setText("Fuego, Volador y Roca");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a roca")){
            message.setText("Agua, Planta, Lucha y Tierra");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a fantasma")){
            message.setText("Fantasma y Siniestro");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a dragon")){
            message.setText("Hielo, Dragon y Hada");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a dragón")){
            message.setText("Hielo, Dragon y Hada");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a siniestro")){
            message.setText("Lucha, Bicho y Hada");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a acero")){
            message.setText("Fuego, Lucha y Tierra");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("daño a hada")){
            message.setText("Veneno y Acero");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("fabubot malo")){
        photo.setPhoto("https://i.imgur.com/PjIcTz5.png");
        isPhoto = true;

        }

        else if(recogWord.toLowerCase().contains("/start")){
            message.setText("Buenas! Intentaré ayudarte en la medida de lo posible, para ver " +
                    "mis comandos escribe \"Lista de comandos\" y verás los comandos que tengo " +
                    "disponible. Si prefieres funcionalidades chorras puedes escribir \"Comandos chorra\"");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("piedra") && recogWord.toLowerCase().contains("papel")
                && (recogWord.toLowerCase().contains("tijera") || recogWord.toLowerCase().contains("tijeras"))){
            message.setText("Perfecto! Piedra, papel o tijeras, una, dos y tres!!");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("chiste")){
            nChistes++;
            if(nChistes == 1) {
                photo.setPhoto("https://i.imgur.com/QUULMsz.jpg");
                isPhoto = true;

            }else if(nChistes == 2){
                photo.setPhoto("https://i.imgur.com/FqJjVYL.jpg");
                isPhoto = true;
                message.setText("Quién se ha tirado");
                isMessage = true;

            }else if(nChistes == 3){
                photo.setPhoto("https://i.imgur.com/eRBns9M.jpg");
                isPhoto = true;

            }
            if(nChistes == 3){
                nChistes = 0;
            }

        }

        else if(recogWord.toLowerCase().contains("añadir poke:")){
            message.setText(update.getMessage().getText().substring(update.getMessage().getText().lastIndexOf(":") + 1) + " añadido");
            escribirPokemon(update.getMessage().getText().substring(update.getMessage().getText().lastIndexOf(":") + 1));

            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("eliminar poke:")){
            try {
                eliminaPokemon(update.getMessage().getText().substring(update.getMessage().getText().lastIndexOf(":") + 1));
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(borrado == true) {
                message.setText(update.getMessage().getText().substring(update.getMessage().getText().lastIndexOf(":") + 1) + " eliminado");
            }else{
                message.setText("El Pokémon no está en la lista.");
            }

            borrado = false;

            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("probar variables")){
            n++;
            message.setText(n+"");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("muestra lista poke:")){
            message.setText(readerLista("Intercambios.txt"));

            if(vacio == true){
                message.setText("Lista vacía.");
            }
            isMessage = true;

        }



        else if(recogWord.toLowerCase().contains("funcionan los lucky")){
            photo.setPhoto("https://i.redd.it/shhffsq90uk11.png");
            isPhoto = true;

        }

        else if(recogWord.toLowerCase().contains("polvos y caramelos")){
            photo.setPhoto("https://i.redd.it/he01zzlv48011.png");
            isPhoto = true;

        }

        else if(recogWord.toLowerCase().contains("piedra") && resultadoPpt == 1){
            message.setText("Piedra!! Hemos empatado :/");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("piedra") && resultadoPpt == 2){
            message.setText("Papel!! Has perdido :O");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("piedra") && resultadoPpt == 3){
            message.setText("Tijeras!! Has ganado :(");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("papel") && resultadoPpt == 1){
            message.setText("Piedra!! Has ganado :(");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("papel") && resultadoPpt == 2){
            message.setText("Papel!! Hemos empatado :/");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("papel") && resultadoPpt == 3){
            message.setText("Tijeras!! Has perdido :O");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("tijeras") && resultadoPpt == 1){
            message.setText("Piedra!! Has perdido :O");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("tijeras") && resultadoPpt == 2){
            photo.setPhoto("https://i.imgur.com/gi4VvfK.jpg");
            isPhoto = true;
            message.setText("Papel!! Has ganado :(");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("tijeras") && resultadoPpt == 3){
            message.setText("Tijeras!! Hemos empatado :/");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("tijera") && resultadoPpt == 1){
            message.setText("Piedra!! Has perdido :O");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("tijera") && resultadoPpt == 2){
            photo.setPhoto("https://i.imgur.com/gi4VvfK.jpg");
            isPhoto = true;
            message.setText("Papel!! Has ganado :(");
            isMessage = true;

        } else if(recogWord.toLowerCase().contains("tijera") && resultadoPpt == 3){
            message.setText("Tijeras!! Hemos empatado :/");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("dame") && recogWord.toLowerCase().contains("x")){
            dameX = dameX.replaceAll("\\D+", "");
            int nX = Integer.parseInt(dameX);
            String mandarX = "";
            if (nX < 500){
                for (int i = 0; i < nX; i++) {
                    mandarX += "x";
                }
                message.setText(mandarX);
            }

            isMessage = true;
        }

        /*else if(recogWord.toLowerCase().contains("fabu")){
            message.setText("Espero que hayas dicho algo bueno del todopoderoso Fabuland");
            isMessage = true;
        }*/


        message.setChatId(update.getMessage().getChatId());
        photo.setChatId(update.getMessage().getChatId());
        if(isMessage == true) {
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if(isPhoto == true) {
            try {
                execute(photo);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }



    public String reader(String archivo){

        String ruta = "src/main/java/"+ archivo +"";
        File fichero = new File(ruta);
        String cont = "";
        try {
            Scanner reader = new Scanner(fichero);
            cont = reader.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return cont;

    }

    public String readerLista(String archivo){
        String ruta = "src/main/java/"+ archivo +"";
        File fichero = new File(ruta);
        String lista = "";
        Scanner reader = null;
        int contLineas = 0;
        try {
            reader = new Scanner(fichero);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(reader.hasNextLine()){
            lista += reader.nextLine() + "\n";
            contLineas++;
        }

        if(contLineas == 0){
            vacio = true;
        }else{
            vacio = false;
        }

        return lista;
    }

    public void writer(String archivo) {
        String ruta = "src/main/java/"+ archivo +"";
        File fichero = new File(ruta);
        String cont = "";

        try {
            Scanner reader = new Scanner(fichero);
            cont = reader.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FileWriter writer = null;
        try {
            writer = new FileWriter(ruta, false);
        } catch (IOException e) {
            e.printStackTrace();
        }



        int nTxt = Integer.parseInt(cont) + 1;
        try {
            writer.write(nTxt + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribirPokemon(String texto) {
        String ruta = "src/main/java/Intercambios.txt";

        FileWriter writer = null;
        try {
            writer = new FileWriter(ruta, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.write(texto);
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(texto);

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminaPokemon(String texto) throws IOException{
        File inputFile = new File("src/main/java/Intercambios.txt");
        File tempFile = new File("src/main/java/myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = texto;
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if(!trimmedLine.equals(lineToRemove)) {
                writer.write(currentLine + System.getProperty("line.separator"));
            }else{
                borrado = true;
            }
        }
        writer.close();
        reader.close();
        if(inputFile.delete()){
            System.out.println("borrado");
        }else{
            System.out.println("no borrado");
        }

        File newFile = new File("src/main/java/Intercambios.txt");
        Boolean succesful = tempFile.renameTo(newFile);

    }


    public String getBotUsername() {
        return "FabulandBot";
    }

    public String getBotToken() {
        return "880519089:AAEchLVodgwl6LCQ48OcUKRvqyOlNbwAQBQ";
    }
}
