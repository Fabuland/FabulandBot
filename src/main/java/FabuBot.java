import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.*;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class FabuBot extends TelegramLongPollingBot {

    boolean vacio = false;
    int n = 1;
    boolean borrado = false;
    int nChistes = 1;

    public void onUpdateReceived(Update update) {

        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getFirstName());
        System.out.println(update.getMessage().getChatId());

        String recogWord = update.getMessage().getText();
        SendMessage message = new SendMessage();
        SendPhoto photo = new SendPhoto();
        SendAnimation gif = new SendAnimation();
        String dameX = update.getMessage().getText();
        int resultadoPpt = (int) (Math.random() * 3) + 1;

        boolean isMessage = false;
        boolean isPhoto = false;
        boolean isGif = false;

        Object[] poleInt = new Object[1];

        /*ResultSet getPole = Conectar.EjecutarSentencia("SELECT * FROM polereset ORDER BY PoleReset");
        try {
            while (getPole.next()) {

            poleInt[0] = getPole.getInt("polereset");
            System.out.println("funciona");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));

        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+2"));

        String horaActual = formatter.format(calendar.getTime());

        String horaString = horaActual.substring(0, Math.min(horaActual.length(), 2));
        int horaInt = Integer.parseInt(horaString);

        if(horaInt == 23){
            actualizarBaseDatos("0");
        }


        /*Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 23);
        today.set(Calendar.MINUTE, 28);
        today.set(Calendar.SECOND, 0);

        int miChatID = 138516197;
        final SendMessage fabu = new SendMessage();
        fabu.setText("xd");
        fabu.setText("lmao");
        fabu.setText("wtf");
        fabu.setChatId(String.valueOf(miChatID));
        Timer t = new Timer();
        TimerTask pole = new TimerTask() {


            public void run() {
                try {
                    execute(fabu);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        };

        t.schedule(pole, today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));*/


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

        /*else if(recogWord.toLowerCase().contains("mudkip")){
            gif.setChatId(update.getMessage().getChatId());
            gif.setAnimation("https://media1.giphy.com/media/BG4rps53LGPzW/giphy.gif");
            isGif = true;
        }*/

        else if(recogWord.toLowerCase().contains("mejores defensores")){
            message.setText("Siempre Blissey");
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
                    "\n" +
                    "\uD83D\uDD30 Mejores atacantes\n" +
                    "\uD83D\uDD30 Mejores defensores\n" +
                    "\uD83D\uDD30 Cómo funcionan los IV?\n" +
                    "\uD83D\uDD30 A qué hora empieza el CD\n" +
                    "\uD83D\uDD30 Con cuántos cae Deoxys velocidad?\n" +
                    "\uD83D\uDD30 Counters para Deoxys velocidad\n" +
                    "\uD83D\uDD30 Coste de polvos y caramelos\n" +
                    "\uD83D\uDD30 Cómo funcionan los lucky\n" +
                    "\uD83D\uDD30 Entre cuántos cae una T1\n" +
                    "\uD83D\uDD30 Entre cuántos cae una T2\n" +
                    "\uD83D\uDD30 Entre cuántos cae una T3\n" +
                    "\uD83D\uDD30 Entre cuántos cae una T4\n" +
                    "\uD83D\uDD30 Qué hace daño a xxxxx (siendo xxxxx un tipo cualquiera)\n" +
                    "\uD83D\uDD30 Páginas de utilidad\n" +
                    " ⚔ Simular pokemon vs pokemon\n" +
                    "\uD83D\uDD30 Cómo funciona la simulación\n" +
                    "\uD83D\uDD30 Info Poke Pokemon\n" +
                    "\uD83D\uDD30 Simular raid Pokemon Tier Nivel xx Amistad xx Clima xxxxxx\n" +
                    "\uD83D\uDD30 Cómo funciona la simulación de raids\n" +
                    "\uD83D\uDD30 Rank **liga** Pokemon ivAtaque ivDefensa ivStamina\n" +
                    "\uD83D\uDD30 Mejor IV **liga** Pokemon\n" +
                    "\n" +
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
                            "\uD83D\uDD30 Fabubot malo\n" +
                            "\uD83D\uDD30 Fabubot mata a -----\n" +
                            "\uD83D\uDD30 Hola Fabubot!\n" +
                            "\uD83D\uDD30 uwu\n" +
                            "\uD83D\uDD30 FabuHora\n" +
                            "\uD83D\uDD30 FabuPole (a partir de las 7:00 y 16:00)\n" +
                            "\uD83D\uDD30 Multiplica: 3 x 2");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("aggron")){

            writerSuma("Counter.txt");

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

        else if(recogWord.toLowerCase().contains("fabubot mata a ")){
            String mensaje = update.getMessage().getText();
            int ind1 = mensaje.indexOf(' ');
            int ind2 = mensaje.indexOf(' ', ind1 + 1);
            int ind3 = mensaje.indexOf(' ', ind2 + 1);
            String nombreP = mensaje.substring(ind3).trim();

            message.setText("(⌐ ͡■ ͜ʖ ͡■) ︻╦̵══╤─  " + nombreP);
            isMessage = true;

        }

        /*else if(recogWord.toLowerCase().contains("lapras")){

            message.setText("─────────────────███▓\n" +
                            "─────████───────█────▓\n" +
                            "───██░───██────█░░────▓\n" +
                            "──█░───────█───█░░░░──▓\n" +
                            "──█░░─░─────███████░░░─▓\n" +
                            "─█░░░░██────█──────██░░▓\n" +
                            "─█░░░█░░█───▓────────█░▓██\n" +
                            "─█░░░░░░░█────────────██──█\n" +
                            "──█░░░░░░█───────────░░───█\n" +
                            "──█░░░░░░█░──────────────█\n" +
                            "───██░░░█░░░──────────░─░█\n" +
                            "─────███░░░░░▓██░░▒────░░█\n" +
                            "──────█░░░░░────█░░▒──────▓\n" +
                            "──────█░░▓░░───▒─█░▒──────▓\n" +
                            "──────█░▓▓░░░░─█▒█░▒──────▓\n" +
                            "──────█░▓░░░░░░▓███────────▓\n" +
                            "──────█░░░░▒█░░░░░░░░─────░█\n" +
                            "───────█░░▒▒▒█░░░░░░░░░░░░░█\n" +
                            "───────█░░▒▒▒▒▓░░░░░░░░░░░░█\n" +
                            "───────█░░▒▒▒▒▒██░░░░░░░▓░░█\n" +
                            "────────█░▒▒▓▒▒▒▒███▓▓░░░░█\n" +
                            "────────█░░▒▒▓▓▒▒▒▒▒▒▒▓▓░░█\n" +
                            "────────█░░▒▒▒▒▓▓██████─██\n" +
                            "────────█░░▒▒▒▒▒▒█");
            isMessage = true;

        }*/

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

        else if(recogWord.toLowerCase().contains("día de Entei")){
            message.setText("El 14 de Julio, Domingo de 16:00 a 19:00");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("dia de Entei")){
            message.setText("El 14 de Julio, Domingo de 16:00 a 19:00");
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

        else if(recogWord.toLowerCase().contains("multiplica:") && recogWord.toLowerCase().contains("x")){
            String mensaje = update.getMessage().getText();
            int ind1 = mensaje.indexOf(' ');
            int ind2 = mensaje.indexOf(' ', ind1 + 1);
            int ind3 = mensaje.indexOf(' ', ind2 + 1);

            String num1text = mensaje.substring(ind1, ind2).trim().toLowerCase();
            String num2text = mensaje.substring(ind3).trim().toLowerCase();
            int num1, num2;
            if (isNumeric(num1text) && (isNumeric(num2text))) {
                num1 = Integer.parseInt(num1text);
                num2 = Integer.parseInt(num2text);
                int resultado = num1*num2;
                if(num2 == 5){
                    message.setText("Por el culo te la hinco");
                }else{
                    message.setText(resultado+"");
                }
            }else{
                message.setText("Introduce 2 números, por favor");
            }




            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("simular") && recogWord.toLowerCase().contains("vs")){
            String mensaje = update.getMessage().getText();
            int ind1 = mensaje.indexOf(' ');
            int ind2 = mensaje.indexOf(' ', ind1 + 1);
            int ind3 = mensaje.indexOf(' ', ind2 + 1);
            int ind4 = mensaje.indexOf(' ', ind3 + 1);
            int ind5 = mensaje.indexOf(' ', ind4 + 1);
            int ind6 = mensaje.indexOf(' ', ind5 + 1);

            String ligaPoke = mensaje.substring(ind1, ind2).trim().toLowerCase();
            String ligaTrad = "";
            if(ligaPoke.equals("super") || ligaPoke.equals("súper")){
                ligaTrad = "1500";
            }else if (ligaPoke.equals("ultra")){
                ligaTrad = "2500";
            }else if(ligaPoke.equals("master")){
                ligaTrad = "10000";
            }
            String primerPoke = mensaje.substring(ind2, ind3).trim().toLowerCase();
            String segundoPoke = mensaje.substring(ind4, ind5).trim().toLowerCase();
            String primerEscudo = mensaje.substring(ind5, ind6).trim();
            String segundoEscudo = mensaje.substring(ind6).trim();

            message.setText("https://pvpoke.com/battle/"+ ligaTrad +"/"+ primerPoke +"/"+ segundoPoke +"/"+ primerEscudo +""+ segundoEscudo +"/");

            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("rank") && (recogWord.toLowerCase().contains("super") || recogWord.toLowerCase().contains("súper") || recogWord.toLowerCase().contains("ultra") || recogWord.toLowerCase().contains("master"))){
           /* String mensaje = update.getMessage().getText();
            int ind1 = mensaje.indexOf(' ');
            int ind2 = mensaje.indexOf(' ', ind1 + 1);
            int ind3 = mensaje.indexOf(' ', ind2 + 1);
            int ind4 = mensaje.indexOf(' ', ind3 + 1);
            int ind5 = mensaje.indexOf(' ', ind4 + 1);
            String ligaPoke = mensaje.substring(ind1, ind2).trim().toLowerCase();
            String ligaTrad = "";
            if(ligaPoke.equals("super") || ligaPoke.equals("súper")){
                ligaTrad = "1500";
            }else if (ligaPoke.equals("ultra")){
                ligaTrad = "2500";
            }else if(ligaPoke.equals("master")){
                ligaTrad = "9001";
            }

            String pokeRank = mensaje.substring(ind2, ind3).trim().toLowerCase();
            String ivAt = mensaje.substring(ind3, ind4).trim().toLowerCase();
            String ivDef = mensaje.substring(ind4, ind5).trim().toLowerCase();
            String ivSta = mensaje.substring(ind5).trim().toLowerCase();
            String rangoPoke = "";
            try {
                Document doc = Jsoup.connect("https://gostadium.club/pvp/iv?pokemon="+ pokeRank +"&max_cp="+ ligaTrad +"&min_iv=0&att_iv="+ivAt+"&def_iv="+ivDef+"&sta_iv="+ivSta+"").userAgent("mozilla/17.0").get();
                Elements temp = doc.select("div.well");
                int i = 0;
                for(Element rankIV:temp){
                    i++;
                    rangoPoke = rankIV.getElementsByTag("b").first().text();
                }
                System.out.println(rangoPoke);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            message.setText("⚔ RIP Rankings ⚔");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("mejor iv") && (recogWord.toLowerCase().contains("super") || recogWord.toLowerCase().contains("súper") || recogWord.toLowerCase().contains("ultra") || recogWord.toLowerCase().contains("master"))){
           /* String mensaje = update.getMessage().getText();
            int ind1 = mensaje.indexOf(' ');
            int ind2 = mensaje.indexOf(' ', ind1 + 1);
            int ind3 = mensaje.indexOf(' ', ind2 + 1);
            int ind4 = mensaje.indexOf(' ', ind3 + 1);
            String ligaPoke = mensaje.substring(ind2, ind3).trim().toLowerCase();
            String ligaTrad = "";
            if(ligaPoke.equals("super") || ligaPoke.equals("súper")){
                ligaTrad = "1500";
            }else if (ligaPoke.equals("ultra")){
                ligaTrad = "2500";
            }else if(ligaPoke.equals("master")){
                ligaTrad = "9001";
            }
            String pokeRank = mensaje.substring(ind3).trim().toLowerCase();
            String rangoPoke = "";
            try {
                Document doc = Jsoup.connect("https://gostadium.club/pvp/iv?pokemon="+ pokeRank +"&max_cp="+ ligaTrad+"").userAgent("mozilla/17.0").get();
                Elements temp = doc.select("div.well");
                int i = 0;
                for(Element rankIV:temp){
                    i++;
                    rangoPoke = rankIV.getElementsByTag("td").text();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] rangoArray = rangoPoke.split(" ");*/
            message.setText("⚔ RIP Rankings ⚔");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("info") && recogWord.toLowerCase().contains("poke")){
            String mensaje = update.getMessage().getText();
            int ind1 = mensaje.indexOf(' ');
            int ind2 = mensaje.indexOf(' ', ind1 + 1);
            int ind3 = mensaje.indexOf(' ', ind2 + 1);
            String infoPoke = mensaje.substring(ind2).trim().toLowerCase();

            message.setText("https://pokemon.gameinfo.io/es/pokemon/"+ infoPoke +"");

            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("simular") && recogWord.toLowerCase().contains("raid") && recogWord.toLowerCase().contains("nivel") && recogWord.toLowerCase().contains("amistad")
                && recogWord.toLowerCase().contains("clima")){
            String mensaje = update.getMessage().getText();
            int ind1 = mensaje.indexOf(' ');
            int ind2 = mensaje.indexOf(' ', ind1 + 1);
            int ind3 = mensaje.indexOf(' ', ind2 + 1);
            int ind4 = mensaje.indexOf(' ', ind3 + 1);
            int ind5 = mensaje.indexOf(' ', ind4 + 1);
            int ind6 = mensaje.indexOf(' ', ind5 + 1);
            int ind7 = mensaje.indexOf(' ', ind6 + 1);
            int ind8 = mensaje.indexOf(' ', ind7 + 1);
            int ind9 = mensaje.indexOf(' ', ind8 + 1);

            String simulPoke = mensaje.substring(ind2, ind3).trim().toUpperCase();
            String tierPoke = mensaje.substring(ind3, ind4).trim();
            String nivelPoke = mensaje.substring(ind5, ind6).trim();
            String amistadPoke = mensaje.substring(ind7, ind8).trim();
            String climaPoke = mensaje.substring(ind9).trim().toLowerCase();
            String climaIngles = "";

            if(climaPoke.equals("neutro")){
                climaIngles = "NO_WEATHER";
            }else if(climaPoke.equals("soleado")){
                climaIngles = "CLEAR";
            }else if(climaPoke.equals("lluvioso")){
                climaIngles = "RAINY";
            }else if(climaPoke.equals("parcialmentenublado")){
                climaIngles = "PARTLY_CLOUDY";
            }else if(climaPoke.equals("nublado")){
                climaIngles = "OVERCAST";
            }else if(climaPoke.equals("viento")){
                climaIngles = "WINDY";
            }else if(climaPoke.equals("nieve")){
                climaIngles = "SNOW";
            }else if(climaPoke.equals("niebla")){
                climaIngles = "FOG";
            }


            message.setText("https://www.pokebattler.com/raids/defenders/"+simulPoke+"/levels/RAID_LEVEL_"+tierPoke+"/attackers/levels/"+nivelPoke+"/strategies/CINEMATIC_ATTACK_WHEN_POSSIBLE/DEFENSE_RANDOM_MC?sort=TIME&weatherCondition="+climaIngles+"&dodgeStrategy=DODGE_REACTION_TIME&aggregation=AVERAGE&randomAssistants=-1&friendLevel=FRIENDSHIP_LEVEL_"+amistadPoke);

            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("funciona") && recogWord.toLowerCase().contains("raids")){

            message.setText("Para usar el simulador de raids escribe un mensaje parecido a este, pero con los datos que necesites: \n" +
                    "**Simular raid Rayquaza 5 nivel 40 amistad 4 clima neutro**\n" +
                    "Rayquaza --> El Pokémon de raid que quieras simular\n" +
                    "40 --> El nivel de tus Pokémon\n" +
                    "4 --> Nivel de amistad con la gente de la raid\n" +
                    "neutro --> Clima\n" +
                    "Los climas disponibles son: neutro, soleado, lluvioso, parcialmentenublado, nublado, viento, nieve y niebla.");

            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("funciona la simulación")){
            message.setText("Si escribes \"Simular Vigoroth vs Yanma 0 1\" por ejemplo, te mandaré un link a pvpoke.com con la simulación " +
                    "entre esos dos Pokémon, 0 1 es el número de escudos, siendo 0 para Vigoroth y 1 para Yanma.\nSi escribes mal el nombre de un Pokémon " +
                    "o pones más de 2 escudos la página no funcionará, tienes que escribirlo correctamente.\nPara los alola usa _alolan, por ejemplo \"Golem_alolan\"");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("senorivan rayquaza")){
            photo.setPhoto("https://i.imgur.com/ifCWjp3.jpg");
            isPhoto = true;

        }

        else if(recogWord.toLowerCase().contains("funciona la simulacion")){
            message.setText("Si escribes \"Simular Vigoroth vs Yanma 0 1\" por ejemplo, te mandaré un link a pvpoke.com con la simulación " +
                    "entre esos dos Pokémon, 0 1 es el número de escudos, siendo 0 para Vigoroth y 1 para Yanma.\nSi escribes mal el nombre de un Pokémon " +
                    "o pones más de 2 escudos la página no funcionará, tienes que escribirlo correctamente.\nPara los alola usa _alolan, por ejemplo \"Golem_alolan\"");
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

            }else if(nChistes == 4){
                photo.setPhoto("https://i.imgur.com/VJpa5L3.png");
                isPhoto = true;

            }
            else if(nChistes == 5){
                photo.setPhoto("https://i.imgur.com/Gbgb3sq.jpg");
                isPhoto = true;

            }

            if(nChistes == 5){
                nChistes = 0;
            }

        }

        else if(recogWord.toLowerCase().contains("añade:")){
            message.setText(update.getMessage().getText().substring(update.getMessage().getText().lastIndexOf(":") + 1) + " añadido");
            writerTexto(update.getMessage().getText().substring(update.getMessage().getText().lastIndexOf(":") + 1), "src/main/java/Intercambios.txt");

            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("borra:")){
            try {
                eliminaPokemon(update.getMessage().getText().substring(update.getMessage().getText().lastIndexOf(":") + 1));
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(borrado == true) {
                message.setText(update.getMessage().getText().substring(update.getMessage().getText().lastIndexOf(":") + 1) + " eliminado");
            }else{
                message.setText("No he dicho eso.");
            }

            borrado = false;

            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("fabuhora")){

            calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));

            formatter = new SimpleDateFormat("HH:mm:ss");
            formatter.setTimeZone(TimeZone.getTimeZone("GMT+2"));

            String horaRecortada = formatter.format(calendar.getTime());

            message.setText(horaRecortada+"");
            isMessage = true;

        }

        /*else if(recogWord.toLowerCase().contains("fabupole")){

            if(((horaInt > 6 && horaInt < 10) || (horaInt > 15 && horaInt < 19)) && poleInt[0].equals("0")){
                actualizarBaseDatos("1");
                String fabuPole = update.getMessage().getFrom().getFirstName() + " ha hecho la FabuPole! Los demás sois unos dormilones";
                message.setText(fabuPole+"");
                isMessage = true;

            }else{
                String fabuPoleTarde = "Tarde, se te han adelantado. Prueba a dejar de dormir tanto y levanta Españita.";
                message.setText(fabuPoleTarde+"");
                isMessage = true;
            }



        }*/

        else if(recogWord.toLowerCase().contains("pole")){
            message.setText("Nachos con guacamole");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("probar variables")){

            message.setText("xd");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("uwu")){
            message.setText("Warning, the Council of High Intelligence and Educational Findings (C.H.I.E.F.), has" +
                    " detected an \"uwu\". This is a code BRUH #4 level threat. Stay indoors and do not interact with" +
                    " cringe weebs until the threat has been classified as not dangerous. Unless the code BRUH is " +
                    "retracted, \"uwu\" will be classified under \"extremely cringy\" until further notice.");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("habla:")){
            message.setText(readerLista("src/main/java/Intercambios.txt"));

            if(vacio == true){
                message.setText("Lista vacía.");
            }
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("hola fabubot!")){
            message.setText("Hola " + update.getMessage().getFrom().getFirstName() + "!");

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


        } else if(recogWord.toLowerCase().contains("inscribirme ranking ppt")){
            if (comprobarExiste("idppt.txt", String.valueOf(update.getMessage().getFrom().getId()))) {
                message.setText("Ya estás inscrit@");
            } else {
                writerTexto(String.valueOf(update.getMessage().getFrom().getId()), "idppt.txt");
                message.setText("Perfecto! Te he apuntado!");
            }
            isMessage = true;

        }else if(recogWord.toLowerCase().contains("muestra lista id ppt")){
            message.setText(readerLista("idppt.txt"));
            isMessage = true;

        }else if(recogWord.toLowerCase().contains("dame") && recogWord.toLowerCase().contains("x")){
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

        if(isGif == true) {
            try {
                execute(gif);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
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

    public boolean comprobarExiste(String archivo, String texto){
        String ruta = archivo;
        File fichero = new File(ruta);
        String linea = "";
        Scanner reader = null;
        int contLineas = 0;
        boolean existe = false;
        try {
            reader = new Scanner(fichero);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(reader.hasNextLine()){

            if(reader.nextLine().contains(texto)){
                existe = true;
            }
        }

        return existe;
    }

    public void actualizarBaseDatos(String polereset) {

        //Conectar.EjecutarUpdate("UPDATE polereset SET polereset = \"" + polereset + "\";");

    }

    public String readerLista(String archivo){
        String ruta = archivo;
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

    public void writerSuma(String archivo) {
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

    public void writerTexto(String texto, String archivo) {
        String ruta = archivo;

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
