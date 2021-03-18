package com.mindtree.bigbasket.utilities;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressbarNew {
	
	JProgressBar b;

	public void setUp(int n) {
		JFrame f=new JFrame("Test Progress");
		JPanel p=new JPanel();
		
		b=new JProgressBar(0,n);
		
		b.setValue(0);
		b.setStringPainted(true);

		p.add(b);
		
		f.add(p);
		
		f.setSize(300,200);
		f.setVisible(true);
	}
	
	public void increaseBar() {
		b.setValue(b.getValue()+1);
	}

}
