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

        else if(recogWord.toLowerCase().contains("lista de comandos")){
            message.setText("Mis comandos disponibles son:\n" +
                    "- Mejores atacantes\n" +
                    "- Mejores defensores\n" +
                    "- A qué hora empieza el CD\n" +
                    "- Con cuántos cae Groudon?\n" +
                    "\n" +
                    "Se irán actualizando (versión de prueba)");
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
