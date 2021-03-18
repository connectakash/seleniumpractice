package com.mindtree.bigbasket.utilities;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressBar {

	static JProgressBar b;
	
	public void setUpProgressBar(int testNo) {
		JFrame f=new JFrame("Test Progress Bar");
		JPanel p=new JPanel();
		b=new JProgressBar(0,testNo);
		
		b.setValue(0);
		b.setStringPainted(true);
		
		p.add(b);
		
		f.add(p);
		f.setSize(250, 100);
		f.setVisible(true);
	}
	
	public void increaseProgressBar() {
		b.setValue(b.getValue()+1);
	}

}
