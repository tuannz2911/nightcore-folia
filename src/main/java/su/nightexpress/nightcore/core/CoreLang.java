package su.nightexpress.nightcore.core;

import net.md_5.bungee.api.chat.ClickEvent;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.nightcore.dialog.Dialog;
import su.nightexpress.nightcore.language.entry.LangItem;
import su.nightexpress.nightcore.language.entry.LangString;
import su.nightexpress.nightcore.language.entry.LangText;
import su.nightexpress.nightcore.util.Placeholders;

import static su.nightexpress.nightcore.util.Placeholders.*;
import static su.nightexpress.nightcore.language.tag.MessageTags.*;
import static su.nightexpress.nightcore.util.text.tag.Tags.*;

public class CoreLang {

    public static final LangText COMMAND_HELP_LIST = LangText.of("Command.Help.List",
        TAG_NO_PREFIX,
        "  " + YELLOW.enclose(BOLD.enclose(GENERIC_NAME)) + GRAY.enclose(" - ") + YELLOW.enclose(BOLD.enclose("Commands:")),
        " ",
        GRAY.enclose("  " + RED.enclose(BOLD.enclose("<>")) + " - Required, " + GREEN.enclose(BOLD.enclose("[]")) + " - Optional."),
        " ",
        GENERIC_ENTRY,
        " "
    );

    public static final LangString COMMAND_HELP_ENTRY = LangString.of("Command.Help.Entry",
        "  " + YELLOW.enclose( "/" + COMMAND_LABEL) + " " + ORANGE.enclose(Placeholders.COMMAND_USAGE) + GRAY.enclose(" - " + COMMAND_DESCRIPTION)
    );

    public static final LangString COMMAND_HELP_DESC = LangString.of("Command.Help.Desc", "Show help page.");

    public static final LangString COMMAND_CHECKPERM_DESC  = LangString.of("Command.CheckPerm.Desc", "Print player permission info.");
    public static final LangString COMMAND_CHECKPERM_USAGE = LangString.of("Command.CheckPerm.Usage", "<player>");

    public static final LangString COMMAND_RELOAD_DESC = LangString.of("Command.Reload.Desc", "Reload the plugin.");
    public static final LangText   COMMAND_RELOAD_DONE = LangText.of("Command.Reload.Done", "Plugin " + GREEN.enclose("reloaded") + "!");

    public static final LangString TIME_DAY       = LangString.of("Time.Day", GENERIC_AMOUNT + "d.");
    public static final LangString TIME_HOUR      = LangString.of("Time.Hour", GENERIC_AMOUNT + "h.");
    public static final LangString TIME_MINUTE    = LangString.of("Time.Min", GENERIC_AMOUNT + "min.");
    public static final LangString TIME_SECOND    = LangString.of("Time.Sec", GENERIC_AMOUNT + "sec.");
    public static final LangString TIME_DELIMITER = LangString.of("Time.Delimiter", " ");

    public static final LangString OTHER_YES       = LangString.of("Other.Yes", GREEN.enclose("Yes"));
    public static final LangString OTHER_NO        = LangString.of("Other.No", RED.enclose("No"));
    public static final LangString OTHER_ENABLED   = LangString.of("Other.Enabled", GREEN.enclose("Enabled"));
    public static final LangString OTHER_DISABLED  = LangString.of("Other.Disabled", RED.enclose("Disabled"));
    public static final LangString OTHER_ANY       = LangString.of("Other.Any", "Any");
    public static final LangString OTHER_NONE      = LangString.of("Other.None", "None");
    public static final LangString OTHER_NEVER     = LangString.of("Other.Never", "Never");
    public static final LangString OTHER_ONE_TIMED = LangString.of("Other.OneTimed", "One-Timed");
    public static final LangString OTHER_UNLIMITED = LangString.of("Other.Unlimited", "Unlimited");
    public static final LangString OTHER_INFINITY  = LangString.of("Other.Infinity", "∞");

