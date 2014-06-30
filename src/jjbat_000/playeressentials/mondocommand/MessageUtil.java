package jjbat_000.playeressentials.mondocommand;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class MessageUtil {
    public static String normalize(String s) {
        return s.toLowerCase().replaceAll("_", "");
    }

    public static String center(String s, int length) {
        if (s.length() > length) {
            return s.substring(0, length);
        } else if (s.length() == length) {
            return s;
        } else {
            int leftPadding = (length - s.length()) / 2;
            StringBuilder leftBuilder = new StringBuilder();
            for (int i = 0; i < leftPadding; i++) {
                leftBuilder.append(" ");
            }
            return leftBuilder.toString() + s;
        }
    }

    public static String translate(String t) {
        return t.replace("$$", "{PLACEHOLDER}").replace("$", "\u00A7").replace("{PLACEHOLDER}", "$");
    }

    public static String[] translate(String... s) {
        String[] arr = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = MessageUtil.translate(s[i]);
        }
        return arr;
    }

    public static List<String> translate(List<String> s) {
        List<String> ret = new ArrayList<>();
        for (String str : s) {
            ret.add(MessageUtil.translate(str));
        }
        return ret;
    }

    public static List<String> colorize(String[] s, ChatColor color) {
        List<String> ret = new ArrayList<>();
        for (String str : s) {
            ret.add(color + str);
        }
        return ret;
    }

    public static List<String> colorize(List<String> s, ChatColor color) {
        List<String> ret = new ArrayList<>();
        for (String str : s) {
            ret.add(color + str);
        }
        return ret;
    }

    public static String addFormatToColored(String s, ChatColor format) {
        StringBuilder sb = new StringBuilder(s);
        sb.insert(2, format.toString());
        return sb.toString();
    }
}
