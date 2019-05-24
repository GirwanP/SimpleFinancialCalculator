package calcul;

import java.awt.BorderLayout;                             //use double, op*100000--> (op*10+nkey)
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MyLongCalculator extends JFrame {

	private static final int cmultiplier = 1000;
	
	private JPanel contentPane;
	private JTextField expressionText;
	private JTextField resultText;
	private JButton button_0;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_point;
	private JButton button_negate;
	private JButton button_equal;
	private JButton button_divide;
	private JButton button_multiply;
	private JButton button_minus;
	private JButton button_plus;
	private JButton button_BS;
	private JButton button_CE;
	private JButton button_C;
	
	
	private int multiplier;
	private String expression="";
	private String result="";
	private long oprn1=0;
	private long oprn2=0;
	private long res=0;
	
	private boolean decimalPressed=false;
	
	char oprtPrev='x';
	char oprtNew='x';
	boolean operatorPressed=false;
	boolean operatorRepeat=false;
	boolean equalPressed=false;
	
	boolean digitPressedAfterDecimal=false;
	
	boolean bsFirst=true;//cleared by bs with if().. reset by numclick,opclick

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyLongCalculator frame = new MyLongCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyLongCalculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getExpressionText());
		contentPane.add(getResultText());
		contentPane.add(getButton_0());
		contentPane.add(getButton_1());
		contentPane.add(getButton_2());
		contentPane.add(getButton_3());
		contentPane.add(getButton_4());
		contentPane.add(getButton_5());
		contentPane.add(getButton_6());
		contentPane.add(getButton_7());
		contentPane.add(getButton_8());
		contentPane.add(getButton_9());
		contentPane.add(getButton_point());
		contentPane.add(getButton_negate());
		contentPane.add(getButton_equal());
		contentPane.add(getButton_divide());
		contentPane.add(getButton_multiply());
		contentPane.add(getButton_minus());
		contentPane.add(getButton_plus());
		contentPane.add(getButton_BS());
		contentPane.add(getButton_CE());
		contentPane.add(getButton_C());
	}
	private JTextField getExpressionText() {
		if (expressionText == null) {
			expressionText = new JTextField();
			expressionText.setHorizontalAlignment(SwingConstants.RIGHT);
			expressionText.setBounds(0, 0, 417, 32);
			expressionText.setColumns(10);
		}
		return expressionText;
	}
	private JTextField getResultText() {
		if (resultText == null) {
			resultText = new JTextField();
			resultText.setHorizontalAlignment(SwingConstants.RIGHT);
			resultText.setColumns(10);
			resultText.setBounds(0, 33, 417, 32);
		}
		return resultText;
	}
	private JButton getButton_0() {
		if (button_0 == null) {
			button_0 = new JButton("0");
			button_0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					NumClicked((short)0);
					
				}
			});
			button_0.setBounds(81, 351, 57, 32);
		}
		return button_0;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("1");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					NumClicked((short)1);
					
				}
			});
			button_1.setBounds(10, 310, 57, 32);
		}
		return button_1;
	}
	private JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("2");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					NumClicked((short)2);
					
				}
			});
			button_2.setBounds(81, 310, 57, 32);
		}
		return button_2;
	}
	private JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton("3");
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					NumClicked((short)3);
					
				}
			});
			button_3.setBounds(152, 310, 57, 32);
		}
		return button_3;
	}
	private JButton getButton_4() {
		if (button_4 == null) {
			button_4 = new JButton("4");
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					NumClicked((short)4);
					
				}
			});
			button_4.setBounds(10, 267, 57, 32);
		}
		return button_4;
	}
	private JButton getButton_5() {
		if (button_5 == null) {
			button_5 = new JButton("5");
			button_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					NumClicked((short)5);
					
				}
			});
			button_5.setBounds(81, 267, 57, 32);
		}
		return button_5;
	}
	private JButton getButton_6() {
		if (button_6 == null) {
			button_6 = new JButton("6");
			button_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					NumClicked((short)6);
					
				}
			});
			button_6.setBounds(152, 267, 57, 32);
		}
		return button_6;
	}
	private JButton getButton_7() {
		if (button_7 == null) {
			button_7 = new JButton("7");
			button_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					NumClicked((short)7);
					
				}
			});
			button_7.setBounds(10, 223, 57, 32);
		}
		return button_7;
	}
	private JButton getButton_8() {
		if (button_8 == null) {
			button_8 = new JButton("8");
			button_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					NumClicked((short)8);
					
				}
			});
			button_8.setBounds(81, 223, 57, 32);
		}
		return button_8;
	}
	private JButton getButton_9() {
		if (button_9 == null) {
			button_9 = new JButton("9");
			button_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					NumClicked((short)9);
					
				}
			});
			button_9.setBounds(152, 223, 57, 32);
		}
		return button_9;
	}
	private JButton getButton_point() {
		if (button_point == null) {
			button_point = new JButton(".");
			button_point.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//=============update decimal flags========
					decimalPressed=true;
					displayUp();   					
				}
			});
			button_point.setBounds(152, 351, 57, 32);
		}
		return button_point;
	}
	private JButton getButton_negate() {
		if (button_negate == null) {
			button_negate = new JButton("-/+");
			button_negate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//========== negate numbers======
					res*=(-1);
					oprn2=res;
					oprn1=0;
					displayUp();   //========== negate numbers======
				}
			});
			button_negate.setBounds(10, 351, 57, 32);
		}
		return button_negate;
	}
	private JButton getButton_equal() {
		if (button_equal == null) {
			button_equal = new JButton("=");
			button_equal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("******  = sign pressed");
					calculateF();
					
					operatorPressed=false;
					operatorRepeat=false;
					decimalPressed=false;
					digitPressedAfterDecimal=false;
					//oprn1=0;  to this inside op/num pressed fun inside if(eqPressed){} stmt
					equalPressed=true;
					//not compulsory
					oprtNew='x';
					oprtPrev='x';
					displayUp();
					System.out.println(" = sign press Exit");
				}
			});
			button_equal.setBounds(227, 351, 57, 32);
		}
		return button_equal;
	}
	private JButton getButton_divide() {
		if (button_divide == null) {
			button_divide = new JButton("-:-");
			button_divide.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					operatorClicked('/');
				}
			});
			button_divide.setBounds(227, 182, 57, 32);
		}
		return button_divide;
	}
	private JButton getButton_multiply() {
		if (button_multiply == null) {
			button_multiply = new JButton("*");
			button_multiply.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					operatorClicked('*');
				}
			});
			button_multiply.setBounds(227, 226, 57, 32);
		}
		return button_multiply;
	}
	private JButton getButton_minus() {
		if (button_minus == null) {
			button_minus = new JButton("-");
			button_minus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					operatorClicked('-');
				}
			});
			button_minus.setBounds(227, 269, 57, 32);
		}
		return button_minus;
	}
	private JButton getButton_plus() {
		if (button_plus == null) {
			button_plus = new JButton("+");
			button_plus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					operatorClicked('+');
				}
			});
			button_plus.setBounds(227, 310, 57, 32);
		}
		return button_plus;
	}
	private JButton getButton_BS() {
		if (button_BS == null) {
			button_BS = new JButton("<-BS");
			button_BS.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//==========================================
					System.out.println("================================================");
					System.out.println("Back Button Pressed Enter");
					System.out.println("res ="+res+" oprn1="+oprn1+" oprn2="+oprn2+" oprtPrev="+oprtPrev+" oprtNew="+oprtNew);
					
					if(oprn1!=0) {
						if(multiplier<cmultiplier){        //	this block executed when (multiplier<cmultiplier)
								System.out.println("multiplier="+multiplier);
								multiplier*=10;
								oprn1=oprn1/multiplier;  //for decimal nos?/?
								System.out.println("oprn1 ="+oprn1+"   multiplier ="+multiplier);
								oprn1*=multiplier;
								System.out.println("oprn1="+oprn1+"  multiplier ="+multiplier);		
//							if(oprn1==0) {
//								digitPressedAfterDecimal=false;
//								System.out.println("Effective value of oprn1 is 0");
//							}
					
						}else if(multiplier==cmultiplier){
							//this block to be executed when (multiplier=cmultiplier) //just clear the decimal here
							    if(decimalPressed) {
							    	decimalPressed=false;
							    	digitPressedAfterDecimal=false;
							    }else {
							    	oprn1/=10*multiplier;
							    	oprn1*=multiplier;
							    }
						}
						calculateF();
						displayUp();
						
						}else { // when oprn1==0,  clear the operator pressed, make oprn1=oprn2
							if(multiplier<cmultiplier) {
								multiplier*=10;
								System.out.println("Effective value of oprn1 is 0");
							}else {
								///jpt
								if(decimalPressed) {
									decimalPressed=false;
									digitPressedAfterDecimal=false;
								}else {
								oprn1=oprn2;
								oprn2=0;
								oprtNew='x';
								oprtPrev='x';
								
								operatorPressed=false;
								operatorRepeat=false;
								equalPressed=false;
								}
							}
							
						}
					
					
					System.out.println("res ="+res+" oprn1="+oprn1+" oprn2="+oprn2+" oprtPrev="+oprtPrev+" oprtNew="+oprtNew);
					//==========================================
					System.out.println("Back Button Pressed Exited");
				}
			});
			button_BS.setBounds(152, 182, 57, 32);
		}
		return button_BS;
	}
	private JButton getButton_CE() {
		if (button_CE == null) {
			button_CE = new JButton("CE");
			button_CE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					res=oprn2;   //decimalPressed?????????????????
					oprn1=0;
					displayUp();
					decimalPressed=false;
					digitPressedAfterDecimal=false;
					System.out.println("decimal pressed ="+decimalPressed);
					System.out.println("************************** CE exit");
				}
			});
			button_CE.setBounds(81, 182, 57, 32);
		}
		return button_CE;
	}
	private JButton getButton_C() {
		if (button_C == null) {
			button_C = new JButton("C");
			button_C.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//reset all parameter
					expression="";
					result="";
					oprn1=0;
					oprn2=0;
					res=0;
					
					decimalPressed=false;
					digitPressedAfterDecimal=false;
					oprtPrev='x';
					oprtNew='x';
					operatorPressed=false;
					operatorRepeat=false;
					equalPressed=false;
					
					displayUp();
				}
			});
			button_C.setBounds(10, 182, 57, 32);
		}
		return button_C;
	}
	
	
	//private void decimalClicked(){}
	
	
	private void NumClicked(Short btnId) {
		System.out.println("");
		System.out.println("=====================");
		System.out.println("NumClicked called");
		System.out.println("res ="+res+" oprn1="+oprn1+" oprn2="+oprn2+" oprtPrev="+oprtPrev+" oprtNew="+oprtNew);
		//****************************************
		if(equalPressed) {
			res=0;
			oprn2=0;
			oprn1=0;
			equalPressed=false;
		}
		
		if(operatorRepeat) {
			oprtPrev=oprtNew;  //either this or inside if(operatoprpressed)(when true) statement
			oprtNew='x';
		}
		operatorRepeat=false;
	
		
		if(oprn1==0) {
			
			if(decimalPressed) {
				if(!digitPressedAfterDecimal) {
					multiplier=cmultiplier/10;// first time only
					digitPressedAfterDecimal=true;
					//if(btnId!=0){}     where to place this line of code?
				}
												//rest of the time
				else{
					multiplier=multiplier/10;
					
				}
				
			}else{
				multiplier=cmultiplier;
				}
			
			oprn1=multiplier*btnId;
		}else {
			if(decimalPressed){
				 multiplier/=10;
				oprn1=oprn1+multiplier*btnId;  // multiplier/=10;
			}else {
			oprn1=oprn1*10+btnId*multiplier;
			}	
		}
		
		//calculate and display
		
		if(operatorPressed) {	
			calculateF();
			}
		displayUp();
		
		System.out.println("res ="+res+" oprn1="+oprn1+" oprn2="+oprn2+" oprtPrev="+oprtPrev+" oprtNew="+oprtNew);
		//==========================================
		System.out.println("NumClicked Exited");
		System.out.println("=====================");
		System.out.println("");
	}
	
	private void operatorClicked(char opr) {
		
		System.out.println("");
		System.out.println("===================================");
		System.out.println("operatorClicked called");
		System.out.println("res ="+res+" oprn1="+oprn1+" oprn2="+oprn2+" oprtPrev="+oprtPrev+" oprtNew="+oprtNew);
		
		//=====================================================
		// calculate if one operator was previously pressed
		//opn=opr;
		
		decimalPressed=false;
		digitPressedAfterDecimal=false;
		
		if(equalPressed) {
			equalPressed=false; //think:*** not using if(){} for this --write directly
			oprn1=0;
		}
		
		if(operatorRepeat) {
				oprtNew=opr;
				displayUp();
		}else {
				operatorRepeat=true;
				if(operatorPressed) {
					//oprtPrev=oprtNew;
					calculateF();
					oprtNew=opr;
					displayUp();
					oprn2=res;
					oprn1=0;
					//jpt
				}else {   //need to debug=========== not working with = sign
					oprn2=oprn1;   //==============
					res=oprn1;
					oprn1=0;
					oprtNew=opr;
					operatorPressed=true;
					displayUp();
					
				}
		}
		
		//===================================
//		if(operatorPressed) {
//			calculateF();
//		}
		//oprtPrev=opr;
		operatorPressed=true; 
	
		displayUp();
			
	//=================================================
		System.out.println("res ="+res+" oprn1="+oprn1+" oprn2="+oprn2+" oprtPrev="+oprtPrev+" oprtNew="+oprtNew);
		System.out.println("operatorClicked Exit");
		System.out.println("===================================");
		System.out.println("");		
	}
	private void calculateF() {
		System.out.println("");
		System.out.println("========================================");
		System.out.println("calculateF called");
		System.out.println("res ="+res+" oprn1="+oprn1+" oprn2="+oprn2+" oprtPrev="+oprtPrev+" oprtNew="+oprtNew);
		//*******************************************************
		switch (oprtPrev) {
		case '+':res=oprn2+oprn1;
			break;
		case '-':res=oprn2-oprn1;
			break;
		case '*':res=(oprn2*oprn1)/cmultiplier;
			break;
		case '/':res=(oprn2*cmultiplier)/oprn1;
			break;
		default: System.out.println("error inside operator switch case occured");
			break;
		}
		
		//oprn2=res;
		//oprn1=0;
		//operatorPressed=false; each number pressing will cause this reset	
		//***************************************************************8
		System.out.println("res ="+res+" oprn1="+oprn1+" oprn2="+oprn2+" oprtPrev="+oprtPrev+" oprtNew="+oprtNew);
		System.out.println("calculateF Exit");
		System.out.println("========================================");
		System.out.println("");
	}
	
	private void displayUp() {
//		System.out.println("");
		System.out.println("==========================================");
		System.out.println("displayUp called");
//===================================================
		/*      //display code will go here
		 * 
		res=res/cmultiplier;
		long did=10000000000l;
		long rLow=res%did;
		long rHigh=res/did;
		int riLow=(int)rLow;
		int riHigh=(int)rHigh;

		
		result=Integer.toString(riHigh);
		result=result.concat(Integer.toString(riLow));
		
		System.out.println("result = "+res);
		
		*/
		//====================================================
		System.out.println("res ="+res+" oprn1="+oprn1+" oprn2="+oprn2+" oprtPrev="+oprtPrev+" oprtNew="+oprtNew);
		System.out.println("==========================================");
		System.out.println("");
	}
	
}
