package me.acclashcorporation.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;

public class BotCommands extends ListenerAdapter {

    private final String[] Bad_Words = {"poop", "fword", "fuck", "bitch", "shit", "damn"};

    List<Message> msgs;

    private final String[] Staff_Only_Channels = {"feature-updates", "staff-only", "bot-testing", "halo-battles-tasks", "crucials-tasks"};

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (event.getName().equals("info")) {
            event.reply("AC Clash bot version 0.3 is up and running using JDA version 5.0.0-alpha.12! It was programmed by Anston Sorensen (Tennessine).").setEphemeral(true).queue();
        } else if (event.getName().equals("ver")) {
            event.reply("You are using AC Clash Bot 0.3 programmed by Anston Sorensen (Tennessine)!").setEphemeral(true).queue();
        } else if (event.getName().equals("welcome")) {
            if (event.getMember().isOwner()) {
                MessageEmbed welcome = new EmbedBuilder()
                        .setTitle("Welcome! :crossed_swords:")
                        .setColor(Color.decode("#ffa500"))
                        .setDescription("Welcome to the official AC Clash Discord server! Even though the server is in early development, we want to grow our community. We will let you know when you can test the server closer to release! We're excited to have you and hope that you have a good time with all your friends and other players. Please read both the Discord and Minecraft server rules below. We also recommend reading the FAQ.")
                        .build();
                MessageEmbed drules = new EmbedBuilder()
                        .setTitle("Discord Rules :scroll:")
                        .setColor(Color.decode("#ffa500"))
                        .setDescription("**1. Be respectful/don't be rude.**\nBe nice to everyone.\n\n**2. No discrimination.**\nDo not discriminate someone of race, ethnicity, etc.\n\n**3. No inappropriate behavior or swearing period (includes profile pics and statuses).**\nMake everyone feel at home. Don't try to bypass the filters especially.\n\n**4. No excessive spamming.**\nDon't keep spamming messages, emoji's, images, etc.\n\n**5. Don't share your own or anyone else's personal information.**\nIt's always important to be safe online.\n\n**6. No advertising.**\nPlease don't advertise other Discord's or IP's.\n\n**7. HAVE FUN!!! (feel free to say 'Hi' to staff)**\nYou can just dm us if you'd like.\n\nListen to the rules and staff or you may be banned for an amount of time the staff decides.")
                        .build();
                MessageEmbed srules = new EmbedBuilder()
                        .setTitle("Server Rules :computer:")
                        .setColor(Color.decode("#ffff00"))
                        .setDescription("The server rules apply everywhere please read them.\n\n:link: https://acclash.com/rules")
                        .build();
                MessageEmbed faq = new EmbedBuilder()
                        .setTitle("Frequently Asked Questions :pencil:")
                        .setColor(Color.decode("#00ff00"))
                        .setDescription("The FAQ is also available here: :link: https://acclash.com/rules\n\n**How do I join?**\nJava IP: **play.acclash.tk**\nBedrock IP: **br.acclash.tk**\n\n**How is this server unique?**\nPlayers can join using the Bedrock Editon of Minecraft making it **cross platform** (it's **very experimental** though). You can play multiplayer survival, creative, or special minigames including **Halo Battles** and **COD Ops**. We also have classic ones like Survival Games, Spleef, Skywars and more.\n\n**What versions do you accept?**\n1.8.x - 1.17.x.")
                        .build();
                event.getChannel().sendMessageEmbeds(welcome, drules, srules, faq).queue();
                event.reply("Successfully sent the welcome embeds.").setEphemeral(true).queue();
            } else {
                event.reply("You aren't the server owner!").setEphemeral(true).queue();
            }
        } else if (event.getName().equals("welcomeedit")) {
            if (event.getMember().isOwner()) {
                MessageEmbed welcome = new EmbedBuilder()
                        .setTitle("Welcome! :crossed_swords:")
                        .setColor(Color.decode("#ffa500"))
                        .setDescription("Welcome to the official AC Clash Discord server! Even though the server is in early development, we want to grow our community. We will let you know when you can test the server closer to release! We're excited to have you and hope that you have a good time with all your friends and other players. Please read both the Discord and Minecraft server rules below. We also recommend reading the FAQ.")
                        .build();
                MessageEmbed drules = new EmbedBuilder()
                        .setTitle("Discord Rules :scroll:")
                        .setColor(Color.decode("#ffa500"))
                        .setDescription("**1. Be respectful/don't be rude.**\nBe nice to everyone.\n\n**2. No discrimination.**\nDo not discriminate someone of race, ethnicity, etc.\n\n**3. No inappropriate behavior or swearing period (includes profile pics and statuses).**\nMake everyone feel at home. Don't try to bypass the filters especially.\n\n**4. No excessive spamming.**\nDon't keep spamming messages, emoji's, images, etc.\n\n**5. Don't share your own or anyone else's personal information.**\nIt's always important to be safe online.\n\n**6. No advertising.**\nPlease don't advertise other Discord's or IP's.\n\n**7. HAVE FUN!!! (feel free to say 'Hi' to staff)**\nYou can just dm us if you'd like.\n\nListen to the rules and staff or you may be muted, banned, etc. for an amount of time the staff decides.")
                        .build();
                MessageEmbed srules = new EmbedBuilder()
                        .setTitle("General Rules :computer:")
                        .setColor(Color.decode("#ffff00"))
                        .setDescription("The general rules apply everywhere please read them.\n\n:link: https://acclash.com/rules")
                        .build();
                MessageEmbed faq = new EmbedBuilder()
                        .setTitle("Frequently Asked Questions :pencil:")
                        .setColor(Color.decode("#00ff00"))
                        .setDescription("The FAQ is also available here: :link: https://acclash.com/faq\n\n**How do I join?**\nJava IP: **play.acclash.com**\n\n**How is this server unique?**\n~~Players can join using the Bedrock Editon of Minecraft making it **cross platform** (it's **very experimental** though).~~* You can play multiplayer survival, creative, or special minigames including **Halo Battles** and **COD Ops**. We also have classic ones like Survival Games, Spleef, Skywars and more.\n\n**What versions do you accept?**\n1.8.x - 1.19.x.\n\n*Bedrock support was sadly dropped as of 4-13-2022 due to the development team struggling to keep supporting it when developing minigames.")
                        .build();
                event.getChannel().editMessageEmbedsById("903080849757569064", welcome, drules, srules, faq).queue();
                event.reply("Successfully edited the welcome embeds.").setEphemeral(true).queue();
            } else {
                event.reply("You aren't the server owner!").setEphemeral(true).queue();
            }
        } else if (event.getName().equals("food")) {
            OptionMapping option = event.getOption("name");
            if (option == null) {
                event.reply("A food name was not provided.").queue();
                return;
            }

            String favoriteFood = option.getAsString();

            for (String badWord : Bad_Words) {

                if (favoriteFood.contains(badWord)) {
                    event.reply("Hey, that's an inappropriate food name. I reported you to the staff").setEphemeral(true).queue();
                    TextChannel staffChannel = event.getJDA().getTextChannelById("984866854902304799");

                    if (staffChannel != null) {

                        net.dv8tion.jda.api.interactions.components.buttons.Button muteMember = net.dv8tion.jda.api.interactions.components.buttons.Button.danger("mute-member", "Mute Member");
                        net.dv8tion.jda.api.interactions.components.buttons.Button ignoreAlert = Button.success("ignore-alert", "Ignore Alert");

                        Message message = new MessageBuilder()
                                .append(event.getMember().getEffectiveName())
                                .append(" put in a bad word in a command. Click any of the buttons below to do an action. ")
                                .setActionRows(ActionRow.of(muteMember, ignoreAlert))
                                .build();

                        staffChannel.sendMessage(message).queue();
                    } else {
                        event.reply("Your favorite food is: " + favoriteFood).queue();
                    }
                }
            }

        } else if (event.getName().equals("modaltest")) {
            TextInput name = TextInput.create("name", "Name", TextInputStyle.SHORT)
                    .setMinLength(1)
                    .setRequired(true)
                    .build();

            TextInput message = TextInput.create("message", "Message", TextInputStyle.PARAGRAPH)
                    .setMinLength(1)
                    .setMaxLength(100)
                    .setRequired(true)
                    .setPlaceholder("Put a cool message here")
                    .build();

            Modal testModal = Modal.create("test-modal", "Test modal")
                    .addActionRows(ActionRow.of(name), ActionRow.of(message))
                    .build();

            event.replyModal(testModal).queue();
        } else if (event.getName().equals("clearchannel")) {

            for (String staffChannel : Staff_Only_Channels) {

                if (event.getChannel().getName().equals(staffChannel)) {
                    try {
                        msgs = event.getChannel().getHistory().retrievePast(20).complete();

                        if (msgs.size() == 1) {
                            String id = event.getChannel().getLatestMessageId();
                            event.getTextChannel().deleteMessageById(id).queue();
                            event.reply("Channel Successfully Cleared.").setEphemeral(true).queue();
                        } else {
                            event.getTextChannel().deleteMessages(msgs).queue();
                            event.reply("Channel Successfully Cleared.").setEphemeral(true).queue();
                        }
                    } catch (IllegalArgumentException e) {
                        event.reply("The channel was not able to be cleared due to a message being older than 2 weeks. If a message is older than 2 weeks Discord does not allow this action.").setEphemeral(true).queue();
                    }
                } else {
                    event.reply("Woa there, this is a public channel. You can't clear this!").setEphemeral(true).queue();
                }
            }
        }
    }
}
