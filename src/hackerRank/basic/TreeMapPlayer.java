//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class TreeMapPlayer {
//
//	private static final String Player = null;
//
//	public static void main(String[] args) {
//		Map<Integer, Player> playerMap = new HashMap<>();
//		playerMap.put(1, new Player("Ronaldo", 3, 40.6));
//		playerMap.put(2, new Player("Ronnie", 5, 44.8));
//		playerMap.put(4, new Player("Bale", 7, 55.7));
//		playerMap.put(3, new Player("Benzema", 7, 55.7));
//		playerMap.put(5, new Player("Nani", 5, 44.7));
//		playerMap.put(6, new Player("Mata", 2, 39.8));
//
////		System.out.println(playerMap);
//		System.out.println(getMapOfSelectedPlayers(playerMap));
//
//	}
//
//	public static TreeMap<Player, Integer> getMapOfSelectedPlayers(Map<Integer, Player> playerMap) {
//		TreeMap<Player, Integer> resMap = new TreeMap<>();
//		List<Player> list1 = new ArrayList<Player>();
//
//		for (Player p : playerMap.values()) {
//			list1.add(p);
//		}
//
//		Collections.sort(list1);
//		for (Player p : list1) {
//
//			System.out.println("Playername: " + p.getPlayerName() + "	|| noOfGoals: " + p.getNoOfGoals()
//					+ "	|| average: " + p.getAverage());
//			resMap.put(p, p.getNoOfGoals());
//		}
//		return resMap;
//
//	}
//}
//
//class Player implements Comparable<Player> {
//
//	private String playerName;
//	private Integer noOfGoals;
//	private double average;
//
//	public Player(String playerName, Integer noOfGoals, double average) {
//		super();
//		this.playerName = playerName;
//		this.noOfGoals = noOfGoals;
//		this.average = average;
//	}
//
//	public String getPlayerName() {
//		return playerName;
//	}
//
//	public void setPlayerName(String playerName) {
//		this.playerName = playerName;
//	}
//
//	public Integer getNoOfGoals() {
//		return noOfGoals;
//	}
//
//	public void setNoOfGoals(Integer noOfGoals) {
//		this.noOfGoals = noOfGoals;
//	}
//
//	public double getAverage() {
//		return average;
//	}
//
//	public void setAverage(double average) {
//		this.average = average;
//	}
//
//	@Override
//	public int compareTo(Player o) {
//		
//		if(noOfGoals == o.noOfGoals) {
//			if(average==o.average) {
//				return this.playerName.compareTo(o.getPlayerName());
//			}
//			else if(average>o.average) {
//				return -1;
//			}
//			else {
//				return 1;
//			}
//		}
//		else if(o.noOfGoals<noOfGoals) {
//			return -1;
//		}
//		return 1;
//	}
//	
//	
//}