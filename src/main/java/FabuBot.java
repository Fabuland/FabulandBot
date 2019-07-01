import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class FabuBot extends TelegramLongPollingBot {
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

        else if(recogWord.toLowerCase().contains("mejores atacantes")){
            message.setText("Siempre Machamp");
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

        else if(recogWord.toLowerCase().contains("fabu")){
            message.setText("Espero que hayas dicho algo bueno del todopoderoso Fabuland");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("lista de comandos")){
            message.setText("Mis comandos disponibles son:\n" +
                    "- Mejores atacantes\n" +
                    "- Mejores defensores\n" +
                    "- A qué hora empieza el CD\n" +
                    "- Con cuántos cae Groudon?\n" +
                    "- Qué hace daño a xxxxx (siendo xxxxx un tipo cualquiera)\n" +
                    "- Cómo funcionan los IV?" +
                    "- Piedra papel y tijeras\n" +
                    "- Cuenta chistes (por ahora sólo uno)\n" +
                    "- Dame n X (siendo n un número entre 1 y 500\n" +
                    "\n" +
                    "Se irán actualizando (versión de prueba)");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("funcionan los IV")){
            message.setText("IV significa Valores Individuales (Individual Values), " +
                    "y son una mecánica que funciona como los genes de un Pokémon. Los IV tienen 3 " +
                    "categorías en Pokémon GO, al igual que las estadísticas base, Ataque, Defensa y Salud. " +
                    "Pueden variar entre 0 y 15 cada estadística, por lo que hay 16 posibilidades distintas por" +
                    " cada estadística y un total de 4096 combinaciones de IV. \n La funcionalidad de los IV " +
                    "no es más que una mera suma de esos valores que sacas con calculadoras como Calcy IV o Pokegenie a la estadística base de un Pokémon.");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("cae Deoxys velocidad")){
            message.setText("Entre 2 si hay amistad 4, Gengars/Giratina Origen y clima a favor \n" +
                    "Entre 3 si hay counters al 35+ \n" +
                    "Entre 3 si hay muy buenos counters al 30+ con amistad \n" +
                    "Entre 4 si hay counters al 25+/20+ \n" +
                    "\n" +
                    "Preferible siempre que haya amistad y clima a favor");
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

        else if(recogWord.toLowerCase().contains("/start")){
            message.setText("Buenas! Intentaré ayudarte en la medida de lo posible, para ver " +
                    "mis comandos escribe \"Lista de comandos\" y verás los comandos que tengo " +
                    "disponible.");
            isMessage = true;
        }

        else if(recogWord.toLowerCase().contains("piedra") && recogWord.toLowerCase().contains("papel")
                && (recogWord.toLowerCase().contains("tijera") || recogWord.toLowerCase().contains("tijeras"))){
            message.setText("Perfecto! Piedra, papel o tijeras, una, dos y tres!!");
            isMessage = true;

        }

        else if(recogWord.toLowerCase().contains("chiste")){
            photo.setPhoto("https://i.imgur.com/QUULMsz.jpg");
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

    public String getBotUsername() {
        return "FabulandBot";
    }

    public String getBotToken() {
        return "880519089:AAEchLVodgwl6LCQ48OcUKRvqyOlNbwAQBQ";
    }
}
