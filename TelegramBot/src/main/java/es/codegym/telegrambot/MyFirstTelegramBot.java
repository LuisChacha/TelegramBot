package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "CodeGymlfcm_bot";
    public static final String TOKEN = "5755718360:AAGVg8quw9BXRzSIMDlhnHTiqmtbmKFWONc";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        setUserGlory(0);
        if(getMessageText().equals("/start")){
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera", "step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Tomar una salchicha! +20 de fama", "step_2_btn",
                            "Tomar un pescado! +20 de fama", "step_2_btn",
                            "Tirar una lata de pepinillos! +20 de fama", "step_2_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Romper al robot aspirador", "step_3_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot aspirador a por comida! +30 de fama", "step_4_btn",
                            "Dar un paseo en el robot aspirador! +30 de fama", "step_4_btn",
                            "Huir del robot aspirador! +30 de fama", "step_4_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Enviar al robot garra! +30 de fama", "step_5_btn",
                            "Quitar al robot garra","step_5_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            setUserGlory(40);
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Entregar un sorbo de aceite al robot", "step_6_btn",
                            "Limpiar con el robot", "step_6_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            setUserGlory(40);
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Tomarse una foto con el robot", "step_7_btn",
                            "Reconocer como lo maximo al Robot", "step_7_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            setUserGlory(40);
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Darle respiro al robot", "step_8_btn",
                            "Darle puntos al Robot", "step_8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            setUserGlory(40);
            sendTextMessageAsync(FINAL_TEXT,
                    Map.of("Eso fue todo con el Robot", ""));
        }



    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}