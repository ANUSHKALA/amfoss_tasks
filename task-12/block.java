package net.javacode;

import java.util.*;

public class main{
	
	
	ArrayList<block> blockchain = new ArrayList<>();
	
	public static void main(String[] args) {
		
		String[] genesisTransactions = {"lia sent 10000 bitcoins to jenni","jin sent 23 bitcoins to giselle"};
		block genesisBlock = new block(0, genesisTransactions);
		
		String[] block2Transactions = {"ram sent 14 bitcoins to mohit","mohit sent 27 bitcoins to charan"};
		block block2 = new block(genesisBlock.getBlockHash(), block2Transactions);
		
		
		String[] block3Transactions = {"mohit sent 77 bitcoins to aryan","ardra sent 36 bitcoins to aryan"};
		block block3 = new block(genesisBlock.getBlockHash(), block3Transactions);
		
		
		System.out.println("Hash of genesis block: ");
		System.out.println(genesisBlock.getBlockHash());
		
		System.out.println("Hash of block2: ");
		System.out.println(block2.getBlockHash());
		
		System.out.println("Hash of block3: ");
		System.out.println(block3.getBlockHash());
		
	}
	
	
}
