package net.javacode;

import java.util.*;

public class main{
	
	
	ArrayList<block> blockchain = new ArrayList<>();
	
	public static void main(String[] args) {
		
		String[] genesisTransactions = {"someone sent 10000 bitcoins to another_person","anyone sent 23 bitcoins to another_person"};
		block genesisBlock = new block(0, genesisTransactions);
		
		String[] block2Transactions = {"another_person sent 14 bitcoins to someone","another_person sent 27 bitcoins to anyone"};
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
