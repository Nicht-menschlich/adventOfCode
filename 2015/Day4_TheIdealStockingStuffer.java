package aoc2015;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import utils.Utils;

public class Day4_TheIdealStockingStuffer {
	
	public static void main(String[] args) {
		Utils utils = new Utils();
		part1(utils);
		part2(utils);
	}
	
	private static void part2(Utils utils) {
		String searchkey = utils.readFile("test.txt").get(0);
		int i = 0;
		while(true) {
			String md5 = getMD5(searchkey + i);
			if(md5.startsWith("000000")) {
				System.out.println(i);
				break;
			}
			i++;
		}
	}

	public static void part1(Utils utils) {
		String searchkey = utils.readFile("test.txt").get(0);
		int i = 0;
		while(true) {
			String md5 = getMD5(searchkey + i);
			if(md5.startsWith("00000")) {
				System.out.println(i);
				break;
			}
			i++;
		}
	}
	
	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageBytes = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageBytes);
			String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
