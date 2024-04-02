package su.nightexpress.nightcore.language;

import org.jetbrains.annotations.NotNull;
import su.nightexpress.nightcore.NightCorePlugin;
import su.nightexpress.nightcore.config.FileConfig;
import su.nightexpress.nightcore.language.entry.LangEntry;
import su.nightexpress.nightcore.manager.SimpleManager;
import su.nightexpress.nightcore.util.Plugins;
import su.nightexpress.nightcore.util.Reflex;
import su.nightexpress.nightcore.util.StringUtil;

import java.io.File;

public class LangManager extends SimpleManager<NightCorePlugin> {

    public static final String DEFAULT_LANGUAGE = "en";
    public static final String DIR_LANG = "/lang/";

    private FileConfig config;

    public LangManager(@NotNull NightCorePlugin plugin) {
        super(plugin);
    }

    @Override
    protected void onLoad() {
        this.plugin.extractResources(DIR_LANG);
        String langCode = this.plugin.getLanguage();
        String realCode = this.validateConfig(langCode);
        this.config = FileConfig.loadOrExtract(this.plugin, DIR_LANG, this.getFileName(realCode));
    }

    @Override
    protected void onShutdown() {

    }

    private boolean isPacked(@NotNull String filePath) {
        if (!filePath.startsWith("/")) {
            filePath = "/" + filePath;
        }

        return plugin.getClass().getResourceAsStream(filePath) != null;
    }

    @NotNull
    private String validateConfig(@NotNull String langCode) {
        String fileName = this.getFileName(langCode);

        File file = new File(plugin.getDataFolder() + DIR_LANG, fileName);
        if (!file.exists() && !isDefault(langCode)) {
            if (this.isPacked(DIR_LANG + fileName)) {
                return langCode;
            }

            this.plugin.warn("Locale file for '" + langCode + "' language not found. Using default '" + DEFAULT_LANGUAGE + "' locale.");
            return DEFAULT_LANGUAGE;
        }
        return langCode;

        /*if (file.exists()) return langCode;

        try {
            InputStream input = plugin.getClass().getResourceAsStream(DIR_LANG + fileName);
            if (input != null) {
                FileUtil.create(file);
                FileUtil.copy(input, file);
                return langCode;
            }
            return isDefault(langCode) ? langCode : this.extractConfig(DEFAULT_LANGUAGE);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return isDefault(langCode) ? langCode : this.extractConfig(DEFAULT_LANGUAGE);
        }*/
    }

    public void loadEntries(@NotNull Class<?> clazz) {
        Reflex.getFields(clazz, LangEntry.class).forEach(entry -> {
            entry.load(this.plugin);
        });
    }

    /*public void loadEditor(@NotNull Class<?> clazz) {
        Reflex.getFields(clazz, LangItem.class).forEach(entry -> {
            entry.load(this.plugin);
        });
    }*/

    public void loadEnum(@NotNull Class<? extends Enum<?>> clazz) {
        for (Object eName : clazz.getEnumConstants()) {
            String name = eName.toString();
            String path = clazz.getSimpleName() + "." + name;
            String val = StringUtil.capitalizeUnderscored(name);
            this.getConfig().addMissing(path, val);
        }
    }

    @NotNull
    public String getEnum(@NotNull Enum<?> entry) {
        String path = entry.getDeclaringClass().getSimpleName() + "." + entry.name();
        String locEnum = this.config.getString(path);
        if (locEnum == null && !this.plugin.isEngine()) {
            return Plugins.CORE.getLangManager().getEnum(entry);
        }
        return locEnum == null ? StringUtil.capitalizeFully(entry.name()) : locEnum;
    }

    public static boolean isDefault(@NotNull String langCode) {
        return langCode.equalsIgnoreCase(DEFAULT_LANGUAGE);
    }

    @NotNull
    public String getFileName(@NotNull String langCode) {
        return "messages_" + langCode + ".yml";
    }

    @NotNull
    public FileConfig getConfig() {
        return config;
    }
}