    public static final LangText ERROR_INVALID_PLAYER       = LangText.of("Error.Invalid_Player", RED.enclose("Player not found."));
    public static final LangText ERROR_INVALID_WORLD        = LangText.of("Error.Invalid_World", RED.enclose("Invalid world."));
    public static final LangText ERROR_INVALID_NUMBER       = LangText.of("Error.Invalid_Number", RED.enclose(GENERIC_VALUE + " is not a valid number."));
    public static final LangText ERROR_NO_PERMISSION        = LangText.of("Error.NoPermission", RED.enclose("You don't have permissions to do that!"));
    public static final LangText ERROR_COMMAND_NOT_YOURSELF = LangText.of("Error.Command.NotYourself", RED.enclose("This command can not be used on yourself."));
    public static final LangText ERROR_COMMAND_PLAYER_ONLY  = LangText.of("Error.Command.PlayerOnly", RED.enclose("This command is for players only."));
    public static final LangText ERROR_COMMAND_USAGE        = LangText.of("Error.Command.Usage",
        TAG_NO_PREFIX,
        RED.enclose("Error: ") + GRAY.enclose("Wrong arguments!"),
        RED.enclose("Usage: ") + YELLOW.enclose("/" + Placeholders.COMMAND_LABEL) + " " + ORANGE.enclose(Placeholders.COMMAND_USAGE),
        " "
    );

    public static final LangText EDITOR_ACTION_EXIT = LangText.of("Editor.Action.Exit",
        TAG_NO_PREFIX,
        GRAY.enclose("Click " +
            CLICK.enclose(
                ClickEvent.Action.RUN_COMMAND,
                HOVER.enclose(GREEN.enclose("[Here]"), GRAY.enclose("Click to cancel")),
                "/" + Dialog.EXIT
            )
            + " to leave input mode."),
        " ");

    public static final LangString EDITOR_INPUT_HEADER_MAIN       = LangString.of("Editor.Input.Header.Main", GREEN.enclose(BOLD.enclose("Input Mode")));
    public static final LangString EDITOR_INPUT_HEADER_ERROR      = LangString.of("Editor.Input.Header.Error", RED.enclose(BOLD.enclose("ERROR")));
    public static final LangString EDITOR_INPUT_ERROR_NOT_INTEGER = LangString.of("Editor.Input.Error.NotInteger", GRAY.enclose("Expecting " + RED.enclose("whole") + " number!"));
    public static final LangString EDITOR_INPUT_ERROR_GENERIC     = LangString.of("Editor.Input.Error.Generic", GRAY.enclose("Invalid value!"));

    public static final LangItem EDITOR_ITEM_CLOSE         = LangItem.of("Editor.Generic.Close", RED.enclose("(✕) Exit"));
    public static final LangItem EDITOR_ITEM_RETURN        = LangItem.of("Editor.Generic.Return", GRAY.enclose("(↓) ") + WHITE.enclose("Return"));
    public static final LangItem EDITOR_ITEM_NEXT_PAGE     = LangItem.of("Editor.Generic.NextPage", WHITE.enclose("Next Page") + GRAY.enclose(" (→)"));
    public static final LangItem EDITOR_ITEM_PREVIOUS_PAGE = LangItem.of("Editor.Generic.PreviousPage", GRAY.enclose("(←) ") + WHITE.enclose("Previous Page"));

    public static final LangString NUMBER_SHORT_THOUSAND    = LangString.of("Number.Thousand", "k");
    public static final LangString NUMBER_SHORT_MILLION     = LangString.of("Number.Million", "m");
    public static final LangString NUMBER_SHORT_BILLION     = LangString.of("Number.Billion", "b");
    public static final LangString NUMBER_SHORT_TRILLION    = LangString.of("Number.Trillion", "t");
    public static final LangString NUMBER_SHORT_QUADRILLION = LangString.of("Number.Quadrillion", "q");

    @NotNull
    public static String getYesOrNo(boolean value) {
        return (value ? OTHER_YES : OTHER_NO).getString();
    }

    @NotNull
    public static String getEnabledOrDisabled(boolean value) {
        return (value ? OTHER_ENABLED : OTHER_DISABLED).getString();
    }
}
