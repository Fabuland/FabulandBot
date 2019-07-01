import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class FabuBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {

        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getFirstName());

        String command = update.getMessage().getText();
        String recogWord = update.getMessage().getText();
        String caeGroudon = "cae groudon";
        SendMessage message = new SendMessage();

        if(command.equalsIgnoreCase("/aggron")){
            message.setText("Triturar de inmediato");
        }

        else if(recogWord.toLowerCase().contains("mejores atacantes")){
            message.setText("Siempre Machamp");
        }

        else if(recogWord.toLowerCase().contains("mejores defensores")){
            message.setText("Siempre Blissey");
        }

        else if(recogWord.toLowerCase().contains(caeGroudon)){
            message.setText("Entre 3 si hay counters al 35+\n" +
                    "Entre 4 si hay counters al 30+\nEntre 5 con counters al 20+\n" +
                    "Entre 21 si alguno de vosotros usa Aggron\nPreferible siempre que haya amistad " +
                    "y clima a favor");

        }

        else if(recogWord.toLowerCase().contains("empieza el community")){
            message.setText("El CD es de 16:00 a 19:00");
        }

        else if(recogWord.toLowerCase().contains("empieza el cd")){
            message.setText("El CD es de 16:00 a 19:00");
        }

        else if(recogWord.toLowerCase().contains("empieza el dia de la comunidad")){
            message.setText("El CD es de 16:00 a 19:00");
        }

        else if(recogWord.toLowerCase().contains("hora es el cd")){
            message.setText("El CD es de 16:00 a 19:00");
        }

        else if(recogWord.toLowerCase().contains("hora es el commmunity")){
            message.setText("El CD es de 16:00 a 19:00");
        }

        else if(recogWord.toLowerCase().contains("hora es el dia de la comunidad")){
            message.setText("El CD es de 16:00 a 19:00");
            
        }

        else if(recogWord.toLowerCase().contains("fabu")){
            message.setText("Espero que hayas dicho algo bueno del todopoderoso Fabuland");

        }

        else if(recogWord.toLowerCase().contains("lista de comandos")){
            message.setText("Mis comandos disponibles son:\n" +
                    "- Mejores atacantes\n" +
                    "- Mejores defensores\n" +
                    "- A qué hora empieza el CD\n" +
                    "- Con cuántos cae Groudon?\n" +
                    "- Qué hace daño a xxxxx (siendo xxxxx un tipo cualquiera)\n" +
                    "\n" +
                    "Se irán actualizando (versión de prueba)");
        }

        else if(recogWord.toLowerCase().contains("daño a normal")){
            message.setText("Lucha");

        }

        else if(recogWord.toLowerCase().contains("daño a fuego")){
            message.setText("Agua, Tierra y Roca");

        }

        else if(recogWord.toLowerCase().contains("daño a agua")){
            message.setText("Eléctrico y Planta");

        }

        else if(recogWord.toLowerCase().contains("daño a electrico")){
            message.setText("Tierra");

        }

        else if(recogWord.toLowerCase().contains("daño a eléctrico")){
            message.setText("Tierra");

        }

        else if(recogWord.toLowerCase().contains("daño a planta")){
            message.setText("Fuego, Hielo, Veneno, Volador y Bicho");

        }

        else if(recogWord.toLowerCase().contains("daño a hielo")){
            message.setText("Fuego, Lucha, Roca y Acero");

        }

        else if(recogWord.toLowerCase().contains("daño a lucha")){
            message.setText("Volador, Psíquico y Hada");

        }

        else if(recogWord.toLowerCase().contains("daño a veneno")){
            message.setText("Tierra y Psíquico");

        }

        else if(recogWord.toLowerCase().contains("daño a tierra")){
            message.setText("Agua, Planta y Hielo");

        }

        else if(recogWord.toLowerCase().contains("daño a volador")){
            message.setText("Eléctrico, Hielo y Roca");

        }

        else if(recogWord.toLowerCase().contains("daño a psiquico")){
            message.setText("Bicho, Fantasma y Siniestro");

        }

        else if(recogWord.toLowerCase().contains("daño a psíquico")){
            message.setText("Bicho, Fantasma y Siniestro");

        }

        else if(recogWord.toLowerCase().contains("daño a bicho")){
            message.setText("Fuego, Volador y Roca");

        }

        else if(recogWord.toLowerCase().contains("daño a roca")){
            message.setText("Agua, Planta, Lucha y Tierra");

        }

        else if(recogWord.toLowerCase().contains("daño a fantasma")){
            message.setText("Fantasma y Siniestro");

        }

        else if(recogWord.toLowerCase().contains("daño a dragon")){
            message.setText("Hielo, Dragon y Hada");

        }

        else if(recogWord.toLowerCase().contains("daño a dragón")){
            message.setText("Hielo, Dragon y Hada");

        }

        else if(recogWord.toLowerCase().contains("daño a siniestro")){
            message.setText("Lucha, Bicho y Hada");

        }

        else if(recogWord.toLowerCase().contains("daño a acero")){
            message.setText("Fuego, Lucha y Tierra");

        }

        else if(recogWord.toLowerCase().contains("daño a hada")){
            message.setText("Veneno y Acero");

        }

        else if(recogWord.toLowerCase().contains("/start")){
            message.setText("Buenas! Intentaré ayudarte en la medida de lo posible, para ver " +
                    "mis comandos escribe \"Lista de comandos\" y verás los comandos que tengo " +
                    "disponible.");
        }else {
            message.setText("No comprendo tu comando, prueba con mi \"Lista de comandos\"");
        }


        message.setChatId(update.getMessage().getChatId());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public String getBotUsername() {
        return "FabulandBot";
    }

    public String getBotToken() {
        return "880519089:AAEchLVodgwl6LCQ48OcUKRvqyOlNbwAQBQ";
    }
}
