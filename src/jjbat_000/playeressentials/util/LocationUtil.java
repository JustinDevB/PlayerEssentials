package jjbat_000.playeressentials.util;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;

import java.text.DecimalFormat;

/**
 * User: bobacadodl
 * Date: 12/28/13
 * Time: 11:04 PM
 */
public class LocationUtil {

    public static Location getSafeLocation(Location location) {
        Location safe = location.clone();
        while (safe.getBlock().getType() != Material.AIR) {
            safe = safe.getBlock().getRelative(BlockFace.UP).getLocation();
            if (safe.getY() >= safe.getWorld().getMaxHeight())
                break;
        }
        return safe;
    }

    public static String locToString(Location location) {
        Object[] loc = {location.getWorld().getName(), location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch()};
        return StringUtils.join(loc, ",");
    }

    public static String roundLocToString(Location location) {
        return locToString(roundLocation(location));
    }

    public static Location roundLocation(Location location) {
        return new Location(
                location.getWorld(),
                round(location.getX()),
                round(location.getY()),
                round(location.getZ()),
                round(location.getYaw()),
                round(location.getPitch()));
    }

    public static Location stringToLoc(String locString) {
        String[] loc = locString.split(",");
        World world = Bukkit.getWorld(loc[0]);
        double x = Double.parseDouble(loc[1]);
        double y = Double.parseDouble(loc[2]);
        double z = Double.parseDouble(loc[3]);
        float yaw = Float.parseFloat(loc[4]);
        float pitch = Float.parseFloat(loc[5]);
        return new Location(world, x, y, z, yaw, pitch);
    }

    public static boolean locationEquals(Location loc1, Location loc2) {
        return loc1.getBlock().getLocation().equals(loc2.getBlock().getLocation());
    }

    private static double round(double d) {
        return Double.parseDouble(new DecimalFormat("#.##").format(d));
    }

    private static float round(float f) {
        return Float.parseFloat(new DecimalFormat("#.##").format(f));
    }
}

