import java.util.HashMap;

/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map. This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints." In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState {
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;

    /** Хэш-карта для "открытых вершин" **/
    private HashMap<Location, Waypoint> openWaypoints;

    /** Хэш-карта для "закрытых вершин" **/
    private HashMap<Location, Waypoint> closedWaypoints;

    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map) {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
        this.openWaypoints = new HashMap<Location, Waypoint>();
        this.closedWaypoints = new HashMap<Location, Waypoint>();
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap() {
        return map;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint with
     * the minimum total cost. If there are no open waypoints, this method returns
     * <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint() {
        if (openWaypoints.isEmpty()) {
            return null;
        } else {
            Waypoint minCostWaypoint = null;
            float minCost = Float.MAX_VALUE;
            for (Waypoint wp : openWaypoints.values()) {
                float totalCost = wp.getTotalCost();
                if (totalCost < minCost) {
                    minCostWaypoint = wp;
                    minCost = totalCost;
                }
            }
            return minCostWaypoint;
        }
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already in)
     * the "open waypoints" collection. If there is not already an open waypoint at
     * the new waypoint's location then the new waypoint is simply added to the
     * collection. However, if there is already a waypoint at the new waypoint's
     * location, the new waypoint replaces the old one <em>only if</em> the new
     * waypoint's "previous cost" value is less than the current waypoint's
     * "previous cost" value.
     **/
    public boolean addOpenWaypoint(Waypoint newWP) {
        Location loc = newWP.getLocation();
        if (!openWaypoints.containsKey(loc)) {
            openWaypoints.put(loc, newWP);
            return true;
        } else {
            Waypoint oldWP = openWaypoints.get(loc);
            if (newWP.getPreviousCost() < oldWP.getPreviousCost()) {
                openWaypoints.put(loc, oldWP);
                return true;
            }
            return false;
        }
    }

    /** Возвращает количество точке в наборе открытых вершин **/
    public int numOpenWaypoints() {
        return openWaypoints.size();
    }

    /**
     * метод перемещает область в список открытык точек to the closed list.
     **/
    public void closeWaypoint(Location loc) {
        Waypoint wp = openWaypoints.remove(loc);
        closedWaypoints.put(loc, wp);
    }

    /**
     * возвращает true, если набор закрытых точек содержит указанную область.
     **/
    public boolean isLocationClosed(Location loc) {
        return (closedWaypoints.keySet().contains(loc));
    }
}
