package me.acclashcorporation;

import me.acclashcorporation.commands.BotCommands;
import me.acclashcorporation.listeners.BotListeners;
import me.acclashcorporation.listeners.ButtonListeners;
import me.acclashcorporation.listeners.ModalListeners;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import javax.security.auth.login.LoginException;

public class DiscordBot extends ListenerAdapter {

    public static void main(String[] args) throws LoginException, InterruptedException {

        JDA bot = JDABuilder.createDefault("NzY4NjAzMjU3MDEzNTM0NzYy.X5C3kA.6SFWV_JBh7UZ1yMEyPB56rcqnLM")
                .setActivity(Activity.watching("Hart to Hart"))
                .addEventListeners(new BotListeners(), new BotCommands(), new ModalListeners(), new ButtonListeners())
                .build()
                .awaitReady();

        Guild guild = bot.getGuildById("675831474573803529");

        if (guild != null) {
            bot.upsertCommand("info", "Display info about the bot.").queue();
            bot.upsertCommand("ver", "Display the bot's version.").queue();
            guild.upsertCommand("welcome", "Sends the original welcome embedded messages.").queue();
            guild.upsertCommand("welcomeedit", "Edits the welcome embedded messages with the updated one.").queue();
            guild.upsertCommand("food", "This command tests slash command arguments.")
                    .addOptions(new OptionData(OptionType.STRING, "name", "The name of your favorite food.", true))
                    .queue();
            guild.upsertCommand("modaltest", "Tests the new modals.").queue();
            guild.upsertCommand("clearchannel", "Clears a bunch of messages from the channel the commmand was run in.").queue();

        }
    }
}
